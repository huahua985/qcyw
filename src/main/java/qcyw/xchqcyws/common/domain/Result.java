package qcyw.xchqcyws.common.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @date 2022/7/27
 * @author LUW
 */
@Data
@NoArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;

    public static Result succ(Object data){
        return succ(1,"操作成功",data);
    }

    public static Result succ(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static Result succ(String msg, Object data) {
        Result r = new Result();
        r.setCode(1);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static Result fail(String msg){
        return fail(500,msg,null);
    }

    public static Result fail(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static Result fail(String msg, Object data) {
        Result r = new Result();
        r.setCode(0);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static Result fail(int code, String msg) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

}
