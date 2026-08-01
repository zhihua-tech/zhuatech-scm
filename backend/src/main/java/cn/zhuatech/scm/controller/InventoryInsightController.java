/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.scm.controller;

import cn.zhuatech.scm.common.ApiResponse;
import cn.zhuatech.scm.service.InventoryCoverageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scm")
public class InventoryInsightController {
    private final InventoryCoverageService service;
    public InventoryInsightController(InventoryCoverageService service) { this.service = service; }

    @PostMapping("/inventory-coverage")
    public ApiResponse<InventoryCoverageService.Result> calculate(@Valid @RequestBody InventoryCoverageService.Request request) {
        return ApiResponse.ok(service.calculate(request));
    }
}
