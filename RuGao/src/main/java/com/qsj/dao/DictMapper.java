package com.qsj.dao;

import java.util.List;

import com.qsj.pojo.Area;
import com.qsj.pojo.City;
import com.qsj.pojo.Province;

public interface DictMapper {

	List<Province> getProvinces();
	List<City> getCities(String provinceCode);
	List<Area> getAreas(String cityCode);
	String  getProvinceByCode(String code);
	String  getCityByCode(String code);
	String  getAreaByCode(String code);
}









