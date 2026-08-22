/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.model;
import jakarta.persistence.*;import java.math.BigDecimal;
@Entity @Table(name="scm_material") public class Material extends BaseEntity {
    @Column(nullable=false,unique=true,length=32) private String code;@Column(nullable=false,length=100) private String name;@Column(nullable=false,length=40) private String category;@Column(nullable=false,length=16) private String unit;@Column(nullable=false,precision=14,scale=2) private BigDecimal safetyStock;@Column(nullable=false,precision=14,scale=2) private BigDecimal currentStock;
    protected Material(){} public Material(String code,String name,String category,String unit,BigDecimal safetyStock,BigDecimal currentStock){this.code=code;this.name=name;this.category=category;this.unit=unit;this.safetyStock=safetyStock;this.currentStock=currentStock;}
    public String getCode(){return code;} public String getName(){return name;} public String getCategory(){return category;} public String getUnit(){return unit;} public BigDecimal getSafetyStock(){return safetyStock;} public BigDecimal getCurrentStock(){return currentStock;} public void receive(BigDecimal qty){currentStock=currentStock.add(qty);}
}
