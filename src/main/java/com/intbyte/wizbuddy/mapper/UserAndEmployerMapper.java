package com.intbyte.wizbuddy.mapper;

import com.intbyte.wizbuddy.user.domain.RegisterEmployerInfo;
import com.intbyte.wizbuddy.user.domain.SignInUserInfo;
import com.intbyte.wizbuddy.user.domain.entity.Employer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAndEmployerMapper {
    void insertUser(SignInUserInfo signInUserInfo);

    void insertEmployer(RegisterEmployerInfo registerEmployerInfo);

    Employer getUserByEmployerEmail(String userEmail);
}