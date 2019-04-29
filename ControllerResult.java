package com.hylandtec.car.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 通用结果封装集合类.
 *
 * @author : 薛乐乐
 * @since : 2019/4/29 9:22
 */
public class ControllerResult<T> implements Serializable {

    private static final long serialVersionUID = 4050709958492328985L;
    private Boolean success;
    private Integer code;
    private List<String> infoMsgs = new LinkedList<>();
    private List<String> warningMsgs = new LinkedList<>();
    private String errorMsg;
    private T data;

    public ControllerResult() {
    }

    public ControllerResult(T t) {
        this.data = t;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getInfoMsgs() {
        return this.infoMsgs;
    }

    public void setInfoMsgs(List<String> infoMsgs) {
        this.infoMsgs = infoMsgs;
    }

    public List<String> getWarningMsgs() {
        return this.warningMsgs;
    }

    public void setWarningMsgs(List<String> warningMsgs) {
        this.warningMsgs = warningMsgs;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static <T> ControllerResult<T> success(T data) {
        ControllerResult result = new ControllerResult(data);
        result.setSuccess(true);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ControllerResult<?> that = (ControllerResult) o;
            return this.code.equals(that.code) && Objects.equals(this.success, that.success)
                    && Objects.equals(this.infoMsgs, that.infoMsgs) && Objects.equals(this.warningMsgs, that.warningMsgs)
                    && Objects.equals(this.errorMsg, that.errorMsg) && Objects.equals(this.data, that.data);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.success, this.code, this.infoMsgs, this.warningMsgs, this.errorMsg, this.data});
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("ControllerResult{");
        sb.append("success=").append(this.success);
        sb.append(", code=").append(this.code);
        sb.append(", infoMsgs=").append(this.infoMsgs);
        sb.append(", warningMsgs=").append(this.warningMsgs);
        sb.append(", errorMsg='").append(this.errorMsg).append('\'');
        sb.append(", data=").append(this.data);
        sb.append('}');
        return sb.toString();
    }
}
