create unique index isku_code on product_sku(`sku_code`);
create unique index iupc_code on product_upc(`upc`);

create index isku_prd on product_sku(`sku`, `product_id`);
create index iskuprd on product_sku(`product_id`);

create index iupc_prd on product_upc(`upc`, `product_sku_id`);
create index iupcprd on product_upc(`product_sku_id`);
create index iupcprz on product_upc(`product_price_id`);
