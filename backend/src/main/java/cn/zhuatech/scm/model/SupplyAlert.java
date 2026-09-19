/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.model;
import jakarta.persistence.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="scm_supply_alert") public class SupplyAlert extends BaseEntity {
    @Column(nullable=false,length=30) private String alertType;@Column(nullable=false,length=16) private String level;@Column(nullable=false,length=120) private String title;@Column(nullable=false,length=300) private String detail;@Column(nullable=false,length=20) private String status;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected SupplyAlert(){} /**
                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                               */
public SupplyAlert(String alertType,String level,String title,String detail,String status){this.alertType=alertType;this.level=level;this.title=title;this.detail=detail;this.status=status;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getAlertType(){return alertType;} /**
                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                     */
public String getLevel(){return level;} /**
                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                             */
public String getTitle(){return title;} /**
                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                     */
public String getDetail(){return detail;} /**
                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                               */
public String getStatus(){return status;} /**
                                                                                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                         */
public void close(){status="已关闭";}
}
