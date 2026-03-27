package com.worksupport.enums;

public enum Status {

    APPROVED("approved"), PENDING("pending"), REJECTED("rejected");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
