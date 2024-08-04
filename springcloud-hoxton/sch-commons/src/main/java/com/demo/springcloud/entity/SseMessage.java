package com.demo.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SseMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private Integer id;
    private Integer status;
    private String msg;
}
