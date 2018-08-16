package com.toocms.www.testframeforwzw.api;

import java.io.Serializable;

public class SimpleResponse implements Serializable {
    private static final long serialVersionUID = -9173796407893698790L;
    public String code;
    public String message;
    public Object data;

    public SimpleResponse() {
    }

    public BaseResponse toBaseResponse() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(this.code);
        baseResponse.setMessage(this.message);
        baseResponse.setData(this.data);
        return baseResponse;
    }
}
