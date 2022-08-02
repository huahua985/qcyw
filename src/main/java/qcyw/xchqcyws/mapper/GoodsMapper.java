package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.Goods;

import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {

    //获取商品列表信息
    List<Goods> getGoodsList(@Param("goodsName") String goodsName);

    //获取商品详情信息
    Goods getGoodsId(@Param("goodsId") String goodsId);
}
