/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.model;
import jakarta.persistence.*;import java.math.BigDecimal;
@Entity @Table(name="scm_supplier") public class Supplier extends BaseEntity {
    @Column(nullable=false,unique=true,length=24) private String code;@Column(nullable=false,length=100) private String name;@Column(nullable=false,length=20) private String grade;@Column(nullable=false,precision=5,scale=2) private BigDecimal onTimeRate;@Column(nullable=false,precision=5,scale=2) private BigDecimal qualityRate;@Column(nullable=false,length=20) private String status;
    protected Supplier(){} public Supplier(String code,String name,String grade,BigDecimal onTimeRate,BigDecimal qualityRate,String status){this.code=code;this.name=name;this.grade=grade;this.onTimeRate=onTimeRate;this.qualityRate=qualityRate;this.status=status;}
    public String getCode(){return code;} public String getName(){return name;} public String getGrade(){return grade;} public BigDecimal getOnTimeRate(){return onTimeRate;} public BigDecimal getQualityRate(){return qualityRate;} public String getStatus(){return status;}
}
