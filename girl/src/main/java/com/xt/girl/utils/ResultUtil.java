package com.xt.girl.utils;

import com.xt.girl.domain.Result;

/**
 * Created with xt.
 * Date: 2018/3/15
 * Time: 15:35
 * Description: http请求返回结果工具类
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
