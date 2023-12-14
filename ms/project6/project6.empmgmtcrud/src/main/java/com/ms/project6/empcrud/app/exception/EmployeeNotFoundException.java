package com.ms.project6.empcrud.app.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeNotFoundException extends Exception {
    String msg;
    public EmployeeNotFoundException() {
        super("Employee not found !");
        this.msg = "Employee not found !";
    }

    public String toString() {
        return msg;
    }
}
