package com.nan.dao;

import com.nan.entity.UserEntity;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberDao {

    @Select("select id,username,password,phone,email,created,updated from mb_user where id =#{userID}")
    UserEntity findUserByID(@Param("userID") long id);

     @Insert("INSERT  INTO `mb_user`  (username,password,phone,email,created,updated) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated});")
      boolean insertUser(UserEntity userEntity);


     @Select("select id,username,password,phone,email,created,updated from mb_user where username=#{username} and password=#{password}")
     UserEntity userLogin(@Param("username")String userName,@Param("password")String password);

}
