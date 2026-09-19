/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.model;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.LocalDate;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="scm_purchase_order") public class PurchaseOrder extends BaseEntity {
    @Column(nullable=false,unique=true,length=32) private String orderNo;@ManyToOne(fetch=FetchType.LAZY,optional=false) private Supplier supplier;@ManyToOne(fetch=FetchType.LAZY,optional=false) private Material material;@Column(nullable=false,precision=14,scale=2) private BigDecimal quantity;@Column(nullable=false,precision=14,scale=2) private BigDecimal unitPrice;@Column(nullable=false) private LocalDate expectedDate;@Column(nullable=false,length=24) private String status;@Column(nullable=false,precision=14,scale=2) private BigDecimal receivedQty=BigDecimal.ZERO;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected PurchaseOrder(){} /**
                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                 */
public PurchaseOrder(String orderNo,Supplier supplier,Material material,BigDecimal quantity,BigDecimal unitPrice,LocalDate expectedDate,String status){this.orderNo=orderNo;this.supplier=supplier;this.material=material;this.quantity=quantity;this.unitPrice=unitPrice;this.expectedDate=expectedDate;this.status=status;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getOrderNo(){return orderNo;} /**
                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                 */
public Supplier getSupplier(){return supplier;} /**
                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                 */
public Material getMaterial(){return material;} /**
                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                 */
public BigDecimal getQuantity(){return quantity;} /**
                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                   */
public BigDecimal getUnitPrice(){return unitPrice;} /**
                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                       */
public LocalDate getExpectedDate(){return expectedDate;} /**
                                                                                                                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                */
public String getStatus(){return status;} /**
                                                                                                                                                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                          */
public BigDecimal getReceivedQty(){return receivedQty;} /**
                                                                                                                                                                                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                                                                  */
public BigDecimal getAmount(){return quantity.multiply(unitPrice);}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public void approve(){if("草稿".equals(status))status="待交付";} /**
                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                 */
public void receive(BigDecimal qty){receivedQty=receivedQty.add(qty);material.receive(qty);status=receivedQty.compareTo(quantity)>=0?"已完成":"部分到货";}
}
