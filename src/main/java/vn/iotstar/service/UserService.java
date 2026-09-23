package vn.iotstar.service;

import java.util.List;

import vn.iotstar.dto.UserDTO;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO save(UserDTO dto);

    void delete(Long id);

}