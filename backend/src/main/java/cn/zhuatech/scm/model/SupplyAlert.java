/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.model;
import jakarta.persistence.*;
@Entity @Table(name="scm_supply_alert") public class SupplyAlert extends BaseEntity {
    @Column(nullable=false,length=30) private String alertType;@Column(nullable=false,length=16) private String level;@Column(nullable=false,length=120) private String title;@Column(nullable=false,length=300) private String detail;@Column(nullable=false,length=20) private String status;
    protected SupplyAlert(){} public SupplyAlert(String alertType,String level,String title,String detail,String status){this.alertType=alertType;this.level=level;this.title=title;this.detail=detail;this.status=status;}
    public String getAlertType(){return alertType;} public String getLevel(){return level;} public String getTitle(){return title;} public String getDetail(){return detail;} public String getStatus(){return status;} public void close(){status="已关闭";}
}
