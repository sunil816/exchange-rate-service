package com.exchangerateservice.responseTemplate;

import com.exchangerateservice.constants.ResponseConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class SuccessResponse extends DefaultResponse{

    private Object data;

    public SuccessResponse(Object data) {
        this.data = data;
        this.setStatus(ResponseConstants.SUCCESS);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
