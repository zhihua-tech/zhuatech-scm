/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.scm.controller;

import cn.zhuatech.scm.common.ApiResponse;
import cn.zhuatech.scm.service.SupplyDisruptionScenarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scm/insights")
public class SupplyDisruptionController {
    private final SupplyDisruptionScenarioService service;

    public SupplyDisruptionController(SupplyDisruptionScenarioService service) {
        this.service = service;
    }

    @PostMapping("/supply-disruption-scenario")
    public ApiResponse<SupplyDisruptionScenarioService.Result> simulate(
        @Valid @RequestBody SupplyDisruptionScenarioService.Request request) {
        return ApiResponse.ok(service.simulate(request));
    }
}
