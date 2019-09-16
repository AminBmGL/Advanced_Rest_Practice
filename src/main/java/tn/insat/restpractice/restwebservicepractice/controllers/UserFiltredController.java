package tn.insat.restpractice.restwebservicepractice.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.insat.restpractice.restwebservicepractice.domain.UserFiltred;

@RestController
public class UserFiltredController {
	
@GetMapping("/usersFiltred")
public List<UserFiltred> getAllUsersFiltred(){
	return Arrays.asList(new UserFiltred(1, "Amin", new Date()),
			new UserFiltred(2, "Wissem", new Date()));
	
}
}
