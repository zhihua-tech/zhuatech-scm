/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm;

import cn.zhuatech.scm.service.SupplyDisruptionScenarioService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class SupplyDisruptionScenarioServiceTests {
    private final SupplyDisruptionScenarioService service = new SupplyDisruptionScenarioService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void quantifiesShortageBeforeDelayedInboundArrives() {
        var result = service.simulate(new SupplyDisruptionScenarioService.Request(
            "MAT-STEEL-01", new BigDecimal("500"), new BigDecimal("100"),
            new BigDecimal("2000"), 8, new BigDecimal("100"), 3));

        assertEquals(new BigDecimal("6.0"), result.preArrivalCoverageDays());
        assertEquals(new BigDecimal("500.00"), result.shortageQuantity());
        assertEquals("SHORTAGE", result.decision());
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void recognizesCoveredDisruptionWindow() {
        var result = service.simulate(new SupplyDisruptionScenarioService.Request(
            "MAT-RESIN-02", new BigDecimal("1800"), new BigDecimal("100"),
            new BigDecimal("1000"), 5, new BigDecimal("200"), 3));

        assertEquals("COVERED", result.decision());
    }
}
