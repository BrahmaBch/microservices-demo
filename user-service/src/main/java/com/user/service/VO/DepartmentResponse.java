package com.user.service.VO;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DepartmentResponse {

    private int statusCode;
    private String successMessage;
    private String errorMessage;
    private Department data;
}
