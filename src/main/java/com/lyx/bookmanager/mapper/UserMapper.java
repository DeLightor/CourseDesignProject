package com.lyx.bookmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyx.bookmanager.pojo.Record;
import com.lyx.bookmanager.pojo.User;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.BaseStream;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUserByUsername(String username);
    void changePassword(String username, String newPassword);
    String getPassword(String username);
}
