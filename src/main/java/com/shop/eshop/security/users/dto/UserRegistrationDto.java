package com.shop.eshop.security.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
