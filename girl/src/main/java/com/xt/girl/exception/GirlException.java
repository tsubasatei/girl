package com.xt.girl.exception;

import com.xt.girl.enums.ResultEnum;

/**
 * Created with xt.
 * Date: 2018/3/15
 * Time: 16:51
 * Description:
 */
public class GirlException extends RuntimeException{

    private Integer code;

    /*public GirlException(Integer code, String message){
        super(message);
        this.code = code;
    }*/

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
