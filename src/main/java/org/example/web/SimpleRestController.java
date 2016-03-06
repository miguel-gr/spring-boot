package org.example.web;

import java.util.List;

import org.example.domain.School;
import org.example.services.SchoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * See https://spring.io/guides/gs/rest-service/
 */
@RestController
public class SimpleRestController {


	@Autowired
	private SchoolsService schoolsService;

	// https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html

	@RequestMapping("/getSchools")
	public List<School> getSchools() {
Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
System.out.println(principal);
		return schoolsService.obtainSchools();
	}

}
