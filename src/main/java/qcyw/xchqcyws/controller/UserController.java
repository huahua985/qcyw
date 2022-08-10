package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qcyw.xchqcyws.common.JwtUtil;
import qcyw.xchqcyws.entity.UserVo;
import qcyw.xchqcyws.common.domain.Result;
import qcyw.xchqcyws.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LUW
 */
@Api(tags = "UserController")
@RestController
@RequestMapping("/user/person-info")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    JwtUtil jwtUtil;

    @PutMapping("/update-person-info")
    @ApiOperation("修改用户个人信息")
    public Result updateOwnerInfo(HttpServletRequest request,
                                  @RequestBody UserVo userVo){
        //获取请求头token
        String token = request.getHeader("Authorization");
        //获取openid
        String openid = jwtUtil.getOpenidFromToken(token);

        int result = userService.updateUserInfo(openid, userVo);

        if (result <= 0){
            return Result.fail("修改失败",null);
        }

        return Result.succ("修改成功",null);
    }

}
