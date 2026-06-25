package org.example.springdatajpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User addUser(User user) {
        return userRepository.save(user);
    }

    //수정
    @Transactional
    public User updateUser(User user) {
        User updateUser = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());

        return updateUser;
    }

    //삭제
    public void deleteUser(Long id) {
        User deleteUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepository.deleteById(id);
    }

    //조회(여러건)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //id에 해당하는 한건 조회
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

}
