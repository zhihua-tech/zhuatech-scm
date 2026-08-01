# API 摘要

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 用户登录并签发 JWT |
| GET | `/api/scm/dashboard` | 供应链驾驶舱指标 |
| GET/POST | `/api/scm/demands` | 查询或新建需求计划 |
| GET/POST | `/api/scm/orders` | 查询或新建采购订单 |
| POST | `/api/scm/orders/{id}/approve` | 审核采购订单 |
| POST | `/api/scm/orders/{id}/receive` | 登记采购到货 |
| GET | `/api/scm/suppliers` | 供应商及绩效列表 |
| GET | `/api/scm/materials` | 物料库存列表 |
| GET | `/api/scm/alerts` | 供应链风险列表 |
| POST | `/api/scm/alerts/{id}/close` | 关闭风险预警 |

除登录接口外均需 `Authorization: Bearer <token>`。演示接口仅用于个人非商业学习。

## 库存覆盖

`POST /api/scm/inventory-coverage`：计算库存覆盖天数、订货点、补货缺口和风险状态。
