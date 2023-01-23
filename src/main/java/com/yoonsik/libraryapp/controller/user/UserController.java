package com.yoonsik.libraryapp.controller.user;

import com.yoonsik.libraryapp.dto.user.request.UserCreateRequest;
import com.yoonsik.libraryapp.dto.user.request.UserUpdateRequest;
import com.yoonsik.libraryapp.dto.user.response.UserResponse;
import com.yoonsik.libraryapp.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping
    public void updateUserName(@RequestBody UserUpdateRequest request) {
        userService.updateUserName(request);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

}
