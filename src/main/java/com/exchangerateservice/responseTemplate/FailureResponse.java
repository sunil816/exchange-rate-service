package com.exchangerateservice.responseTemplate;

import com.exchangerateservice.constants.ResponseConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class FailureResponse extends DefaultResponse{

    private String message;

    public FailureResponse(String message) {
        this.message = message;
        this.setStatus(ResponseConstants.FAILURE);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
