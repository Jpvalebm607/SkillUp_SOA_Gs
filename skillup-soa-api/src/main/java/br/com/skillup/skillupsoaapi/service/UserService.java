package br.com.skillup.skillupsoaapi.service;

import br.com.skillup.skillupsoaapi.dto.UserCreateDTO;
import br.com.skillup.skillupsoaapi.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserCreateDTO dto);

    List<UserResponseDTO> listAllUsers();

    UserResponseDTO getUserById(Long id);

    void deleteUser(Long id);
}
