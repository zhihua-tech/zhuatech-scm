/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.scm;

import cn.zhuatech.scm.service.SupplyDisruptionScenarioService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplyDisruptionScenarioServiceTests {
    private final SupplyDisruptionScenarioService service = new SupplyDisruptionScenarioService();

    @Test
    void quantifiesShortageBeforeDelayedInboundArrives() {
        var result = service.simulate(new SupplyDisruptionScenarioService.Request(
            "MAT-STEEL-01", new BigDecimal("500"), new BigDecimal("100"),
            new BigDecimal("2000"), 8, new BigDecimal("100"), 3));

        assertEquals(new BigDecimal("6.0"), result.preArrivalCoverageDays());
        assertEquals(new BigDecimal("500.00"), result.shortageQuantity());
        assertEquals("SHORTAGE", result.decision());
    }

    @Test
    void recognizesCoveredDisruptionWindow() {
        var result = service.simulate(new SupplyDisruptionScenarioService.Request(
            "MAT-RESIN-02", new BigDecimal("1800"), new BigDecimal("100"),
            new BigDecimal("1000"), 5, new BigDecimal("200"), 3));

        assertEquals("COVERED", result.decision());
    }
}
