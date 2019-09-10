package com.perfecttest.tms.storage.users;

import com.perfecttest.tms.domain.User;

import java.util.List;

public interface UsersDao {

    User getUserById(int id);

    List<User> getAllUsers();
}
