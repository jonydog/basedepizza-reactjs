package com.jpinto.basedepizza.daos;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpinto.basedepizza.model.User;


@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	@Query("select u from User u where u.email = :emailString")
	public User getUserByEmail(@Param("emailString") String emailString) throws DataAccessException;
	

}