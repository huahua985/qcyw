package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.mapper.GoodsMapper;
import qcyw.xchqcyws.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    //获取商品列表信息
    @Override
    public List<Goods> getGoodsList(String goodsName) {
        return goodsMapper.getGoodsList(goodsName);
    }

    //获取商品详情信息
    @Override
    public Goods getGoodsId(String goodsId) {
        return goodsMapper.getGoodsId(goodsId);
    }
}
