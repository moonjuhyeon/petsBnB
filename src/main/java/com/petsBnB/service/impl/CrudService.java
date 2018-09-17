package com.petsBnB.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petsBnB.dto.CrudDTO;
import com.petsBnB.mapper.CrudMapper;
import com.petsBnB.service.ICrudService;

@Service
public class CrudService implements ICrudService {
	
	@Autowired
	private CrudMapper crudMapper;
	
	@Override
	public int insertCrud(CrudDTO cDTO) throws Exception {
		return crudMapper.insertCrud(cDTO);
	}

	@Override
	public List<CrudDTO> getCrud() throws Exception {
		return crudMapper.getCrud();
	}

	@Override
	public CrudDTO getCrudOne(Map<String, String> map) throws Exception {
		return crudMapper.getCrudOne(map);
	}
}
