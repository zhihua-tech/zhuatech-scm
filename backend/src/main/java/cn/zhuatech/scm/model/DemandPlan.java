/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.model;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.LocalDate;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="scm_demand_plan") public class DemandPlan extends BaseEntity {
    @Column(nullable=false,unique=true,length=32) private String planNo;@ManyToOne(fetch=FetchType.LAZY,optional=false) private Material material;@Column(nullable=false,precision=14,scale=2) private BigDecimal requiredQty;@Column(nullable=false) private LocalDate requiredDate;@Column(nullable=false,length=24) private String status;@Column(nullable=false,length=80) private String source;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected DemandPlan(){} /**
                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                              */
public DemandPlan(String planNo,Material material,BigDecimal requiredQty,LocalDate requiredDate,String status,String source){this.planNo=planNo;this.material=material;this.requiredQty=requiredQty;this.requiredDate=requiredDate;this.status=status;this.source=source;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getPlanNo(){return planNo;} /**
                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                               */
public Material getMaterial(){return material;} /**
                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                               */
public BigDecimal getRequiredQty(){return requiredQty;} /**
                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                       */
public LocalDate getRequiredDate(){return requiredDate;} /**
                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                */
public String getStatus(){return status;} /**
                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                          */
public String getSource(){return source;} /**
                                                                                                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                    */
public void setStatus(String status){this.status=status;}
}
