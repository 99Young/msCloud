package com.yang.springcloud.service.impl;

import com.yang.springcloud.base.entity.Payment;
import com.yang.springcloud.dao.PaymentMapper;
import com.yang.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public Boolean createPayment(Payment payment) {
        return paymentMapper.insert(payment)>0;
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
