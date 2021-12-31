package org.example.springboard.user;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboard.user.model.UserEntity;

@Mapper
public interface UserMapper {
    int join(UserEntity entity); // 회원가입.
    UserEntity selUser(UserEntity entity); // 로그인.
}
