package kr.hhplus.be.server.controller.base;

import kr.hhplus.be.server.application.base.UserService;
import kr.hhplus.be.server.domain.base.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
}
