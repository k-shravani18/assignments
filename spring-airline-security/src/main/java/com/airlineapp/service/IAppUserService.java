package com.airlineapp.service;


import com.airlineapp.model.AppUser;

public interface IAppUserService {
    void addUser(AppUser appUser);
    void updateUser(AppUser appUser);
    void deleteUser(int userId);
}
