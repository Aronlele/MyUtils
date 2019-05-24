package com.sunline.car.common.exception;

import com.sunline.car.util.MessageUtil;

/**
 * 通用检查异常处理.
 *
 * @author : 薛乐乐
 * @since : 2019/5/5 10:42
 */
public class CarCheckException extends RuntimeException {

  private static final long serialVersionUID = 9154552801748069366L;

  private String code;
  private String msg;
  private int errorCode;

  /**
   * 构造器.
   *
   * @param code 内容
   */
  public CarCheckException(String code) {
    this.errorCode = -1;
    this.code = code;
    this.msg = MessageUtil.getMsg(code);
  }

  /**
   * 构造器.
   *
   * @param errorCode 错误码
   * @param code 内容
   */
  public CarCheckException(int errorCode, String code) {
    this(code);
    this.errorCode = errorCode;
  }

  public CarCheckException(String code, Object... args) {
    this.errorCode = -1;
    this.code = code;
    this.msg = MessageUtil.getMsg(code, args);
  }

  /**
   * 构造器.
   *
   * @param errorCode 错误码
   * @param code 内容
   * @param args 参数
   */
  public CarCheckException(int errorCode, String code, Object... args) {
    this(code, args);
    this.errorCode = errorCode;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public String getMessage() {
    return this.getMsg();
  }

  @Override
  public String getLocalizedMessage() {
    return this.getMsg();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CarCheckException{");
    sb.append("code='").append(this.code).append('\'');
    sb.append(", msg='").append(this.msg).append('\'');
    sb.append(", errorCode=").append(this.errorCode);
    sb.append('}');
    return sb.toString();
  }
}
