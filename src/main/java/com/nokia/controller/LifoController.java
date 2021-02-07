package com.nokia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.dto.LifoDto;
import com.nokia.service.LifoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LifoController {

	@Autowired
	private LifoService service;

	@PostMapping("push")
	@ApiOperation(value = "Push Operation")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "body", value = "Value to be pushed", required = true, dataTypeClass = LifoDto.class, paramType = "body") })
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully pushed to stack."),
			@ApiResponse(code = 400, message = "Request parameters given are invalid/incorrect."),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found.") })
	public ResponseEntity<Void> push(@Valid @RequestBody LifoDto body) {
		service.push(body);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("pop")
	@ApiOperation(value = "Pop Operation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully pushed to stack."),
			@ApiResponse(code = 400, message = "Request parameters given are invalid/incorrect."),
			@ApiResponse(code = 404, message = "Stack is empty.") })
	public ResponseEntity<LifoDto> pop() {
		LifoDto dto = service.pop();
		if (null != dto) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
