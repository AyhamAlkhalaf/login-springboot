package com.CodeJavaApp.CodeJavaApp.repository;

import com.CodeJavaApp.CodeJavaApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM USER u WHERE u.email =?1")
    User findByEmail(String email);

}

