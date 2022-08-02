package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qcyw.xchqcyws.common.controller.BaseController;
import qcyw.xchqcyws.common.domain.AjaxResult;
import qcyw.xchqcyws.common.untils.UUIDGenerator;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.MyCart;
import qcyw.xchqcyws.service.MyCartService;

import java.util.List;

/**
 * 棋茶一味购物车 -控制层
 *
 * @date 2022/7/27
 * @Description
 */
@Api(tags = "MyCartController")
@RestController
@RequestMapping("/MyCartController")
public class MyCartController extends BaseController {

    @Autowired
    private MyCartService myCartService;
    /**
     * 获取购物车列表信息
     *
     * @return
     */
    @ApiOperation(value = "获取购物车列表信息")
    @GetMapping("/list")
    public AjaxResult list(String userId) {
        try {
            List<MyCart> myCartList = myCartService.getMyCartList(userId);
            return AjaxResult.success("OK",myCartList);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return AjaxResult.error("获取购物车列表信息错误");
    }

    /**
     * 新增购物车
     */
    @ApiOperation(value = "新增购物车")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Goods goods) {
        try {
        MyCart myCart = new MyCart();
        System.out.println(UUIDGenerator.getUUID().length());
        myCart.setCardId(UUIDGenerator.getUUID());
        //0代表未支付
        myCart.setBuyStatus("0");
        myCart.setCartNum(goods.getGoodsNum());
        myCart.setGoodsId(goods.getGoodsId());
        myCart.setGoodsName(goods.getGoodsName());
        myCart.setGoodsPic(goods.getGoodsPic());
        myCart.setGoodsPrice(goods.getGoodsPrice());
        myCart.setGoodsSpecs(goods.getGoodsSpecs());
        myCart.setDelFlag("1");
        //myCart.setUserId();
        //myCart.setCreateBy();
        myCartService.insertMyCart(myCart);
        return AjaxResult.success("新增购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("新增购物车错误");
    }

    /**
     * 清空购物车
     */
    @ApiOperation(value = "清空购物车")
    @PutMapping("/delete")
    public AjaxResult delete(@RequestBody MyCart myCart) {
        try {
            myCart.setDelFlag("0");
            myCartService.updateMyCart(myCart);
            return AjaxResult.success("清空购物车成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("清空购物车错误");
    }

    /**
     * 购物车数量增减
     */
    @ApiOperation(value = "购物车数量增减")
    @PutMapping("/numAddDelete")
    public AjaxResult numAddDelete(@RequestBody MyCart myCart) {
        try {
            //增加数量
            int addNum =  Integer.parseInt(myCart.getAddNum());
            //减少数量
            int deleteNum = Integer.parseInt(myCart.getDeleteNum());
            //购物车商品数量
            int cartNum = Integer.parseInt(myCart.getCartNum());
            int cartNums = cartNum+addNum-deleteNum;
            myCart.setCartNum(Integer.toString(cartNums));
            myCartService.updateMyCart(myCart);
            return AjaxResult.success("购物车数量增减成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("购物车数量增减错误");
    }

}
