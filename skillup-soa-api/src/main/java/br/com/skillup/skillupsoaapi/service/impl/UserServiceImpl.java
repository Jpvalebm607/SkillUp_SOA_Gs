package br.com.skillup.skillupsoaapi.service.impl;

import br.com.skillup.skillupsoaapi.domain.entity.User;
import br.com.skillup.skillupsoaapi.domain.enums.Role;
import br.com.skillup.skillupsoaapi.dto.UserCreateDTO;
import br.com.skillup.skillupsoaapi.dto.UserResponseDTO;
import br.com.skillup.skillupsoaapi.repository.UserRepository;
import br.com.skillup.skillupsoaapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private UserResponseDTO toResponse(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .currentProfession(user.getCurrentProfession())
                .targetProfession(user.getTargetProfession())
                .role(user.getRole().name())
                .build();
    }

    @Override
    public UserResponseDTO createUser(UserCreateDTO dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        User user = User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .currentProfession(dto.getCurrentProfession())
                .targetProfession(dto.getTargetProfession())
                .role(Role.ROLE_USER)
                .build();

        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    @Override
    public List<UserResponseDTO> listAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        userRepository.deleteById(id);
    }
}
