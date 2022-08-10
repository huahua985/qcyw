package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qcyw.xchqcyws.common.controller.BaseController;
import qcyw.xchqcyws.common.domain.AjaxResult;
import qcyw.xchqcyws.common.untils.StringUtils;
import qcyw.xchqcyws.entity.MyCart;
import qcyw.xchqcyws.entity.MyCartView;
import qcyw.xchqcyws.service.MyCartService;

import java.util.List;

/**
 * 棋茶一味购物车 -控制层
 *
 * @author LUW
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
     * 加入购物车
     */
    @ApiOperation(value = "加入购物车")
    @PostMapping("/add")
    public AjaxResult add(@RequestParam("openid") String openid,
                          @RequestParam("goodsId") String goodsId,
                          @RequestParam("cartNum") String cartNum
    ) {
        try {
            MyCart myCart = new MyCart();
            if (myCartService.getMyCartId(goodsId) != null) {
                myCart = myCartService.getMyCartId(goodsId);
            }
            //如果购物车已存在该商品则继续叠加
            if (myCart != null) {
                myCart.setCartNum(Integer.parseInt(cartNum) + myCart.getCartNum());
                myCartService.updateMyCart(myCart);
            }
            //如果购物车不存在该商品则添加该商品
            else {
                MyCart myCart1 = new MyCart();
                myCart1.setGoodsId(goodsId);
                myCart1.setOpenid(openid);
                myCart1.setCartNum(Integer.parseInt(cartNum));
                myCart1.setDelFlag("1");
                myCartService.insertMyCart(myCart1);
            }
            return AjaxResult.success("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("加入购物车错误");
    }

    /**
     * 购物车数量-1
     */
    @ApiOperation(value = "购物车数量-1")
    @PutMapping("/numReduces")
    public AjaxResult numReduces(@RequestParam("openid") String openid,
                                 @RequestParam("id") String id) {
        try {
            MyCart myCart = new MyCart();
            //增加数量
            if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(openid)) {
                if (myCartService.getMyCartIds(id, openid) != null) {
                    myCart = myCartService.getMyCartIds(id, openid);
                    int addNum = myCart.getCartNum();

                    if (--addNum > 0) {
                        myCart.setCartNum(addNum);
                        myCartService.updateMyCart(myCart);
                        return AjaxResult.success("OK");
                    } else {
                        return AjaxResult.error("是否继续删除，继续商品为0");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("购物车数量增加1错误");
    }

    /**
     * 购物车数量+1
     */
    @ApiOperation(value = "购物车数量+1")
    @PutMapping("/numAdds")
    public AjaxResult numAdds(@RequestParam("openid") String openid,
                              @RequestParam("id") String id) {
        try {
            MyCart myCart = new MyCart();
            //增加数量
            if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(openid)) {
                if (myCartService.getMyCartIds(id, openid) != null) {
                    myCart = myCartService.getMyCartIds(id, openid);
                    int addNum = myCart.getCartNum();
                    myCart.setCartNum(++addNum);
                    myCartService.updateMyCart(myCart);
                    return AjaxResult.success("OK");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("购物车数量增加1错误");
    }

    /**
     * 购物车修改
     */
    @ApiOperation(value = "购物车修改")
    @PutMapping("/numUpdate")
    public AjaxResult numUpdate(@RequestParam("id") String id,
                                @RequestParam("openid") String openid,
                                @RequestParam("cartNum") String cartNum) {
        try {
            MyCart myCart = new MyCart();
            //增加数量
            if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(openid) && StringUtils.isNotEmpty(cartNum)) {
                if (myCartService.getMyCartIds(id, openid) != null) {
                    myCart = myCartService.getMyCartIds(id, openid);
                    myCart.setCartNum(Integer.parseInt(cartNum));
                    myCartService.updateMyCart(myCart);
                    return AjaxResult.success("OK");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("购物车修改数量错误");
    }

    /**
     * 清空购物车
     */
    @ApiOperation(value = "清空购物车")
    @DeleteMapping("/delete")
    public AjaxResult delete(@RequestParam("ids") String ids,
                             @RequestParam("openid") String openid) {
        try {
            if (StringUtils.isNotEmpty(ids) && StringUtils.isNotEmpty(openid)) {
                String[] Ids = ids.split("_");
                MyCart myCart = new MyCart();
                for (int i = 0; i < Ids.length; i++) {
                    String id = Ids[i];
                    myCartService.deleteMyCart(id, openid);
                }
                return AjaxResult.success("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("清空购物车错误");
    }


    /**
     * 获取购物车列表信息
     *
     * @return
     */
    @ApiOperation(value = "获取购物车列表信息")
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("openid") String openid) {
        try {
            if(myCartService.getMyCartList(openid)!=null) {
                List<MyCartView> myCartList = myCartService.getMyCartList(openid);
                return AjaxResult.success("OK", myCartList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AjaxResult.error("获取购物车列表信息错误");
    }

}
