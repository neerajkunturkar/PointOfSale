package com.pos.app.controller;

import com.pos.app.dto.ErrorDto;
import com.pos.app.dto.inventory.ProductUpcDto;
import com.pos.app.dto.order.CartDetailDto;
import com.pos.app.dto.order.CartProductDetailDto;
import com.pos.app.dto.order.CartProductDto;
import com.pos.app.model.core.User;
import com.pos.app.model.inventory.ProductUpc;
import com.pos.app.model.order.CartDetail;
import com.pos.app.model.order.CartProductDetail;
import com.pos.app.services.vendor.VendorService;
import com.pos.core.util.exception.AppException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by admin on 4/13/2018.
 */

@RestController
@RequestMapping(value = "/vendorOutlet")
public class VendorOutletController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/createCart", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> createCart() throws Exception {

        CartDetail cartDetail = vendorService.createCartDetail();
        CartDetailDto cartDetailDto = convertToDto(cartDetail);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cartDetailDto);
    }

    private CartDetailDto convertToDto(CartDetail cartDetail) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cartDetail, CartDetailDto.class);
    }

    @RequestMapping(value = "/{cartId}/addToCart", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addProductToCart(@RequestBody final CartProductDto cartProductDto,
                                           @PathVariable("cartId") Long cartId) throws Exception {
        String error = null;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            CartDetail cartDetail = vendorService.getMyCartDetail(cartId);
            if (cartDetail == null) {
                throw new AppException("cartRestoreError");
            }
            ProductUpc productUpc = vendorService.getProductUpc(cartProductDto.getUpc());
            cartDetail = vendorService.addProductToCart(cartDetail, productUpc, cartProductDto.getQuantity());
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(convertToDto(cartDetail));
        } catch (AppException e){
            error = messageSource.getMessage(e.getMessageCode(), null, new Locale(user.getLocale()));
        }

        ErrorDto errorDto = new ErrorDto();
        errorDto.setError(error);
        errorDto.setMessage(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    @RequestMapping(value = "/{cartId}/generateBill", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> generateBill(@PathVariable("cartId") Long cartId) throws Exception {
        CartDetail cartDetail = vendorService.generateBill(cartId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(convertToDto(cartDetail));
    }

    @RequestMapping(value = "/{status}/myBills", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> myBills(@PathVariable("status") String status) throws Exception {
        List<CartDetail> cartDetail = vendorService.myBills(status);
        List<CartDetailDto> cartDetailDtoList = cartDetail.stream()
                .map(cart-> convertToDto(cart))
                .collect(Collectors.toList());

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cartDetailDtoList);
    }

}
