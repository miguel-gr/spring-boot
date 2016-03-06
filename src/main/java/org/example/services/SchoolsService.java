package org.example.services;

import java.util.List;

import org.example.domain.School;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SchoolsService {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<School> obtainSchools();
}
