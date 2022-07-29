package com.yang.springcloud.controller;

import com.yang.springcloud.base.entity.Payment;
import com.yang.springcloud.base.util.CommonResult;
import com.yang.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment param) {
        if(param == null){
            return new CommonResult(6001,"传入参数无效");
        }
        Boolean result = paymentService.createPayment(param);
        return new CommonResult(result);
    }

    @PostMapping("/getPaymentById")
    public CommonResult getPaymentById(@RequestBody Payment param) {
        if(param == null){
            return new CommonResult(6001,"传入参数无效");
        }
        if(param.getId()==null){
            return new CommonResult(6001,"Id不能为空111");
        }
        param = paymentService.getPaymentById(param.getId());
        return new CommonResult(param);
    }

}
