package com.zeabur.springboot.constant;

import lombok.Getter;

@Getter
public enum GameListType {
    CURRENT_RENTAL_LIST(1, "CURRENT_RENTAL_LIST"),
    RENTAL_HISTORY_LIST(2, "RENTAL_HISTORY_LIST");

    private final int id;
    private final String orderTypeName;

    GameListType(int id, String orderTypeName) {
        this.id = id;
        this.orderTypeName = orderTypeName;
    }

}
