package com.kadi.dao;

import com.kadi.DataStore;
import com.kadi.entities.User;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
