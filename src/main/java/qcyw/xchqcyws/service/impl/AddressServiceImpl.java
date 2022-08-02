package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.mapper.AddressMapper;
import qcyw.xchqcyws.mapper.GoodsMapper;
import qcyw.xchqcyws.service.AddressService;
import qcyw.xchqcyws.service.GoodsService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    //获取地址簿列表信息
    @Override
    public List<Address> getAddressList(Address address) {
        return addressMapper.getAddressList(address);
    }

    @Override
    public void insertAddress(Address address) {
        addressMapper.insertAddress(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }

}
