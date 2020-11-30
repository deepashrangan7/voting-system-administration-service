package com.cts.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString

public class Status {

	public Status(Integer statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public Status(Integer statusCode, String message, List<String> fieldErrors) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.fieldErrors = fieldErrors;
	}

	@NonNull
	private Integer statusCode;

	@NonNull
	private String message;

	private List<String> fieldErrors;

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}
