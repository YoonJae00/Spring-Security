package com.ohgiraffers.sessionsecurity.common;

public enum UserRole {

    /* 필기.
        enum 은 열거형 상수 라고 한다.
        미리 정의 된 상수 값들의 집합인 클래스이며,
        하나의 집합으로서 반목문을 사용할 수 있으며
        컬렉션과 함께 사용할 수 있다.
        코드의 의미를 전달하는데 도움을 줄 수 있으며
     */

    USER("일반회원"),
    ADMIN("관리자");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
