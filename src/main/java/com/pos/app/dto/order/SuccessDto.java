package com.pos.app.dto.order;

/**
 * Created by admin on 4/15/2018.
 */
public class SuccessDto {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
