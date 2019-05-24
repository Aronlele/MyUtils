package com.sunline.car.common.exception;

/**
 * 通用运行时异常处理.
 *
 * @author : 薛乐乐
 * @since : 2019/5/5 10:39
 */
public class CarServerException extends RuntimeException {

    private String msg;
    private int code;

    public CarServerException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = -1;
    }

    public CarServerException(String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        this.code = -1;
    }

    public CarServerException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public CarServerException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CarServerException{");
        sb.append("code=").append(this.code);
        sb.append(", msg='").append(this.msg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
