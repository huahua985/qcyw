package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.AddressUserView;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.MyCart;

import java.util.List;

/**
 * @author LUW
 */
@Mapper
@Repository
public interface AddressMapper {

    /**新增地址簿
     * @param address
     * @return 新增地址簿
     *
     *  */
    void insertAddress(Address address);

    /**修改地址簿
     * @param address
     * @return 修改地址簿
     * */
    void updateAddress(Address address);


    /**获取地址簿列表信息
     *  @param openid
     *  @return 地址簿列表
     * */
    List<AddressUserView> getAddressList(@Param("openid") String openid);

    /**获取地址簿列表信息
     *  @param openid
     *  @return 地址簿列表
     * */
    List<Address> getAddressByIds(@Param("openid") String openid);

    /**删除地址信息
     *  @param id
     *  @param openid
     *  @return 删除地址信息
     * */
    void deleteAddress(@Param("id") String id,@Param("openid") String openid);
}
