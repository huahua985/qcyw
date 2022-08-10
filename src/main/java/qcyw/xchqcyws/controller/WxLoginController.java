package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qcyw.xchqcyws.common.GetUserInfoUtil;
import qcyw.xchqcyws.common.JwtUtil;
import qcyw.xchqcyws.common.VerifyToken;
import qcyw.xchqcyws.entity.User;
import qcyw.xchqcyws.common.domain.Result;
import qcyw.xchqcyws.entity.UserVo;
import qcyw.xchqcyws.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * 棋茶一味登录 -控制层
 *
 * @date 2022/7/27
 * @author LUW
 */
@Api(tags = "WxLoginController")
@RestController
@RequestMapping("/user")
public class WxLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @ApiOperation("微信授权登录")
    @GetMapping("/index/login")
    public Result authorizeLogin(@NotBlank @RequestParam("code") String code) {
        //通过code换取信息
        JSONObject resultJson = GetUserInfoUtil.getResultJson(code);
        return Result.succ("登录成功", resultJson);
    }

    @ApiOperation("存储用户个人信息")
    @PostMapping("/index/person-info")
    public Result insertPersonInfo(HttpServletRequest httpServletRequest){
        String phone = httpServletRequest.getParameter("phone");
        String openid = httpServletRequest.getParameter("openid");
        String unionid = httpServletRequest.getParameter("unionid");
        /**查询用户是否存在*/
            User user = userService.queryUserInfo(openid);
            if (user != null){
                //用户存在，返回结果
                UserVo userVo1 = new UserVo();
                userVo1.setPrice(user.getPrice());
                userVo1.setOpenid(user.getOpenid());
                return Result.succ("ok", userVo1);
            }else {
                //用户不存在，新建用户信息
                double price = 0;
                int rs = userService.insertUser(openid,unionid,phone,price);
                if (rs <= 0){
                    return Result.fail("登录失败");
                }
                User user3 = userService.queryUserInfo(openid);
                UserVo userVo2 = new UserVo();
                userVo2.setPrice(user3.getPrice());
                userVo2.setOpenid(user3.getOpenid());
                return Result.succ("ok", userVo2);
            }
        }


}
