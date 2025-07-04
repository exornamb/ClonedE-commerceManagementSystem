package com.codewithmosh.store.mapper;

import com.codewithmosh.store.dtos.RegisterUserRequest;
import com.codewithmosh.store.dtos.UpdateUserRequest;
import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    to make from user to user dto
    UserDto toUserDto(User user);
    User toEntity(RegisterUserRequest request);
    void updateUser(UpdateUserRequest request, @MappingTarget User user);

}
