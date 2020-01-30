package com.restApi.course.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping(path="/filtering")
	public SomeBean retrieveSomeBean() {
		
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping(path="/filtering/dynamic")
	public MappingJacksonValue dynamic() {
		
		
		BeanForDynamicFiltering obj= new BeanForDynamicFiltering("vishal","23","male");
	    
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
				.filterOutAllExcept("name","gender");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("bhargavi", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(obj);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping(path="/filtering/dynamic1")
	public MappingJacksonValue dynamicFiltering() {
		
		BeanForDynamicFiltering bhargavi= new BeanForDynamicFiltering("bhargavi","23","female");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","gender");
		FilterProvider provider = new SimpleFilterProvider().addFilter("bhargavi", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(bhargavi);
		mapping.setFilters(provider);
		return mapping;

	}
	
}
