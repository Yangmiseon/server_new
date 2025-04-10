package kr.hhplus.be.server.point;

import kr.hhplus.be.server.domain.PointEntity;

public class Main {
    public static void main(String[] args) {
        PointEntity point = new PointEntity();
        point.setPointTotal(1000l);
        System.out.println(point.getPointTotal()); //정상 출력되면 Lombok 문제 없음
    }
}

