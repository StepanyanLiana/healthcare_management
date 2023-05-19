package com.example.healthcare_management.security;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
private com.example.healthcare_management.entity.User user;
    public CurrentUser(com.example.healthcare_management.entity.User user) {
        super(user.getEmail(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getUserType().name()));
   this.user = user;
    }
    public com.example.healthcare_management.entity.User getUser() {
        return user;
    }
}
