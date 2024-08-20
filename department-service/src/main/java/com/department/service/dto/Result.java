package com.department.service.dto;

public class Result {

	private int statusCode;
	private String succesMessage;
	private String errorMessage;
	private Object data;

	public Result() {

	}

	public Result(Object data) {
		this.data = data;
	}

    public Result(String invalid_data, String message) {
    }

    public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getSuccesMessage() {
		return succesMessage;
	}

	public void setSuccesMessage(String succesMessage) {
		this.succesMessage = succesMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
