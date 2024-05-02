package com.zeabur.springboot.constant;

import lombok.Getter;

@Getter
public enum GameListType {
    USER_ORDER_LIST(1, "USER_ORDER_LIST"),
    USER_ORDER_HISTORY(2, "USER_ORDER_HISTORY");

    private final int id;
    private final String orderTypeName;

    GameListType(int id, String orderTypeName) {
        this.id = id;
        this.orderTypeName = orderTypeName;
    }

}
