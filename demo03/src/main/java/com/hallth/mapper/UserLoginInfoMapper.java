package com.hallth.mapper;

import com.hallth.domain.UserLoginInfo;

public interface UserLoginInfoMapper {
    int deleteByPrimaryKey(String loginUserId);

    int insert(UserLoginInfo record);

    int insertSelective(UserLoginInfo record);

    UserLoginInfo selectByPrimaryKey(String loginUserId);

    int updateByPrimaryKeySelective(UserLoginInfo record);

    int updateByPrimaryKey(UserLoginInfo record);
}