/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.scm.repository;import cn.zhuatech.scm.model.DemandPlan;import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;/**
                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                               */
public interface DemandPlanRepository extends JpaRepository<DemandPlan,Long>{/**
                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                            */
List<DemandPlan> findAllByOrderByRequiredDateAsc();/**
                                                                                                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                               */
long countByStatus(String status);}
