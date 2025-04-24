package kr.hhplus.be.server.infrastructure.base;

import kr.hhplus.be.server.domain.base.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, String> {
    //유저한테 쿠폰이 있는지 확인
    UserEntity findByUserId(String userId);
    //유저한테 쿠폰이 있는지 확인
    UserEntity findByCouponId(String userId);
}
