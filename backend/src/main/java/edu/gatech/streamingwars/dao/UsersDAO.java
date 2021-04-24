package edu.gatech.streamingwars.dao;

import edu.gatech.streamingwars.entity.User;

import java.util.List;

public interface UsersDAO {
    public List<User> findAll();
    public List<User> authenticate(String usertName,String password);
}
