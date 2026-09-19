/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class SupplierQualificationGovernanceServiceTest {
    private final SupplierQualificationGovernanceService service = new SupplierQualificationGovernanceService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void approvesQualifiedSupplier() {
        var result = service.assess(new SupplierQualificationGovernanceService.Request(
                "SUP-001", true, true, true, true, true, true, false, true));
        assertThat(result.decision()).isEqualTo(SupplierQualificationGovernanceService.Decision.APPROVE);
        assertThat(result.blockers()).isEmpty();
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void rejectsNoncompliantCriticalSupplier() {
        var result = service.assess(new SupplierQualificationGovernanceService.Request(
                "SUP-002", false, false, false, true, false, false, true, false));
        assertThat(result.decision()).isEqualTo(SupplierQualificationGovernanceService.Decision.REJECT);
        assertThat(result.blockers()).hasSize(4);
        assertThat(result.conditions()).hasSize(3);
    }
}
