package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.MyCart;
import qcyw.xchqcyws.entity.MyCartView;
import qcyw.xchqcyws.entity.MyCartViews;

import java.util.List;
/**
 * @author LUW
 */
public interface MyCartService {
    /**获取商品列表信息
     *  @param openid
     *  @return 获取商品列表信息
     * */
    List<MyCartView> getMyCartList(String openid);

    /**新增购物车
     *  @param myCart
     *  @return 新增购物车
     * */
    void insertMyCart(MyCart myCart);

    /**清空购物车
     *  @param myCart
     *  @return 清空购物车
     * */
    void updateMyCart(MyCart myCart);

    /**获取商品详情信息
     *  @param goodsId
     *  @return 获取商品详情信息
     * */
    MyCart getMyCartId(String goodsId);

    /**获取商品详情信息
     *  @param id
     *  @param openid
     *  @return 获取商品详情信息
     * */
    MyCart getMyCartIds(String id,String openid);

    /**清空购物车
     *  @param id
     *  @param openid
     *  @return 清空购物车
     * */
     void deleteMyCart(String id,String openid);

    /**获取商品列表信息
     *  @param openid
     *  @return 获取商品列表信息
     * */
    List<MyCartViews> getMyCartLists(String openid);
}
