package com.cts.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@RequiredArgsConstructor

public class Status {

	@NonNull
	private Integer statusCode;

	@NonNull
	private String message;
	
	private List<String> fieldErrors;

}
