package com.nokia.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nokia.controller.LifoController;
import com.nokia.dto.LifoDto;
import com.nokia.service.LifoService;

@ExtendWith(SpringExtension.class)
public class LifoControllerTests {

	@Mock
	private LifoService service;

	@InjectMocks
	private LifoController controller;

	@Test
	void pushTest() {
		doNothing().when(service).push(Mockito.any());
		ResponseEntity<Void> response = controller.push(new LifoDto());
		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}

	@Test
	void popEmptyTest() {
		when(service.pop()).thenReturn(null);
		ResponseEntity<LifoDto> response = controller.pop();
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void popTest() {
		when(service.pop()).thenReturn(new LifoDto());
		ResponseEntity<LifoDto> response = controller.pop();
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
