package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qcyw.xchqcyws.common.controller.BaseController;
import qcyw.xchqcyws.common.domain.AjaxResult;
import qcyw.xchqcyws.common.untils.UUIDGenerator;
import qcyw.xchqcyws.entity.*;
import qcyw.xchqcyws.service.AddressService;
import qcyw.xchqcyws.service.MyCartService;
import qcyw.xchqcyws.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * 棋茶一味订单 -控制层
 *
 * @author LUW
 * @date 2022/7/29
 * @Description
 */
@Api(tags = "OrderController")
@RestController
@RequestMapping("/OrderController")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MyCartService myCartService;

    /**
     * 订单确认
     */
    @ApiOperation(value = "订单确认")
    @PostMapping("/add")
    public AjaxResult add(@RequestParam("openid") String openid) {
        try {
            List<MyCartViews> myCartList = myCartService.getMyCartLists(openid);
            Orders orders = new Orders();
            OrdersSon ordersSon = new OrdersSon();
            //随机生产uuid,保存到订单主表和订单子表中，后面做关联
            String uuid = UUIDGenerator.getUUID();
            orders.setOrdersId(uuid);
            orders.setOpenid(myCartList.get(0).getMmOpenid());
            orders.setDelFlag(1);
            orders.setOrderStatus(1);
            double payablePrice = 0;
            for(int i=0;i<myCartList.size();i++){
                ordersSon.setDelFlag(1);
                ordersSon.setGoodsNum(myCartList.get(i).getMmCartNum());
                ordersSon.setGoodsPic(myCartList.get(i).getAaAnnexName());
                ordersSon.setGoodsPrice(myCartList.get(i).getGmMemberPrice());
                ordersSon.setGoodsSpecs(myCartList.get(i).getCcCompanyName());
                ordersSon.setOrderSonId(UUIDGenerator.getUUID());
                ordersSon.setOrderSonName(myCartList.get(i).getGmModelName());
                ordersSon.setOrdersIds(uuid);
                ordersSon.setOrdersName(myCartList.get(i).getSsGoodsName());
                payablePrice+=myCartList.get(i).getMmCartNum()*myCartList.get(i).getGmMemberPrice();
                orderService.insertOrderSort(ordersSon);
            }
            orders.setPayablePrice(payablePrice);
            orderService.insertOrder(orders);
            return AjaxResult.success("订单确认成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("订单确认错误");
    }


    /**
     * 获取订单列表信息
     *
     * @return
     */
    @ApiOperation(value = "获取订单列表信息")
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("openid") String openid) {
        try {
            List<Orders> orderList = orderService.getOrderList(openid);
            return AjaxResult.success("OK", orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("获取订单列表信息错误");
    }
}
