/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryCoverageService {
    public Result calculate(Request request) {
        int available = request.onHandQty() + request.inTransitQty();
        double coverageDays = Math.round(available * 100.0 / request.dailyDemand()) / 100.0;
        int reorderPoint = request.dailyDemand() * request.leadDays() + request.safetyStock();
        int shortageQty = Math.max(0, reorderPoint - available);
        String status = coverageDays < request.leadDays() ? "CRITICAL"
            : shortageQty > 0 ? "REPLENISH" : "HEALTHY";
        List<String> actions = new ArrayList<>();
        if (shortageQty > 0) actions.add("创建不少于建议缺口量的补货申请");
        if (coverageDays < request.leadDays()) actions.add("评估加急采购或跨仓调拨");
        if (actions.isEmpty()) actions.add("维持现有补货节奏");
        return new Result(request.materialCode(), available, coverageDays, reorderPoint, shortageQty, status, actions);
    }

    public record Request(@NotBlank String materialCode, @Positive int dailyDemand,
                          @Min(0) int onHandQty, @Min(0) int inTransitQty,
                          @Min(0) int safetyStock, @Positive int leadDays) {}
    public record Result(String materialCode, int availableQty, double coverageDays,
                         int reorderPoint, int shortageQty, String status, List<String> actions) {}
}
