package kr.hhplus.be.server.controller.coupon;

import kr.hhplus.be.server.application.coupon.CouponSpecRequestDto;
import kr.hhplus.be.server.application.coupon.CouponSpecService;
import kr.hhplus.be.server.domain.coupon.CouponSpecEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/couponSpec")
public class CouponSpecController {

    private CouponSpecService couponSpecService;

    public CouponSpecController(CouponSpecService couponSpecService) {
        this.couponSpecService = couponSpecService;
    }

    @PostMapping
    public ResponseEntity<CouponSpecEntity> create (@RequestBody CouponSpecRequestDto couponSpecRequestDto) {
        return ResponseEntity.ok(couponSpecService.createCoupon(couponSpecRequestDto));
    }

}
