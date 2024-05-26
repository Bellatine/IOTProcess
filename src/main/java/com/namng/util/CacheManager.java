package com.namng.util;

import com.namng.model.User;

import java.util.Map;

public class CacheManager {

    public class Status{
        public static int ACTIVE = 1;
        public static int INACTIVE = 0;
    }
    public class Role{
        public static int ADMIN = 1;
        public static int VIEWER = 2;
    }

    public class Users{
        public static Map<String, User> ALLUSERS;
        public static User AUTH_USER;
    }

}
