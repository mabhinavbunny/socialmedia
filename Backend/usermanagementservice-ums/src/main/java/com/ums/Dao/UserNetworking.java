package com.ums.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ums.beans.Networking;

public interface UserNetworking extends CrudRepository<Networking, Integer> {
	public List<Networking> findByUser1AndUser2(String user1,String user2);
}
