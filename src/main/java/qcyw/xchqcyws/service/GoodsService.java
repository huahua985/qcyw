package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.Goods;

import java.util.List;

public interface GoodsService {
    //获取商品列表信息
    List<Goods> getGoodsList(String goodsName);

    //获取商品详情信息
    Goods getGoodsId(String goodsId);
}
