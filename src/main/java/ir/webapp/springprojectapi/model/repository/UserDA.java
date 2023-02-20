package ir.webapp.springprojectapi.model.repository;

import ir.webapp.springprojectapi.model.entity.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDA extends JpaRepository<UserAccess, Long> {

    //jpql
    @Query("SELECT oo FROM UserAccessEntity oo WHERE oo.username = :username AND oo.password = :password")
    Optional<UserAccess> findByUsernameAndPassword(String username, String password);

    @Query("SELECT oo FROM UserAccessEntity oo WHERE oo.username = :username")
    UserAccess findByUsername(String username);

    @Query("SELECT oo FROM UserAccessEntity oo WHERE oo.password = :password")
    Optional<UserAccess> findByPassword(String password);
}
