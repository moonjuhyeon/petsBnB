package com.petsBnB.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.petsBnB.dto.CrudDTO;
import com.petsBnB.service.ICrudService;

@CrossOrigin(origins="*")
@RestController
public class CrudController {
	@Autowired
	private ICrudService crudService;
	
	@CrossOrigin
	@RequestMapping(value="/crud", method=RequestMethod.POST)
	public Map<String, String> insertCrud(@RequestBody Map<Object, Object> param, HttpServletResponse resp, Model model) throws Exception{
		
		System.out.println("param.get(title) : " + param.get("title"));
		System.out.println("param.get(content) : " + param.get("content"));
		String title = (String) param.get("title");
		String content = (String) param.get("content");
		
		CrudDTO cDTO = new CrudDTO();
		cDTO.setTitle(title);
		cDTO.setContent(content);
		
		int result = crudService.insertCrud(cDTO);
		System.out.println("result : " + result);
		
		Map<String, String> map = new HashMap<>();
		if(result != 0) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@CrossOrigin
	@RequestMapping(value="/crud", method=RequestMethod.GET)
	public List<CrudDTO> getCrud() throws Exception{
		System.out.println(this.getClass() + ".getCrud() start!!!");
		
		List<CrudDTO> cList = crudService.getCrud();
		if(cList == null) cList = new ArrayList<>();
		
		System.out.println(this.getClass() + ".getCrud() end!!!");
		return cList;
	}
	
	@CrossOrigin
	@RequestMapping(value="/crud/{id}", method=RequestMethod.GET)
	public CrudDTO getCrudOne(HttpServletRequest req, @PathVariable String id, HttpServletResponse resp, Model model) throws Exception{
		System.out.println(this.getClass() + ".getCurdOne start!!!");
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		CrudDTO cDTO = crudService.getCrudOne(map);
		if(cDTO == null) cDTO = new CrudDTO();
		System.out.println(this.getClass() + ".getCurdOne end!!!");
		return cDTO;
	}
}
