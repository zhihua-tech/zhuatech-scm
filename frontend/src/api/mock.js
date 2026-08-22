/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
export const stats=[['待平衡需求','12','未来 30 天 · 3 类物料','blue'],['在途采购','28','订单金额 ¥268.4万','green'],['交付风险','3','其中 1 项已逾期','red'],['库存健康度','91.6%','较上周提升 2.3%','amber']]
export const demands=[
 {no:'DP-20260730-036',material:'工业控制芯片 X48',code:'MAT-IC-1048',source:'销售预测 / 华东区域',qty:'18,000 片',stock:'8,600',gap:'-9,400',date:'08-07',status:'待转采购',risk:'高'},
 {no:'DP-20260730-041',material:'6061 铝型材 40×40',code:'MAT-AL-3026',source:'生产计划 / 控制柜产线',qty:'3,600 米',stock:'1,920',gap:'-1,680',date:'08-11',status:'已转采购',risk:'中'},
 {no:'DP-20260730-045',material:'伺服电机 750W',code:'MAT-MT-2071',source:'安全库存补货',qty:'220 台',stock:'486',gap:'+266',date:'08-15',status:'平衡完成',risk:'低'},
 {no:'DP-20260730-052',material:'工业连接器 M12',code:'MAT-CN-4082',source:'客户订单 / SO-16821',qty:'4,800 套',stock:'3,260',gap:'-1,540',date:'08-04',status:'待转采购',risk:'高'},
 {no:'DP-20260730-058',material:'低压断路器 32A',code:'MAT-EL-5019',source:'维修备件计划',qty:'680 只',stock:'920',gap:'+240',date:'08-20',status:'平衡完成',risk:'低'}]
export const orders=[
 {no:'PO-202607-0186',supplier:'苏州恒微电子科技有限公司',material:'工业控制芯片 X48',qty:'15,000 片',received:'0',amount:'¥192,000',expected:'08-04',days:'剩余 5 天',status:'待交付',progress:38,owner:'沈雨欣'},
 {no:'PO-202607-0179',supplier:'宁波东港精密制造有限公司',material:'伺服电机 750W',qty:'260 台',received:'180 台',amount:'¥178,100',expected:'08-01',days:'剩余 2 天',status:'部分到货',progress:69,owner:'赵明远'},
 {no:'PO-202607-0162',supplier:'无锡拓新自动化有限公司',material:'6061 铝型材 40×40',qty:'4,200 米',received:'2,400 米',amount:'¥78,120',expected:'07-29',days:'逾期 1 天',status:'交付延期',progress:57,owner:'沈雨欣'},
 {no:'PO-202607-0158',supplier:'昆山锐科传感技术有限公司',material:'工业连接器 M12',qty:'5,000 套',received:'5,000 套',amount:'¥96,500',expected:'07-28',days:'已完成',status:'已完成',progress:100,owner:'赵明远'}]
export const suppliers=[
 {code:'SUP-0018',name:'苏州恒微电子科技有限公司',category:'电子元器件',grade:'A',otd:'97.8%',quality:'99.32%',orders:12,amount:'¥86.4万',status:'合作中'},
 {code:'SUP-0026',name:'宁波东港精密制造有限公司',category:'机电组件',grade:'A',otd:'93.6%',quality:'98.71%',orders:8,amount:'¥64.8万',status:'合作中'},
 {code:'SUP-0041',name:'无锡拓新自动化有限公司',category:'结构材料',grade:'B',otd:'88.4%',quality:'97.90%',orders:6,amount:'¥39.2万',status:'观察中'},
 {code:'SUP-0057',name:'昆山锐科传感技术有限公司',category:'传感器与连接器',grade:'A',otd:'96.2%',quality:'99.08%',orders:9,amount:'¥47.6万',status:'合作中'}]
export const alerts=[
 {level:'紧急',type:'交付风险',title:'铝型材订单已逾期 1 天',detail:'PO-202607-0162 尚有 1,800 米未交付，影响 2 张生产工单。',owner:'沈雨欣',time:'10:26'},
 {level:'预警',type:'库存风险',title:'工业控制芯片低于安全库存',detail:'未来 14 天预计缺口 9,400 片，建议提前锁定第二供方。',owner:'计划组',time:'09:48'},
 {level:'提醒',type:'供应商绩效',title:'无锡拓新 OTD 连续下降',detail:'近 90 天准时交付率 88.4%，已触发供应商改善任务。',owner:'供应商管理',time:'08:35'}]
export const flow=[['销售预测','¥1,284万','+6.8%'],['需求计划','142 项','12 项待平衡'],['采购执行','28 单','3 单有风险'],['库存网络','¥862万','周转 36.2 天'],['订单履约','96.4%','OTIF +1.7%']]
