package kr.hhplus.be.server.domain.coupon;

import java.math.BigDecimal;

public enum CouponType {
    RATE {
        @Override
        public BigDecimal applyDiscount(BigDecimal totalPrice, int discountValue) {
            BigDecimal discountRate = BigDecimal.valueOf(discountValue).divide(BigDecimal.valueOf(100));
            return totalPrice.multiply(BigDecimal.ONE.subtract(discountRate));
        }
    },
    AMOUNT {
        @Override
        public BigDecimal applyDiscount(BigDecimal totalPrice, int discountValue) {
            return totalPrice.subtract(BigDecimal.valueOf(discountValue));
        }
    };

    public abstract BigDecimal applyDiscount(BigDecimal totalPrice, int discountValue);
}
