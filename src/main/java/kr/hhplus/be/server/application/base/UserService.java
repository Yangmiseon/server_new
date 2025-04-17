package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.UserEntity;
import kr.hhplus.be.server.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //userId생성
    public UserEntity createUser(UserEntity user){
        return userRepository.save(user);
    }


}
