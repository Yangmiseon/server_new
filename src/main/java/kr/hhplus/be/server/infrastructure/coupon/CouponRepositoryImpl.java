package kr.hhplus.be.server.infrastructure;

import kr.hhplus.be.server.domain.CouponEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CouponRepositoryImpl implements CouponRepository{
    private final JpaCouponRepository jpaCouponRepository;

    public CouponRepositoryImpl (JpaCouponRepository jpaCouponRepository){
        this.jpaCouponRepository=jpaCouponRepository;
    }

    @Override
    public CouponEntity save(CouponEntity coupon){
        return jpaCouponRepository.save(coupon);
    }
}
