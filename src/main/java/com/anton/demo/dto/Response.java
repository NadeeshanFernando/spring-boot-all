package com.anton.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author by nadeeshan_fdz
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {
    private String message;

    private int status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime timestamp;

    private Object data;
}
