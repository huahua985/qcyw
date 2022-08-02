package qcyw.xchqcyws.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qcyw.xchqcyws.common.GetUserInfoUtil;
import qcyw.xchqcyws.common.JwtUtil;
import qcyw.xchqcyws.common.VerifyToken;
import qcyw.xchqcyws.entity.User;
import qcyw.xchqcyws.common.domain.Result;
import qcyw.xchqcyws.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * 棋茶一味登录 -控制层
 *
 * @date 2022/7/27
 * @Description
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
    @PostMapping("/index/login")
    public Result authorizeLogin(@NotBlank @RequestParam("code") String code) {

        //通过code换取信息
        JSONObject resultJson = GetUserInfoUtil.getResultJson(code);

        if (resultJson.has("openid")){
            String openid =resultJson.get("openid").toString();
            String unionid = resultJson.get("unionid").toString();
            String phone = resultJson.get("phone").toString();
            VerifyToken verifyToken = new VerifyToken();
            Map<String, String> result = verifyToken.verifyToken(resultJson);
            //查询用户是否存在
            User user = userService.queryUserInfo(openid);
            if (user != null){
                return Result.succ("登录成功", result); //用户存在，返回结果
            }else { //用户不存在，新建用户信息
                int rs = userService.insertUser(openid,unionid,phone);
                if (rs <= 0){
                    return Result.fail("登录失败");
                }
                return Result.succ("登录成功", result);
            }
        }

        return Result.fail("授权失败"+ resultJson.getString("errmsg"));
    }

    @ApiOperation("存储用户个人信息")
    @PostMapping("/index/person-info")
    public Result insertPersonInfo(@RequestParam("nickName") String nickName,
                                   HttpServletRequest request){
        
        //获取请求头token
        String token = request.getHeader("Authorization");
        //从token中获取openid
        String openid = jwtUtil.getOpenidFromToken(token);

        int result = userService.updateUserWxInfo(openid, nickName);
        if(result <= 0){
            return Result.fail("更新失败！");
        }

        return Result.succ("更新成功！", null);
    }

}
