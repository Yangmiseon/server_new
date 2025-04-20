package kr.hhplus.be.server.application.coupon;

import kr.hhplus.be.server.domain.coupon.CouponEntity;
import kr.hhplus.be.server.infrastructure.coupon.CouponRepository;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponIssuedService {
    private final CouponRepository couponRepository;

    @Transactional
    public void post(CouponRequestDto couponRequestDto){
        List<CouponEntity> all = Collections.singletonList(couponRepository.save(couponRequestDto.toModel()));
    }
}
