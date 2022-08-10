package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.MyCart;
import qcyw.xchqcyws.entity.MyCartView;
import qcyw.xchqcyws.entity.MyCartViews;

import java.util.List;
/**
 * @author LUW
 */
@Mapper
@Repository
public interface MyCartMapper {

    /**获取商品列表信息
     *  @param openid
     *  @return 获取商品列表信息
     * */
    List<MyCartView> getMyCartList(@Param("openid") String openid);

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
    MyCart getMyCartId(@Param("goodsId") String goodsId);

    /**获取商品详情信息
     *  @param id
     *  @param openid
     *  @return 获取商品详情信息
     * */
    MyCart getMyCartIds(@Param("id") String id,@Param("openid") String openid);

    /**清空购物车
     *  @param id
     *  @param openid
     *  @return 清空购物车
     * */
    void deleteMyCart(@Param("id") String id,@Param("openid") String openid);

    /**获取商品列表信息
     *  @param openid
     *  @return 获取商品列表信息
     * */
    List<MyCartViews> getMyCartLists(@Param("openid") String openid);
}
