package qcyw.xchqcyws.common;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
/**
 * @author LUW
 */
public class VerifyToken{
        @Autowired
        JwtUtil jwtUtil;

        public Map<String, String> verifyToken(JSONObject resultJson){
        //获取sessionKey和openId
        String sessionKey=resultJson.get("session_key").toString();
        String openid =resultJson.get("openid").toString();

        //生成自定义登录态session
        String session=null;
        Map<String, String> sessionMap=new HashMap<>();

        sessionMap.put("sessionKey",sessionKey);
        sessionMap.put("openid",openid);
        session=JSONObject.fromObject(sessionMap).toString();

        //加密session
        try{
        EncryptUtil encryptUtil=new EncryptUtil();
        session=encryptUtil.encrypt(session);
        }catch(Exception e){
        e.printStackTrace();
        }

        //生成token
        String token=jwtUtil.getToken(session);
        Map<String, String> result=new HashMap<>();
        result.put("token",token);
        return result;
        }
}
