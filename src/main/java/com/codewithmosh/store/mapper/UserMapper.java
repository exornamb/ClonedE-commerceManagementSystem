package com.codewithmosh.store.mapper;

import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    to make from user to user dto
    UserDto toUserDto(User user);

}
