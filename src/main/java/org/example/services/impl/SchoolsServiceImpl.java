package org.example.services.impl;

import java.util.List;

import org.example.domain.School;
import org.example.repositories.SchoolRepository;
import org.example.services.SchoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolsServiceImpl implements SchoolsService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public List<School> obtainSchools() {
		return (List<School>) schoolRepository.findAll();
	}

}
