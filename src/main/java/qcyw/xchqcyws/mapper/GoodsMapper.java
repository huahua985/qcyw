package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.GoodsModelView;
import qcyw.xchqcyws.entity.GoodsView;

import java.util.List;

/**
 * @author LUW
 */
@Mapper
@Repository
public interface GoodsMapper {

    /**获取商品列表信息
     *  @param ssGoodsName
     *  @param gsSortId
     *  @return 获取商品列表信息
     * */
    List<GoodsView> getGoodsList(@Param("ssGoodsName") String ssGoodsName,@Param("gsSortId")  String gsSortId);

    /**获取商品详情信息
     * @param gmGoodsId
     * @return 获取商品详情信息
     * */
    List<GoodsModelView> getGoodsId(@Param("gmGoodsId") String gmGoodsId);

    /**获取商品首页列表信息
     *  @param ssGoodsName
     *  @return 获取商品首页列表信息
     * */
    List<GoodsView> getGoodsListPage(@Param("ssGoodsName") String ssGoodsName);


}
