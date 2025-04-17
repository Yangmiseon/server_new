package kr.hhplus.be.server.controller;

import kr.hhplus.be.server.application.PointService;
import kr.hhplus.be.server.domain.PointEntity;
import kr.hhplus.be.server.domain.PointHistoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
    public long  getUserPoint(@PathVariable String userId){

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
        return pointService.chargeUserPoint(userId,amount);
    }
}