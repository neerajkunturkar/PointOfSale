package com.pos.app.services.vendor;

import com.pos.app.model.core.User;
import com.pos.app.model.inventory.ProductUpc;
import com.pos.app.model.order.CartDetail;
import com.pos.app.model.order.CartProductDetail;
import com.pos.app.model.order.TaxBracket;
import com.pos.app.repository.inventory.ProductUpcRepository;
import com.pos.app.repository.order.CartDetailRepository;
import com.pos.app.repository.order.CartProductDetailRepository;
import com.pos.app.repository.order.TaxBracketRepository;
import com.pos.core.util.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 4/14/18.
 */
@Service
public class VendorService {

    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Autowired
    private ProductUpcRepository productUpcRepository;
    @Autowired
    private TaxBracketRepository taxBracketRepository;
    @Autowired
    private CartProductDetailRepository cartProductDetailRepository;

    public CartDetail createCartDetail() throws Exception{

        CartDetail cartDetail = new CartDetail();
        cartDetail.setStatus(CartDetail.Status.INPROGRESS);
        cartDetail.setBillDate(new Date());
        cartDetail = cartDetailRepository.save(cartDetail);
        return cartDetail;
    }

    public CartDetail getCartDetail(Long cartId){
        return cartDetailRepository.findOne(cartId);
    }

    public CartDetail getMyCartDetail(Long cartId){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return cartDetailRepository.findByStatusAndCreatedByAndId(cartId, CartDetail.Status.INPROGRESS.name(), user.getId());
    }

    public ProductUpc getProductUpc(String upc){
        return productUpcRepository.findByUpc(upc);
    }
    public CartDetail addProductToCart(CartDetail cartDetail, ProductUpc productUpc, int quantity) throws AppException {

        if(productUpc == null){
            throw new AppException("incorrectUpc");
        }

        Long productId = productUpc.getProductSku().getProduct().getId();
        CartProductDetail cartProductDetail = cartDetail.getCartProductDetails().stream()
                .filter(cp -> productId == cp.getProduct().getId())
                .findFirst()
                .orElse(null);
        boolean foundProduct = !(cartProductDetail == null);
        if(cartProductDetail == null) {
            cartProductDetail = new CartProductDetail();
            cartProductDetail.setCartDetail(cartDetail);
            cartProductDetail.setProduct(productUpc.getProductSku().getProduct());
            cartProductDetail.setQuantity(quantity);
            cartProductDetail.setUnitPrice(productUpc.getProductPrice().getPrice());
            cartProductDetail.setUnitTax(getTaxAmount(productUpc));
        } else {
            cartProductDetail.setQuantity(cartProductDetail.getQuantity() + quantity);
        }
        cartProductDetail.setUnitPrice(productUpc.getProductPrice().getPrice());
        cartProductDetail.setUnitTax(getTaxAmount(productUpc));
        cartProductDetail.setTotalAmount();
        cartProductDetail.setTotalTax();

        cartProductDetail = cartProductDetailRepository.save(cartProductDetail);
        if(!foundProduct){
            cartDetail.getCartProductDetails().add(cartProductDetail);
        }
        Double totalPrice = cartDetail.getCartProductDetails().stream().mapToDouble(p-> p.getTotalPrice()).sum();
        Double totalTax = cartDetail.getCartProductDetails().stream().mapToDouble(p -> p.getTotalTax()).sum();

        cartDetail.setTotalAmount(totalPrice + totalTax);
        cartDetail.setTotalItems(cartDetail.getCartProductDetails().stream().mapToInt(p -> p.getQuantity()).sum());
        cartDetail = cartDetailRepository.save(cartDetail);
        updateInventory(productUpc, quantity);
        return cartDetail;
    }

    private void updateInventory(ProductUpc productUpc, int quantity) {
        productUpc.setInventoryStock(productUpc.getInventoryStock() - quantity);
        productUpcRepository.save(productUpc);
    }

    private Double getTaxAmount(ProductUpc productUpc) {
        TaxBracket taxBracket = taxBracketRepository.findByProductId(productUpc.getProductSku().getProduct().getId());
        Double taxAmount = 0.0;
        if(taxBracket!=null && TaxBracket.Unit.PERCENTAGE.equals(taxBracket.getUnit())){
            taxAmount = (taxBracket.getApplicableTax() * productUpc.getProductPrice().getPrice() / 100);
        }
        return taxAmount;
    }

    public CartDetail generateBill(Long cartId) throws Exception{

        CartDetail cartDetail = getCartDetail(cartId);
        if (cartDetail == null) {
            throw new AppException("cartRestoreError");
        }
        cartDetail.setStatus(CartDetail.Status.COMPLETED);
        cartDetail = cartDetailRepository.save(cartDetail);
        return cartDetail;
    }

    public List<CartDetail> myBills(String status) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List mybills = cartDetailRepository.findAllByStatusAndCreatedBy(status, loggedInUser.getId());
        return mybills;
    }
}
