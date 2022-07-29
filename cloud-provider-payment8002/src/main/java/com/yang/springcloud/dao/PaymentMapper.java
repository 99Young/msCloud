package com.yang.springcloud.dao;

import com.yang.springcloud.base.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMapper {

    /**
     * 插入
     * @param payment
     * @return
     */
    int insert(Payment payment);

    /**
     * 根据ID查询订单
     */
    Payment getPaymentById(@Param("id") Long id);

}
