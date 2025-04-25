package kr.hhplus.be.server.application.coupon;

import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import kr.hhplus.be.server.infrastructure.coupon.CouponSpecRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CouponSpecService {
    private final CouponSpecRepository couponSpecRepository;

//
//        CouponSpecEntity coupon = couponSpecRepository.findById(UUID.fromString(couponId))
//                .orElseThrow(() -> new NoSuchElementException("쿠폰을 찾을 수 없습니다."));
//
//        coupon.minusCouponCount();
//        couponSpecRepository.save(coupon);
//
//        return CouponResponse.from(coupon);
//    }

    //쿠폰 등록
    public CouponSpecEntity createCoupon(CouponSpecRequestDto requestDto) {

        CouponSpecEntity entity = new CouponSpecEntity();
        entity.setType(requestDto.getType());
        entity.setCouponDiscount(requestDto.getCouponDiscount());
        entity.setCouponTotalQuantity(requestDto.getCouponTotalQuantity());

        return couponSpecRepository.save(entity);
    }

}
