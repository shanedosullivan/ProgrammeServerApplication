package com.programme.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.programme.server.domain.Player;
import com.programme.server.domain.Substitution;
import com.programme.server.service.SubstitutionService;

@Controller
public class SubstitutionController {

	@Autowired
	private SubstitutionService substitutionService;
	
	@RequestMapping(value = "/substitution", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public void makeSubstitution(@RequestBody Substitution substitution){
		substitutionService.makeSubstitution(substitution);
	}
}
