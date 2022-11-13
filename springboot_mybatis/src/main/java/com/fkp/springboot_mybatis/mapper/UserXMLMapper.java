package com.fkp.springboot_mybatis.mapper;

import com.fkp.springboot_mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserXMLMapper {

    List<User> findAll2();

}
