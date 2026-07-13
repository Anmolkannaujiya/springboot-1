package com.Anmol.demo.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderService {

    @Autowired
    PaymentService paymentService;

    //if only one constructor than wtiting autowired is not mandatory
    //if multiple then i have to tell spring that wiring is done with the help of which constructor

    OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    //setter
    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    public void placeOrder(){

        paymentService.pay();
        System.out.println("Order placed");
    }
}
