package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.Address;
import qcyw.xchqcyws.entity.Goods;
import qcyw.xchqcyws.entity.MyCart;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {

    //获取地址簿列表信息
    List<Address> getAddressList(Address address);

    //新增地址簿
    void insertAddress(Address address);

    //修改地址簿
    void updateAddress(Address addressAddressMapperAddressMapper);
}
