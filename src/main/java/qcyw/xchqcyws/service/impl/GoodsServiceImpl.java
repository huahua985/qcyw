package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.GoodsModelView;
import qcyw.xchqcyws.entity.GoodsView;
import qcyw.xchqcyws.mapper.GoodsMapper;
import qcyw.xchqcyws.service.GoodsService;

import java.util.List;

/**
 * @author LUW
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    /**获取商品列表信息*/
    @Override
    public List<GoodsView> getGoodsList(String ssGoodsName,String gsSortId) {
        return goodsMapper.getGoodsList(ssGoodsName,gsSortId);
    }

    /**获取商品详情信息*/
    @Override
    public List<GoodsModelView> getGoodsId(String gmGoodsId) {
        return goodsMapper.getGoodsId(gmGoodsId);
    }


    /**获取商品首页列表信息*/
    @Override
    public List<GoodsView> getGoodsListPage(String ssGoodsName) {
        return goodsMapper.getGoodsListPage(ssGoodsName);
    }



}
