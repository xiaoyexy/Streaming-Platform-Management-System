package edu.gatech.streamingwars;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

// By extending the CrudRepository, spring will generate queries for RandomNumberRepository
// that can be used when injected into our codebase
// In practice, using the spring data repository framework, we can reduce the amount of
// boiler plate code required. Since many entities can reuse the CrudRepository interface,
// we can quickly bootstrap our project with data access between our backend service and database
// without worrying about the details of how to access our data.
public interface RandomNumberRepository extends CrudRepository<RandomNumber, Long> {

    // Here we override the findAll method defined in CrudRepository to return a List
    // rather than an Iterable
    @Override
    List<RandomNumber> findAll();
}
