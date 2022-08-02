package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.MyCart;

import java.util.List;

@Mapper
@Repository
public interface MyCartMapper {

    //获取商品列表信息
    List<MyCart> getMyCartList(@Param("userId") String userId);

    //新增购物车
    void insertMyCart(MyCart myCart);

    //清空购物车
    void updateMyCart(MyCart myCart);

}
