package com.qsj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qsj.dao.DictMapper;
import com.qsj.pojo.Area;
import com.qsj.pojo.City;
import com.qsj.pojo.Province;
@Service
public class DictService implements IDictService{

	@Resource
	private DictMapper dictMapper;
	
	public List<Province> getProvinces() {
		return dictMapper.getProvinces();
	}

	public List<City> getCities(String provinceCode) {
		return dictMapper.getCities(provinceCode);
	}

	public List<Area> getAreas(String cityCode) {
		return dictMapper.getAreas(cityCode);
	}

}
