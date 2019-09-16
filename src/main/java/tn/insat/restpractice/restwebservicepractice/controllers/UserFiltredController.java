package tn.insat.restpractice.restwebservicepractice.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import tn.insat.restpractice.restwebservicepractice.domain.UserFiltred;

@RestController
public class UserFiltredController {
	
	//field 1, field 2
	@GetMapping("/userFiltering")
	public MappingJacksonValue getUser() {
		UserFiltred user = new UserFiltred(1, "Amin", new Date());

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(user);

		mapping.setFilters(filters);

		return mapping;
	}

	// field2, field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue getUsers() {
		List<UserFiltred> list = Arrays.asList(new UserFiltred(1, "Amin", new Date()),
				new UserFiltred(2, "Wissem", new Date()));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "birthDate");

		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);

		mapping.setFilters(filters);

		return mapping;
	}
}
