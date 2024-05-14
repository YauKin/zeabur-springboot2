package com.zeabur.springboot.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zeabur.springboot.ccgames.dto.response.ApiResponse;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ApiResponseUtil {
    private static final Gson gson = new Gson();

    public static <T> List<T> deserializeApiResponse(String jsonString, TypeToken<ApiResponse<T>> typeToken) {
        Type responseType = typeToken.getType();
        ApiResponse<T> apiResponse = gson.fromJson(jsonString, responseType);

        if (apiResponse.getCode() == 200 && apiResponse.getData() != null && apiResponse.getData().getRows() != null) {
            return apiResponse.getData().getRows();
        } else {
            return Collections.emptyList();
        }
    }
}
