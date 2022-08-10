package qcyw.xchqcyws.common;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author LUW
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        //获取请求头token
        String token = request.getHeader("Authorization");

        try{
            //校验token
            jwtUtil.verifyToken(token);
            //放行请求
            return true;
        }catch (ExpiredJwtException e){
            e.printStackTrace();
            throw new TokenException("token过期！");
        }catch (MalformedJwtException e){
            e.printStackTrace();
            throw new TokenException("token格式错误！");
        }catch (SignatureException e){
            e.printStackTrace();
            throw new TokenException("无效签名！");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new TokenException("非法请求！");
        }catch (Exception e){
            e.printStackTrace();
            throw new TokenException("token无效！");
        }
    }

}
