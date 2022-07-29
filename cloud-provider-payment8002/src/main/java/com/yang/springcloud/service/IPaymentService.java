package com.yang.springcloud.service;

import com.yang.springcloud.base.entity.Payment;

public interface IPaymentService {

    Boolean createPayment(Payment payment);

    Payment getPaymentById(Long id);


}
