/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.scm.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplyDisruptionScenarioService {
    public Result simulate(Request request) {
        BigDecimal preArrivalSupply = request.onHandQuantity().add(request.alternativeSupplyQuantity());
        BigDecimal coverageDays = preArrivalSupply.divide(request.dailyDemand(), 1, RoundingMode.DOWN);
        BigDecimal requiredBeforeArrival = request.dailyDemand()
            .multiply(BigDecimal.valueOf(request.inboundDelayDays() + request.safetyStockDays()));
        BigDecimal shortage = requiredBeforeArrival.subtract(preArrivalSupply)
            .max(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
        BigDecimal watchBoundary = BigDecimal.valueOf(
            request.inboundDelayDays() + request.safetyStockDays() + 3L);
        String decision = shortage.signum() > 0 ? "SHORTAGE"
            : coverageDays.compareTo(watchBoundary) < 0 ? "WATCH" : "COVERED";

        List<String> actions = new ArrayList<>();
        if (shortage.signum() > 0) actions.add("加急或替代采购至少 " + shortage.toPlainString() + " 个单位");
        if (request.alternativeSupplyQuantity().signum() == 0) actions.add("启用备选供应商或跨仓调拨方案");
        if (!"COVERED".equals(decision)) actions.add("冻结低优先级需求并每日滚动更新到货承诺");
        if (actions.isEmpty()) actions.add("维持当前补货计划并监控在途节点");
        return new Result(request.materialCode(), coverageDays, shortage,
            request.inboundQuantity(), decision, actions);
    }

    public record Request(@NotBlank String materialCode,
                          @DecimalMin("0") BigDecimal onHandQuantity,
                          @DecimalMin("0.01") BigDecimal dailyDemand,
                          @DecimalMin("0") BigDecimal inboundQuantity,
                          @Min(0) int inboundDelayDays,
                          @DecimalMin("0") BigDecimal alternativeSupplyQuantity,
                          @Min(0) int safetyStockDays) {}

    public record Result(String materialCode, BigDecimal preArrivalCoverageDays,
                         BigDecimal shortageQuantity, BigDecimal delayedInboundQuantity,
                         String decision, List<String> actions) {}
}
