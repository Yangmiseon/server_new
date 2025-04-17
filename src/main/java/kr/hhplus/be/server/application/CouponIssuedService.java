package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.CouponEntity;
import kr.hhplus.be.server.infrastructure.CouponIssuedRepository;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponIssuedService {
    private final CouponIssuedRepository couponIssuedRepository;

    @Transactional
    public void post(OrderRequestDto.CouponRequestDto couponRequestDto){
        List<CouponEntity> all = couponIssuedRepository.findAll();


    }
}
