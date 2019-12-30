package com.wu.kefubbs.service;

import com.wu.kefubbs.commons.LayUIResult;

public interface UserService {
    LayUIResult login(String username, String password);
}
