package com.nokia.service;

import com.nokia.dto.LifoDto;

public interface LifoService {

	void push(LifoDto body);

	LifoDto pop();

}
