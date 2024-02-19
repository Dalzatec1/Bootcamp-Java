package com.demosql.demo.repositories;

import com.demosql.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsersRepository extends CrudRepository<User, Long> {

}
