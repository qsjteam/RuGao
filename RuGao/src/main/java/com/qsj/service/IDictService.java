package com.qsj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qsj.pojo.Area;
import com.qsj.pojo.City;
import com.qsj.pojo.Province;


@Transactional
public interface IDictService {
	List<Province> getProvinces();
	List<City> getCities(String provinceCode);
	List<Area> getAreas(String cityCode);

}







