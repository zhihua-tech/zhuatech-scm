/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.controller;

import cn.zhuatech.scm.common.ApiResponse;
import cn.zhuatech.scm.service.SupplierQualificationGovernanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enterprise/scm")
public class SupplierQualificationGovernanceController {
    private final SupplierQualificationGovernanceService service;
    public SupplierQualificationGovernanceController(SupplierQualificationGovernanceService service) { this.service = service; }

    @PostMapping("/supplier-qualification")
    public ApiResponse<SupplierQualificationGovernanceService.Assessment> assess(
            @Valid @RequestBody SupplierQualificationGovernanceService.Request request) {
        return ApiResponse.ok("供应商准入评估完成", service.assess(request));
    }
}
