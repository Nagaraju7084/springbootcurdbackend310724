package com.curd.backend.dto;

import lombok.Data;

@Data
public class CustomerDto {
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerMobile;
}
