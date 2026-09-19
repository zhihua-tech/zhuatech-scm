/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm;

import cn.zhuatech.scm.service.SafetyStockRecommendationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class SafetyStockRecommendationServiceTests {
    private final SafetyStockRecommendationService service = new SafetyStockRecommendationService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void recommendsImmediateOrderForLowInventoryPosition() {
        var result = service.recommend(new SafetyStockRecommendationService.Request(20, 8, 10, 2, 0.97, 80, 20));
        assertEquals("ORDER_NOW", result.status());
        assertTrue(result.suggestedOrderQuantity() > 0);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void keepsHealthyInventoryUnderControl() {
        var result = service.recommend(new SafetyStockRecommendationService.Request(10, 2, 5, 0.5, 0.95, 200, 30));
        assertEquals("HEALTHY", result.status());
        assertEquals(0, result.suggestedOrderQuantity());
    }
}
