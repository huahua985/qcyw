package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.AddressUserView;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.MyCart;

import java.util.List;
/**
 * @author LUW
 */
public interface AddressService {
    /**获取地址簿列表信息
     *  @param openid
     *  @return 地址簿列表
     * */
    List<Address> getAddressByIds(String openid);

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
    List<AddressUserView> getAddressList(String openid);

    /**删除地址信息
     *  @param id
     *  @param openid
     *  @return 删除地址信息
     * */
    void deleteAddress(String id,String openid);
}
