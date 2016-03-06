package org.example.repositories;

import java.util.List;

import org.example.domain.School;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

/**
 * https://spring.io/guides/gs/accessing-data-rest/
 *
 */
@RepositoryRestResource(collectionResourceRel = "schools", path = "schools")
public interface SchoolRepository extends PagingAndSortingRepository<School, Long>{
	
	/**
	 * Find Schools by name.
	 * Note that the method name has the suffix <b>Name</b>, it is because it must be the same as the name of an entity attribute
	 * The url to call the method implementation would be http://localhost:8080/schools/search/findByName?name=x where x is the name being searched
	 * @param name The name to search
	 * @return a list of the matched Schools
	 */
	List<School> findByName(@Param("name") String name);
		
}
