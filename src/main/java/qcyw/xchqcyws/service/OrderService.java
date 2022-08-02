package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Orders;

import java.util.List;

public interface OrderService {
    //获取订单列表信息
    List<Orders> getOrderList(Orders orders);

    //确认订单
    void insertOrder(Orders orders);
}
