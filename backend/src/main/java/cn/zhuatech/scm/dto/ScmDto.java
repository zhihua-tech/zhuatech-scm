/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.dto;
import cn.zhuatech.scm.model.*;import jakarta.validation.constraints.*;import java.math.BigDecimal;import java.time.LocalDate;import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public final class ScmDto {/**
                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                            */
private ScmDto(){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Dashboard(long activeDemands,long openOrders,long delayedOrders,long openAlerts,BigDecimal purchaseAmount,long lowStockMaterials,List<OrderView> focusOrders){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record SupplierView(Long id,String code,String name,String grade,BigDecimal onTimeRate,BigDecimal qualityRate,String status){/**
                                                                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                      */
public static SupplierView from(Supplier x){return new SupplierView(x.getId(),x.getCode(),x.getName(),x.getGrade(),x.getOnTimeRate(),x.getQualityRate(),x.getStatus());}}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record MaterialView(Long id,String code,String name,String category,String unit,BigDecimal safetyStock,BigDecimal currentStock,boolean lowStock){/**
                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                          */
public static MaterialView from(Material x){return new MaterialView(x.getId(),x.getCode(),x.getName(),x.getCategory(),x.getUnit(),x.getSafetyStock(),x.getCurrentStock(),x.getCurrentStock().compareTo(x.getSafetyStock())<0);}}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record DemandView(Long id,String planNo,MaterialView material,BigDecimal requiredQty,LocalDate requiredDate,String status,String source){/**
                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                  */
public static DemandView from(DemandPlan x){return new DemandView(x.getId(),x.getPlanNo(),MaterialView.from(x.getMaterial()),x.getRequiredQty(),x.getRequiredDate(),x.getStatus(),x.getSource());}}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record OrderView(Long id,String orderNo,SupplierView supplier,MaterialView material,BigDecimal quantity,BigDecimal unitPrice,BigDecimal amount,LocalDate expectedDate,String status,BigDecimal receivedQty){/**
                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                     */
public static OrderView from(PurchaseOrder x){return new OrderView(x.getId(),x.getOrderNo(),SupplierView.from(x.getSupplier()),MaterialView.from(x.getMaterial()),x.getQuantity(),x.getUnitPrice(),x.getAmount(),x.getExpectedDate(),x.getStatus(),x.getReceivedQty());}}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record AlertView(Long id,String alertType,String level,String title,String detail,String status){/**
                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                          */
public static AlertView from(SupplyAlert x){return new AlertView(x.getId(),x.getAlertType(),x.getLevel(),x.getTitle(),x.getDetail(),x.getStatus());}}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record CreateDemandRequest(@NotNull Long materialId,@Positive BigDecimal requiredQty,@NotNull LocalDate requiredDate,@NotBlank String source){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record CreateOrderRequest(@NotNull Long supplierId,@NotNull Long materialId,@Positive BigDecimal quantity,@Positive BigDecimal unitPrice,@NotNull LocalDate expectedDate){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record ReceiveRequest(@Positive BigDecimal quantity){}
}
