package spring_ioc.repository;

import org.springframework.stereotype.Repository;
import spring_ioc.model.UserEntry;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserEntryRepository extends CrudRepository<UserEntry, Long> {
}
