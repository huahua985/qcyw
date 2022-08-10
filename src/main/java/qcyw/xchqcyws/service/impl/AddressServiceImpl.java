package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.AddressUserView;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.mapper.AddressMapper;
import qcyw.xchqcyws.mapper.GoodsMapper;
import qcyw.xchqcyws.service.AddressService;
import qcyw.xchqcyws.service.GoodsService;

import java.util.List;

/**
 * @author LUW
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    /**新增地址簿
     * @param address
     * @return 新增地址簿
     *
     *  */
    @Override
    public void insertAddress(Address address) {
        addressMapper.insertAddress(address);
    }

    /**修改地址簿
     * @param address
     * @return 修改地址簿
     * */
    @Override
    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }

    /**获取地址簿列表信息*/
    @Override
    public List<AddressUserView> getAddressList(String openid) {
        return addressMapper.getAddressList(openid);
    }

    /**获取地址簿列表信息
     *  @param openid
     *  @return 地址簿列表
     * */
    @Override
    public List<Address> getAddressByIds(String openid) {
        return addressMapper.getAddressByIds(openid);
    }

    /**删除地址信息*/
    @Override
    public void deleteAddress(String id,String openid) {
        addressMapper.deleteAddress(id,openid);
    }
}
