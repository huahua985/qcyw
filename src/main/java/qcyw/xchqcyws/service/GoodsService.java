package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.GoodsModelView;
import qcyw.xchqcyws.entity.GoodsView;

import java.util.List;
/**
 * @author LUW
 */
public interface GoodsService {
    /**获取商品列表信息
     *  @param ssGoodsName
     *  @param gsSortId
     *  @return 获取商品列表信息
     * */
    List<GoodsView> getGoodsList(String ssGoodsName,String gsSortId);


    /**获取商品详情信息
     * @param gmGoodsId
     * @return 获取商品详情信息
     * */
    List<GoodsModelView> getGoodsId(String gmGoodsId);

    /**获取商品首页列表信息
     *  @param ssGoodsName
     *  @return 获取商品首页列表信息
     * */
    List<GoodsView> getGoodsListPage(String ssGoodsName);


}
