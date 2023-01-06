package service;

import dto.UserDto;
import entity.User;

import java.util.List;

public interface UserService {

    User findByName(String name);

    void delete(Long id);

    List<User> findAll();

    void save(UserDto object);

    void update (UserDto object, Long id);
}
