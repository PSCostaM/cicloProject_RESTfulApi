package com.ciclo.Controllers;

import java.util.List;

import com.ciclo.Dto.UserRequest;
import com.ciclo.Dto.UserResponse;
import com.ciclo.Entities.User;
import com.ciclo.Services.UserService;
import com.ciclo.Util.UserDtoConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	private UserDtoConverter converter;

	public UserController(UserService userService, UserDtoConverter converter) {
		this.userService = userService;
		this.converter = converter;
	}

	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
		User user = userService.createUser(request);
		return new ResponseEntity<>(converter.convertUserToDto(user), HttpStatus.CREATED);
	}

	@GetMapping("/findUsers")
	public ResponseEntity<List<UserResponse>> findUsers() {
		List<User> users = userService.getUsers();
		return new ResponseEntity<>(converter.convertUserToDto(users), HttpStatus.OK);
	}

	@GetMapping("/findUserById/{idUser}")
	public ResponseEntity<UserResponse> findUserById(@PathVariable Long idUser) {
		User user = userService.getUserById(idUser);
		return new ResponseEntity<>(converter.convertUserToDto(user), HttpStatus.OK);
	}
}
