package com.nokia.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LifoDto {

	@ApiModelProperty(notes = "First name of the user")
	@NotEmpty(message = "First name cannot be empty or null")
	private String firstName;

	@ApiModelProperty(notes = "Last name of the user")
	@NotEmpty(message = "LastName cannot be empty or null")
	private String lastName;
}
