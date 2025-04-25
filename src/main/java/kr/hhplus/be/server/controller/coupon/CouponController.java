package kr.hhplus.be.server.controller.coupon;

import kr.hhplus.be.server.application.coupon.CouponService;
import kr.hhplus.be.server.domain.coupon.CouponEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/issue")
    public ResponseEntity<CouponEntity> issuedCoupon(
            @RequestParam String userId,
            @RequestParam String couponSpecId
    ) {
        return ResponseEntity.ok(couponService.IssuedCoupon(userId, couponSpecId));
    }
}
