package com.petsBnB.service;

import java.util.List;
import java.util.Map;

import com.petsBnB.dto.CrudDTO;

public interface ICrudService {
	public int insertCrud(CrudDTO cDTO) throws Exception;
	public List<CrudDTO> getCrud() throws Exception;
	public CrudDTO getCrudOne(Map<String, String> map) throws Exception;
}
