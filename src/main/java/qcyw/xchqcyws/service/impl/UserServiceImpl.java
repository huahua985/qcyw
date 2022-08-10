package qcyw.xchqcyws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcyw.xchqcyws.common.untils.UUIDGenerator;
import qcyw.xchqcyws.entity.User;
import qcyw.xchqcyws.entity.UserVo;
import qcyw.xchqcyws.mapper.UserMapper;
import qcyw.xchqcyws.service.UserService;

/**
 * @author LUW
 */
@Service("ownerService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**新建用户*/
    @Override
    public int insertUser(String openid,String unionid,String phone,double price){
        User user  = new User();
        user.setOpenid(openid);
        user.setUnionid(unionid);
        user.setPhone(phone);
        user.setPrice(price);
        user.setId(UUIDGenerator.getUUID());
        user.setDelFlag(1);
        return userMapper.insertUser(user);
    }

    /**登录时插入微信小程序获取的信息*/
    @Override
    public int updateUserWxInfo(String openid, String phone){
        return userMapper.updateUserWxInfo(openid, phone);
    }

    /**后续用户写入个人信息时更新信息*/
    @Override
    public int updateUserInfo(String openid, UserVo userVo){
        return userMapper.updateUserInfo(openid, userVo);
    }

    /**查看用户个人信息*/
    @Override
    public User queryUserInfo(String openid){
        return userMapper.queryUserInfo(openid);
    }

}
