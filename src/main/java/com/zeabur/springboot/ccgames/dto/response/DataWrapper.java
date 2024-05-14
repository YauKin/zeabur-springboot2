package com.zeabur.springboot.ccgames.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class DataWrapper<T> {
    List<T> rows;
    // Assuming you might also want to capture 'total' and 'rule' from the JSON
    String total;
}
