package com.travel.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

public class ProfileDefaultResponseDTO implements ProfileDTO {

	private String fullName;
	private long phoneNo;
	private String email;
	private int flatNo;
	private String streetName;
	private String landMark;
	private int pinCode;
	private String city;
	private String state;
	private String country;

}
