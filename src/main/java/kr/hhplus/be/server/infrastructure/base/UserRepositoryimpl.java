package kr.hhplus.be.server.infrastructure.base;

import kr.hhplus.be.server.domain.base.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryimpl implements UserRepository {
    private final UserRepository userRepository;

    public UserRepositoryimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByCouponId(String couponId) {
        return userRepository.findByCouponId(couponId);
    }

    @Override
    public UserEntity findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
