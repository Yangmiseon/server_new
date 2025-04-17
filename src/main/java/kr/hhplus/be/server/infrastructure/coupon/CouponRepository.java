package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface CouponRepository{
    //어떤 종류의 쿠폰을 발급할건지 관리자가 등록
    CouponEntity save(CouponEntity couponIssued);
}
