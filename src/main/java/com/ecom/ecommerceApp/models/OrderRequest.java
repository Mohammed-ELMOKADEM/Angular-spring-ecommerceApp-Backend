package com.ecom.ecommerceApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderRequest {
    private Integer userId;
    private Integer idProduct;
}
