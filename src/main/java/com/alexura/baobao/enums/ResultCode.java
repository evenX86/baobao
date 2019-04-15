package com.alexura.baobao.enums;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 7:27 PM
 */
public enum ResultCode {
    SUCCESS(200, "success"),//成功
    FAIL(400 , "failed"),//失败
    UNAUTHORIZED(401, "unauth request"),//未认证（签名错误）
    NOT_FOUND(404, "service not found"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "system error");//服务器内部错误

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
