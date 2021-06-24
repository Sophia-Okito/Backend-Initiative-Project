package com.sophia.movierentalapi.controller;

import com.sophia.movierentalapi.model.User;
import com.sophia.movierentalapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable(value = "username") String username) {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "username") String username, @Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(username, user), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "username") String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("User account deleted successfully", HttpStatus.OK);
    }


}
