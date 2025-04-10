package kr.hhplus.be.server.domain;

public enum CouponType {
    RATE{
        @Override
        public  int applyDiscount(long totalPrice, int discountValue){
            return (int) (totalPrice*(1 - (discountValue/100.0)));
        }
    },
    AMOUNT{
        @Override
        public int applyDiscount(long totalPrice, int discountValue){
            return (int) (totalPrice-discountValue);
        }
    };

    // 공통 메서드 선언
    public abstract int applyDiscount(long totalPrice, int discountValue);
}
