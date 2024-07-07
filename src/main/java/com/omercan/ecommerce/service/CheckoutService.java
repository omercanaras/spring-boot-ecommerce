package com.omercan.ecommerce.service;

import com.omercan.ecommerce.dto.Purchase;
import com.omercan.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
