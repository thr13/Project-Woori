package com.woori.backend.user;

import com.woori.backend.global.exception.ErrorCode;
import com.woori.backend.user.dto.request.UserSignUpRequest;
import com.woori.backend.user.exception.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpRequest userSignUpRequest) {
        if (userRepository.findByEmail(userSignUpRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
        String encodedPassword = passwordEncoder.encode(userSignUpRequest.getPassword());

        User user = User.createUser(
                userSignUpRequest.getEmail(),
                encodedPassword,
                userSignUpRequest.getName(),
                userSignUpRequest.getRole()
        );

        userRepository.save(user);
    }

}
