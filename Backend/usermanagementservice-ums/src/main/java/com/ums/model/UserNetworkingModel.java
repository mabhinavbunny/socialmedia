package com.ums.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Component;

import com.ums.Dao.UserNetworking;
import com.ums.beans.Networking;

@Persistent
@Component
public class UserNetworkingModel {
	@Autowired
	UserNetworking userNetworking;
	
	public Networking changeUserNetworkingStatus(Networking networking) {
		List<Networking> networkingUsr = userNetworking.findByUser1AndUser2(networking.getUser1(), networking.getUser2());
		List<Networking> friendRequest = networkingUsr.stream().filter(i -> i.getRelationshipStatus() == 1).collect(Collectors.toList());
	
		if(friendRequest.size()>0) {
			int i = friendRequest.get(0).getId();
			networking.setId(i);
			userNetworking.save(networking);
		}
		else
			userNetworking.save(networking);
		return networking;
	}
	public boolean checkIfUserIsBlocked(String user1,String user2) {
		List<Networking> networking=userNetworking.findByUser1AndUser2(user1, user2).stream().filter(i->i.getRelationshipStatus() ==3).collect(Collectors.toList());
		if(networking.size()!=0)
			return true;
		else
			return false;
	}
}
