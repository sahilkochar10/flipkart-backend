package com.onlineshopping.flipkart.service;

import com.onlineshopping.flipkart.entity.OrderDetails;
import com.onlineshopping.flipkart.entity.Products;

public class OrderDetailService {
    public static OrderDetails convertToOrderDetail(com.onlineshopping.flipkart.vo.OrderDetails orderDetailsVo) {
        com.onlineshopping.flipkart.entity.OrderDetails orderDetail = new com.onlineshopping.flipkart.entity.OrderDetails();
        Products product = new Products();
        product.setProductID(orderDetailsVo.getProductID());
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVo.getQuantity());
        return orderDetail;
    }
}
