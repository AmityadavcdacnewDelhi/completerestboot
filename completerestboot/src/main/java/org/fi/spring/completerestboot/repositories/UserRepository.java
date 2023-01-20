package org.fi.spring.completerestboot.repositories;

import java.util.List;

import org.fi.spring.completerestboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	@Query(value="select objUser from UserEntity objUser where objUser.userName=:uname and objUser.password=:pwd")
	UserEntity authenticateUser(@Param("uname")String userName, @Param("pwd")String password);
	@Query(value="select * from users_1234 order by userName DESC",nativeQuery = true)
	
	List<UserEntity> getAllRecordsByDescending();

	UserEntity findByName(String name);

}
