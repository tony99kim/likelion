package org.example.restapitask.service;

import lombok.RequiredArgsConstructor;
import org.example.restapitask.domain.Role;
import org.example.restapitask.domain.User;
import org.example.restapitask.dto.UserDto;
import org.example.restapitask.exception.DuplicateUserException;
import org.example.restapitask.exception.UserNotFoundException;
import org.example.restapitask.repository.RoleRepository;
import org.example.restapitask.repository.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto.Response createUser(UserDto.CreateRequest request) {
        if (userRepository.existsByLoginId(request.loginId())) {
            throw new DuplicateUserException(request.loginId());
        }

        Role userRole = roleRepository.findByName("USER")
                .orElseGet(() -> roleRepository.save(Role.user()));

        User user = User.builder()
                .name(request.name())
                .loginId(request.loginId())
                .password(passwordEncoder.encode(request.password()))
                .email(request.email())
                .build();

        user.addRole(userRole);

        User savedUser = userRepository.save(user);

        return UserDto.Response.from(savedUser);
    }

    @Transactional
    public void deleteUser(Long id, User currentUser) {
        User targetUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        boolean isOwner = targetUser.getId().equals(currentUser.getId());
        boolean isAdmin = currentUser.hasRole("ADMIN");

        if (!isOwner && !isAdmin) {
            throw new AccessDeniedException("본인 계정 또는 관리자만 삭제할 수 있습니다.");
        }

        userRepository.delete(targetUser);
    }
}