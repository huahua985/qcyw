package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qcyw.xchqcyws.common.controller.BaseController;
import qcyw.xchqcyws.common.domain.AjaxResult;
import qcyw.xchqcyws.common.untils.UUIDGenerator;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Orders;
import qcyw.xchqcyws.service.AddressService;
import qcyw.xchqcyws.service.OrderService;

import java.util.List;

/**
 * 棋茶一味订单 -控制层
 *
 * @date 2022/7/29
 * @Description
 */
@Api(tags = "OrderController")
@RestController
@RequestMapping("/OrderController")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;
    /**
     * 获取订单列表信息
     *
     * @return
     */
    @ApiOperation(value = "获取订单列表信息")
    @GetMapping("/list")
    public AjaxResult list(Orders orders) {
        try {
            List<Orders> orderList = orderService.getOrderList(orders);
            return AjaxResult.success("OK",orderList);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return AjaxResult.error("获取订单列表信息错误");
    }

    /**
     * 订单确认
     */
    @ApiOperation(value = "订单确认")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Orders orders) {
        try {
            orders.setId(UUIDGenerator.getUUID());
            orders.setDelFlag("1");
            //myCart.setUserId();
            //myCart.setCreateBy();
            orderService.insertOrder(orders);
            return AjaxResult.success("订单确认成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("订单确认错误");
    }

}
