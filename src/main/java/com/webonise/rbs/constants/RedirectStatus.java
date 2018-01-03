package com.webonise.rbs.constants;

public enum RedirectStatus {

    SUCCESS("success"),
    FAILURE("failure");

    String status;
    RedirectStatus() {
    }

    RedirectStatus (String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
