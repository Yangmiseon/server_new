package kr.hhplus.be.server.application.base;

import kr.hhplus.be.server.domain.base.UserEntity;
import kr.hhplus.be.server.infrastructure.base.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    //userId로 쿠폰유무확인하기
    public String findByUserId(String userId) {
        return userRepository.findByUserId(userId).getUserCouponYN();
    }

    public UserEntity createUser(UserEntity user) {
        return null;
    }
}
