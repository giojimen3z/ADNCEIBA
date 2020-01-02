package com.an.parking.domain.repository;

import com.an.parking.domain.dto.User;

public interface IUserRepository {

    User createUser(User user);

    User queryUserById(Long userId);

}
