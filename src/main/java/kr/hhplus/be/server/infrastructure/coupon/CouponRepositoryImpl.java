package kr.hhplus.be.server.infrastructure.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CouponRepositoryImpl implements CouponRepository{
    private final JpaCouponRepository jpaCouponRepository;

    public CouponRepositoryImpl (JpaCouponRepository jpaCouponRepository){
        this.jpaCouponRepository=jpaCouponRepository;
    }

    @Override
    public CouponEntity save(CouponEntity couponIssued){

        return jpaCouponRepository.save(couponIssued);
    }

    @Override
    public CouponEntity findByUserId(String Userid) {

        return jpaCouponRepository.findByUserId(Userid);
    }

    @Override
    public CouponEntity update(CouponEntity coupon) {

        return jpaCouponRepository.save(coupon);
    }

}
