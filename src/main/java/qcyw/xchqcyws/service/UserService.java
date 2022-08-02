package qcyw.xchqcyws.service;

import qcyw.xchqcyws.entity.User;
import qcyw.xchqcyws.entity.UserVo;

public interface UserService {

    //新建用户
    int insertUser(String openid,String unionid,String phone);

    //登录时插入微信小程序获取的信息
    int updateUserWxInfo(String openid, String nickName);

    //后续用户写入个人信息后更新信息
    int updateUserInfo(String openid, UserVo userVo);

    //查看用户个人信息
    User queryUserInfo(String openid);

}
