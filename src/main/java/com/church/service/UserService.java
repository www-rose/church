package com.church.service;

import java.util.List;


import com.church.model.User;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}
