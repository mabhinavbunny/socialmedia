package com.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ums.beans.Networking;
import com.ums.beans.ResponseObj;
import com.ums.beans.User;
import com.ums.exceptions.UserException;
import com.ums.model.UserModel;
import com.ums.model.UserNetworkingModel;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserModel userModel;
	@Autowired
	UserNetworkingModel userNetworkingModel;
	
	@PostMapping("createUser")
	public ResponseObj<User> createUser(@RequestBody User user){
		System.out.println("Calling create user with paramaneters "+user);
		User createdUser;
		ResponseObj<User> response;
		try {
			createdUser = userModel.saveUser(user);
			response = (createdUser!=null)? createResponse("200","user created",user):createResponse("400", "Could not create user", null);
		} catch (UserException e) {
			e.printStackTrace();
			response  = createResponse("400", e.getMessage(), null);
		}
		System.out.println("Responding create user with response "+response);
		return response;
	}
	
	@GetMapping("getUser")
	public ResponseObj<User> getUser(@RequestParam(name = "email") String email){
		System.out.println("Calling getUser with paramaneters "+email);
		User user = userModel.getUser(email);
		ResponseObj<User> response = user!=null ? createResponse("200", "User Found", user):createResponse("400", "User Not found",null);
		System.out.println("Responding getUser with response "+response);
		return response;
	}
	
	@PostMapping("changeUserRelationShipStatus")
	public ResponseObj<String> changeUserRelationShipStatus(@RequestBody Networking networking ){
		System.out.println("Calling change user relationship status "+networking);
		if(userNetworkingModel.changeUserNetworkingStatus(networking).getRelationshipStatus()!=networking.getRelationshipStatus()) {
			ResponseObj<String> response = createResponse("200", "User relation changed", "User relationship changed ");
			System.out.println("Responding getUser with response "+response);
			return response;
		}
		else {
			ResponseObj<String> response = createResponse("200", "User relation could not be changed", "User relationship could not be changed  ");
			System.out.println("Responding getUser with response "+response);
			return response;	
		}
	}
	
	private < E > ResponseObj<E>  createResponse(String number ,String message, E object){
		return new ResponseObj<E>(number, message, object);
	}
}
