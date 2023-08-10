package com.system.helmethub.service;


import com.system.helmethub.dto.UserDto;
import com.system.helmethub.entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void register(UserDto userDto) ;

    Optional<User> getActiveUser();


}
