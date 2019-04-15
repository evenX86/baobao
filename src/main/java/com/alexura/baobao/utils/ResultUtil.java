package com.alexura.baobao.utils;

import com.alexura.baobao.core.Result;
import com.alexura.baobao.enums.ResultCode;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 7:31 PM
 */
public class ResultUtil {
    public static Result buildFailResult(ResultCode resultCode){
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        return result;
    }
}
