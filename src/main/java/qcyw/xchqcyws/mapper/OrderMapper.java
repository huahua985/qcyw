package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Orders;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    //获取订单列表信息
    List<Orders> getOrderList(Orders orders);

    //订单确认
    void insertOrder(Orders orders);
}
