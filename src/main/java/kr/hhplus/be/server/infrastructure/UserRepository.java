package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    //유저아이디로 유저정보가져오기
    UserEntity findByUserId(String userId);
    //유저한테 쿠폰이 있는지 확인
    UserEntity findByCouponId(String userId);
}
