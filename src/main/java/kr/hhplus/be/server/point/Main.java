package kr.hhplus.be.server.point;

import kr.hhplus.be.server.domain.point.PointEntity;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PointEntity point = new PointEntity();
        point.setPointTotal(BigDecimal.valueOf(1000l));
        System.out.println(point.getPointTotal()); //정상 출력되면 Lombok 문제 없음
    }
}

