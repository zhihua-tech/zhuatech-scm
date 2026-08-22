/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SafetyStockRecommendationService {

    public Result recommend(Request request) {
        double z = request.serviceLevel() >= 0.99 ? 2.33
                : request.serviceLevel() >= 0.97 ? 1.88
                : request.serviceLevel() >= 0.95 ? 1.65 : 1.28;
        double variance = request.leadTimeDays() * Math.pow(request.demandStdDev(), 2)
                + Math.pow(request.averageDailyDemand(), 2) * Math.pow(request.leadTimeStdDev(), 2);
        int safetyStock = (int) Math.ceil(z * Math.sqrt(variance));
        int reorderPoint = (int) Math.ceil(request.averageDailyDemand() * request.leadTimeDays() + safetyStock);
        int inventoryPosition = request.currentStock() + request.inboundStock();
        int suggestedOrder = Math.max(0, reorderPoint - inventoryPosition);
        String status = suggestedOrder > 0 ? "ORDER_NOW"
                : inventoryPosition < reorderPoint * 1.2 ? "WATCH" : "HEALTHY";

        List<String> actions = new ArrayList<>();
        if (suggestedOrder > 0) actions.add("立即补货并确认供应商交期");
        if (request.leadTimeStdDev() > 2) actions.add("治理交期波动并建立备选供应渠道");
        if (request.demandStdDev() > request.averageDailyDemand() * 0.5) actions.add("缩短预测滚动周期并提高需求评审频率");
        if (actions.isEmpty()) actions.add("维持当前补货策略并按周复核参数");
        return new Result(safetyStock, reorderPoint, inventoryPosition, suggestedOrder, status, actions);
    }

    public record Request(
            @DecimalMin("0.01") double averageDailyDemand,
            @DecimalMin("0") double demandStdDev,
            @DecimalMin("0.1") double leadTimeDays,
            @DecimalMin("0") double leadTimeStdDev,
            @DecimalMin("0.90") @DecimalMax("0.999") double serviceLevel,
            int currentStock,
            int inboundStock
    ) {}

    public record Result(int safetyStock, int reorderPoint, int inventoryPosition,
                         int suggestedOrderQuantity, String status, List<String> actions) {}
}
