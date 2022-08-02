package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.MyCart;

import java.util.List;

public interface MyCartService {
    //获取购物车列表信息
    List<MyCart> getMyCartList(String userId);

    //新增购物车
    void insertMyCart(MyCart myCart);

    //清空购物车
    void updateMyCart(MyCart myCart);
}
