package kr.hhplus.be.server.controller.point;

import kr.hhplus.be.server.application.point.PointService;
import kr.hhplus.be.server.domain.point.PointEntity;
import kr.hhplus.be.server.domain.point.PointHistoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/point")
class PointController {
    private static final Logger logger = LoggerFactory.getLogger(PointController.class);
    private PointService pointService;

    public PointController(PointService pointService) {

        this.pointService = pointService;
    }

    //포인트 조회
    @GetMapping("/point/pointTotal")
    public BigDecimal getUserPoint(@PathVariable String userId){

        return pointService.getUserPoint(userId);
    }

    //포인트 이력 조회
    @GetMapping("/point/pointHistory")
    public List<PointHistoryEntity> getPointHistoryEntityList (@PathVariable String userId){

        return pointService.getUserPointHistory(userId);
    }

    //포인트 충전
    @PatchMapping("/point/charge")
    public PointEntity charge(
            @PathVariable String userId,
            @RequestParam long amount
    ) {
        return pointService.chargeUserPoint(userId, BigDecimal.valueOf(amount));
    }
}