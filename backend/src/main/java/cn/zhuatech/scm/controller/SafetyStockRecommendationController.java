/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.scm.controller;

import cn.zhuatech.scm.common.ApiResponse;
import cn.zhuatech.scm.service.SafetyStockRecommendationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scm/insights/safety-stock")
public class SafetyStockRecommendationController {
    private final SafetyStockRecommendationService service;

    public SafetyStockRecommendationController(SafetyStockRecommendationService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<SafetyStockRecommendationService.Result> recommend(
            @Valid @RequestBody SafetyStockRecommendationService.Request request) {
        return ApiResponse.ok(service.recommend(request));
    }
}
