/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.controller;

import cn.zhuatech.scm.common.ApiResponse;
import cn.zhuatech.scm.service.SafetyStockRecommendationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/scm/insights/safety-stock")
public class SafetyStockRecommendationController {
    private final SafetyStockRecommendationService service;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public SafetyStockRecommendationController(SafetyStockRecommendationService service) {
        this.service = service;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping
    public ApiResponse<SafetyStockRecommendationService.Result> recommend(
            @Valid @RequestBody SafetyStockRecommendationService.Request request) {
        return ApiResponse.ok(service.recommend(request));
    }
}
