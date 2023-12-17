package com.anton.demo.util;

import com.anton.demo.dto.Response;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author by nadeeshan_fdz
 */
public class ResponseUtil {
    public static <T> Response<T> handleOkResponse(Response<T> responseDTO, Object data, String message) {
        responseDTO.setData(data);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.OK.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }

    public static <T> Response<T> handleCreatedResponse(Response<T> responseDTO, Object data, String message) {
        responseDTO.setData(data);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.CREATED.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }

    public static <T> Response<T> handleNotFoundResponse(Response<T> responseDTO, String message) {
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.NOT_FOUND.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }

    public static <T> Response<T> handleConflictResponse(Response<T> responseDTO, String message) {
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.CONFLICT.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }

    public static <T> Response<T> handleForbiddenResponse(Response<T> responseDTO, String message) {
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.FORBIDDEN.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }
    public static <T> Response<T> handleBadRequestResponse(Response<T> responseDTO, String message) {
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }

    public static <T> Response<T> handleEmptyResponse(Response<T> responseDTO, String message) {
        responseDTO.setData(null);
        responseDTO.setMessage(message);
        responseDTO.setStatus(HttpStatus.NO_CONTENT.value());
        responseDTO.setTimestamp(LocalDateTime.now());
        return responseDTO;
    }
}
