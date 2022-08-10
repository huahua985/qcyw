package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Orders;
import qcyw.xchqcyws.entity.OrdersSon;

import java.util.List;
/**
 * @author LUW
 */
@Mapper
@Repository
public interface OrderMapper {

    /**获取订单列表信息
     *  @param openid
     *  @return 获取订单列表信息
     *
     * */
    List<Orders> getOrderList(String openid);

    /**订单确认
     *  @param orders
     *  @return 订单确认
     * */
    void insertOrder(Orders orders);

    /**订单确认
     *  @param ordersSon
     *  @return 订单确认
     * */
    void insertOrderSort(OrdersSon ordersSon);
}
