package com.golfzonaca.adminpage.domain.type;

public enum MileageStatusType {
    NEW_MEMBER("신규회원"), EARNING("적립"), USE("사용"), EXPIRATION("만료");
    private final String description;

    MileageStatusType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
