package com.webonise.rbs.constants;

public enum RedirectStatus {

    success("success"),
    failure("failure");

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
