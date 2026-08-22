/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.model;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.LocalDate;
@Entity @Table(name="scm_demand_plan") public class DemandPlan extends BaseEntity {
    @Column(nullable=false,unique=true,length=32) private String planNo;@ManyToOne(fetch=FetchType.LAZY,optional=false) private Material material;@Column(nullable=false,precision=14,scale=2) private BigDecimal requiredQty;@Column(nullable=false) private LocalDate requiredDate;@Column(nullable=false,length=24) private String status;@Column(nullable=false,length=80) private String source;
    protected DemandPlan(){} public DemandPlan(String planNo,Material material,BigDecimal requiredQty,LocalDate requiredDate,String status,String source){this.planNo=planNo;this.material=material;this.requiredQty=requiredQty;this.requiredDate=requiredDate;this.status=status;this.source=source;}
    public String getPlanNo(){return planNo;} public Material getMaterial(){return material;} public BigDecimal getRequiredQty(){return requiredQty;} public LocalDate getRequiredDate(){return requiredDate;} public String getStatus(){return status;} public String getSource(){return source;} public void setStatus(String status){this.status=status;}
}
