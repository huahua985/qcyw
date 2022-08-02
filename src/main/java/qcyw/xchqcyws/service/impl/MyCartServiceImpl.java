package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.MyCart;
import qcyw.xchqcyws.mapper.GoodsMapper;
import qcyw.xchqcyws.mapper.MyCartMapper;
import qcyw.xchqcyws.service.GoodsService;
import qcyw.xchqcyws.service.MyCartService;

import java.util.List;

@Service
public class MyCartServiceImpl implements MyCartService {
    @Autowired
    MyCartMapper myCartMapper;

    //获取购物车列表信息
    @Override
    public List<MyCart> getMyCartList(String userId) {
        return myCartMapper.getMyCartList(userId);
    }
    //新增购物车
    @Override
    public void insertMyCart(MyCart myCart) {
        myCartMapper.insertMyCart(myCart);
    }

    //清空购物车
    @Override
    public void updateMyCart(MyCart myCart) {
        myCartMapper.updateMyCart(myCart);
    }
}
