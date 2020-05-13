package com.ums.Dao;
import org.springframework.data.repository.CrudRepository;

import com.ums.beans.User;
public interface UserDao extends CrudRepository<User,String> {
}
