package com.springCrud.springAngular.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerSaveDto {

	private String customerName;
	private String customerAddress;
	private int mobile;
}
