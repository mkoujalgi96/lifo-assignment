package com.nokia.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nokia.dto.LifoDto;
import com.nokia.entity.LifoEntity;
import com.nokia.repository.LifoRepository;
import com.nokia.service.LifoServiceImpl;

@ExtendWith(SpringExtension.class)
public class LifoServiceTests {

	@Mock
	private LifoRepository nkStackRepository;

	@InjectMocks
	private LifoServiceImpl service;

	@Test
	void pushTest() {
		service.push(new LifoDto());

		LifoEntity entity = new LifoEntity();
		verify(nkStackRepository).save(entity);
	}

	@Test
	void popEmptyTest() {
		when(nkStackRepository.findTopByOrderByIdDesc()).thenReturn(null);
		assertNull(service.pop());
	}

	@Test
	void popTest() {
		LifoEntity nkStack = new LifoEntity();
		when(nkStackRepository.findTopByOrderByIdDesc()).thenReturn(nkStack);
		doNothing().when(nkStackRepository).deleteById(Mockito.anyInt());

		assertNotNull(service.pop());
	}
}
