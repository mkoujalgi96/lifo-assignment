package com.nokia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.dto.LifoDto;
import com.nokia.entity.LifoEntity;
import com.nokia.repository.LifoRepository;

@Service
public class LifoServiceImpl implements LifoService {

	@Autowired
	private LifoRepository nkStackRepository;

	public void push(LifoDto body) {
		LifoEntity nkStack = new LifoEntity();
		nkStack.setFirstName(body.getFirstName());
		nkStack.setLastName(body.getLastName());
		nkStackRepository.save(nkStack);
	}

	public LifoDto pop() {
		LifoEntity nkStack = nkStackRepository.findTopByOrderByIdDesc();
		if (null != nkStack) {
			LifoDto dto = new LifoDto();
			dto.setFirstName(nkStack.getFirstName());
			dto.setLastName(nkStack.getLastName());
			nkStackRepository.deleteById(nkStack.getId());
			return dto;
		}
		return null;
	}

}
