/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierQualificationGovernanceService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        if (!request.sanctionsCleared()) blockers.add("受限方与制裁筛查未通过");
        if (!request.taxRegistrationValid()) blockers.add("税务登记或开票主体无效");
        if (!request.bankAccountVerified()) blockers.add("收款账户未完成独立验证");
        if (request.criticalSupplier() && !request.qualityCertificateValid()) blockers.add("关键供应商质量资质缺失或过期");
        if (!request.dataProtectionAccepted()) conditions.add("签署数据保护与保密条款");
        if (request.highFinancialRisk()) conditions.add("设置授信、预付款和持续监控限制");
        if (request.criticalSupplier() && !request.continuityPlanReviewed()) conditions.add("评审业务连续性与替代供应方案");

        Decision decision = !blockers.isEmpty() ? Decision.REJECT
                : !conditions.isEmpty() ? Decision.CONDITIONAL : Decision.APPROVE;
        return new Assessment(request.supplierCode(), decision,
                List.copyOf(blockers), List.copyOf(conditions));
    }

    public record Request(@NotBlank String supplierCode, boolean sanctionsCleared,
                          boolean taxRegistrationValid, boolean bankAccountVerified,
                          boolean criticalSupplier, boolean qualityCertificateValid,
                          boolean dataProtectionAccepted, boolean highFinancialRisk,
                          boolean continuityPlanReviewed) {}
    public record Assessment(String supplierCode, Decision decision, List<String> blockers,
                             List<String> conditions) {}
    public enum Decision { APPROVE, CONDITIONAL, REJECT }
}
