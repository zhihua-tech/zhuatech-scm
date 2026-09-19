/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.controller;

import cn.zhuatech.scm.common.ApiResponse;
import cn.zhuatech.scm.service.InventoryCoverageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/scm")
public class InventoryInsightController {
    private final InventoryCoverageService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public InventoryInsightController(InventoryCoverageService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/inventory-coverage")
    public ApiResponse<InventoryCoverageService.Result> calculate(@Valid @RequestBody InventoryCoverageService.Request request) {
        return ApiResponse.ok(service.calculate(request));
    }
}
