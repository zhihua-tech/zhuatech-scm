# 数据库设计

- `sys_user`：供应链管理员、计划专员和采购专员账号。
- `scm_supplier`：供应商档案、等级、交付率、质量率与合作状态。
- `scm_material`：物料编码、类别、单位、安全库存与当前库存。
- `scm_demand_plan`：需求来源、需求数量、需求日期和计划状态。
- `scm_purchase_order`：采购供应商、物料、数量、价格、交期与到货进度。
- `scm_supply_alert`：库存、交付与供应商绩效风险。

初始化脚本位于 `backend/src/main/resources/db/migration/V1__init.sql`，表名、索引及外键均通过 Flyway 管理。
