package com.omercan.ecommerce.controller;

import com.omercan.ecommerce.dto.Purchase;
import com.omercan.ecommerce.dto.PurchaseResponse;
import com.omercan.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        return checkoutService.placeOrder(purchase);
    }

    //Productları kaydetmek için saveALll eklenebilir
}
