package com.CodeJavaApp.CodeJavaApp;


import com.CodeJavaApp.CodeJavaApp.model.User;
import com.CodeJavaApp.CodeJavaApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUSer(){
        User user= new User();
        user.setEmail("ayham.ayham909@gamil.com");
        user.setPassWord("ayham2020");
        user.setFirstName("ayham");
        user.setLastName("alkhalaf");

       User savedUser = repo.save(user);

      User  existUser = entityManager.find(User.class,savedUser.getId());

      assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

    }

    @Test
    public void testFindUserByEmail(){
        String email = "nam@codeJava.net";

        User user=repo.findByEmail(email);

        assertThat(user).isNotNull();

    }



}
