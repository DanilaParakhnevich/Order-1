package service.impl;

import dto.UserDto;
import entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.UserService;
import persistance.*;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserDto userDto) {
        User user = new User();
        userRepository.save(setUser(user,userDto));
    }

    @Override
    public void update(UserDto userDto, Long id) {
        userRepository.findById(id).map(newUser -> userRepository
                .save(setUser(newUser,userDto )));
    }

    private User setUser(User user,UserDto userDto){
        user.setName(userDto.getName());
        user.setPosition(userDto.getPosition());

        return user;
    }
}
