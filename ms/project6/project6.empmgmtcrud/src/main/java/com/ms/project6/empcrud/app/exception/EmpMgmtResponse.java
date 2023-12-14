package com.ms.project6.empcrud.app.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpMgmtResponse<T> {

    String errMessage;
    T data;
    Long errCode;

    public EmpMgmtResponse(String errMessage, T data, Long errCode) {
        this.errMessage = errMessage;
        this.data = data;
        this.errCode = errCode;
    }
}
