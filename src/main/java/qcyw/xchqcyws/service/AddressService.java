package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.MyCart;

import java.util.List;

public interface AddressService {
    //获取地址簿列表信息
    List<Address> getAddressList(Address address);

    //新增地址簿
    void insertAddress(Address address);

    //清空地址簿
    void updateAddress(Address address);
}
