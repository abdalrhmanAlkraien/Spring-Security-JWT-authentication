package com.jwt.authentication.jwt_authentication.util;

import com.jwt.authentication.jwt_authentication.security.UserApp;
import com.jwt.authentication.jwt_authentication.security.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * I created CreationUser for implement CommandLineRunner I will use it for create users when start the application
 */
@Component
@Log4j2
public class CreationUser implements CommandLineRunner {
    private final UserService userService;

    CreationUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // if the list of null I will create users
        if (userService.findAllUser().isEmpty()) {
            UserApp userApp = new UserApp("test account1", "test account1", "test account1");
            UserApp userApp2 = new UserApp("test account2", "test account2", "test account2");
            UserApp userApp3 = new UserApp("test account3", "test account3", "test account3");
            userService.saveUser(userApp);
            userService.saveUser(userApp2);
            userService.saveUser(userApp3);
        }

    }
}
