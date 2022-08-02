package qcyw.xchqcyws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import qcyw.xchqcyws.entity.User;
import qcyw.xchqcyws.entity.UserVo;

@Mapper
@Repository
public interface UserMapper {

    //新建用户
    int insertUser(String id,String openid,String unionid,String phone);

    //登录时更新微信小程序获取的信息
    int updateUserWxInfo(String openid, String nickName);

    //后续用户写入个人信息后更新信息
    int updateUserInfo(@Param("openid") String openid,
                        @Param("userVo") UserVo userVo);

    //查询用户个人信息
    User queryUserInfo(String openid);
}
