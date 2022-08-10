package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.MyCart;
import qcyw.xchqcyws.entity.MyCartView;
import qcyw.xchqcyws.entity.MyCartViews;
import qcyw.xchqcyws.mapper.GoodsMapper;
import qcyw.xchqcyws.mapper.MyCartMapper;
import qcyw.xchqcyws.service.GoodsService;
import qcyw.xchqcyws.service.MyCartService;

import java.util.List;

/**
 * @author LUW
 */
@Service
public class MyCartServiceImpl implements MyCartService {
    @Autowired
    MyCartMapper myCartMapper;

    /**获取购物车列表信息*/
    @Override
    public List<MyCartView> getMyCartList(String openid) {
        return myCartMapper.getMyCartList(openid);
    }
    /**新增购物车*/
    @Override
    public void insertMyCart(MyCart myCart) {
        myCartMapper.insertMyCart(myCart);
    }

    /**清空购物车*/
    @Override
    public void updateMyCart(MyCart myCart) {
        myCartMapper.updateMyCart(myCart);
    }

    /**获取商品详情信息*/
    @Override
    public MyCart getMyCartId(String goodsId) {
        return myCartMapper.getMyCartId(goodsId);
    }

    /**获取商品详情信息*/
    @Override
    public MyCart getMyCartIds(String id,String openid) {
        return myCartMapper.getMyCartIds(id,openid);
    }

    /**清空购物车*/
    @Override
    public void deleteMyCart(String id,String openid) {
        myCartMapper.deleteMyCart(id,openid);
    }

    /**获取购物车列表信息*/
    @Override
    public List<MyCartViews> getMyCartLists(String openid) {
        return myCartMapper.getMyCartLists(openid);
    }
}
