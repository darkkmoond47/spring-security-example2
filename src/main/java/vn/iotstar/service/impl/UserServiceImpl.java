package vn.iotstar.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import vn.iotstar.dto.UserDTO;
import vn.iotstar.entity.User;
import vn.iotstar.mapper.UserMapper;
import vn.iotstar.repository.UserRepository;
import vn.iotstar.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserDTO> findAll() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }


    @Override
    public UserDTO findById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow();

        return userMapper.toDTO(user);
    }


    @Override
    public UserDTO save(UserDTO dto) {

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        user.setImages(dto.getImages());
        user.setEnabled(dto.isEnabled());

        return userMapper.toDTO(
                userRepository.save(user)
        );
    }


    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }
}