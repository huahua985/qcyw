package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Orders;
import qcyw.xchqcyws.entity.OrdersSon;
import qcyw.xchqcyws.mapper.AddressMapper;
import qcyw.xchqcyws.mapper.OrderMapper;
import qcyw.xchqcyws.service.AddressService;
import qcyw.xchqcyws.service.OrderService;

import java.util.List;

/**
 * @author LUW
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Orders> getOrderList(String openid) {
        return orderMapper.getOrderList(openid);
    }

    @Override
    public void insertOrder(Orders orders) {
        orderMapper.insertOrder(orders);
    }

    @Override
    public void insertOrderSort(OrdersSon ordersSon) {
        orderMapper.insertOrderSort(ordersSon);
    }
}
