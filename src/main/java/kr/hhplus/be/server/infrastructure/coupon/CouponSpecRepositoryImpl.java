package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.application.coupon.CouponSpecRequestDto;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CouponSpecRepositoryImpl implements CouponSpecRepository {
    private final JpaCouponSpecRepository jpaCouponSpecRepository;

    public CouponSpecRepositoryImpl(JpaCouponSpecRepository jpaCouponSpecRepository) {
        this.jpaCouponSpecRepository = jpaCouponSpecRepository;
    }

    @Override
    public Optional<CouponSpecEntity> findById(String couponId) {

        return jpaCouponSpecRepository.findById(couponId);
    }

    @Override
    public CouponSpecEntity save(CouponSpecEntity couponSpecEntity) {
        return jpaCouponSpecRepository.save(couponSpecEntity);
    }

    @Override
    public CouponSpecEntity create(CouponSpecRequestDto couponSpecRequestDto) {
        return jpaCouponSpecRepository.create(couponSpecRequestDto);
    }
}
