package com.hand.hcf.app.fund.utils;

public interface RespCode {
    String SYS_ID_NOT_NULL = "SYS_ID_NOT_NULL"; // id应该为空!
    String SYS_ID_NULL = "SYS_ID_NULL"; //id不应该为空!
    String ACCOUNT_DELETE_ERROR = "ACCOUNT_DELETE_ERROR"; //完成审批或正在审批的单据不允许删除!
    String ACCOUNT_UPDATE_ERROR = "ACCOUNT_UPDATE_ERROR"; //完成审批或正在审批的单据不允许修改!
    String ACCOUNT_INFO_NOT_EXISTS = "ACCOUNT_INFO_NOT_EXISTS"; //该单据不存在！
    String ACCOUNT_CODE_REPEAT = "ACCOUNT_CODE_REPEAT"; //代码重复！
    String ACCOUNT_SUBMIT_ERROR = "ACCOUNT_SUBMIT_ERROR"; //审批中或已审批的单据不允许重复提交！
    String ACCOUNT_NUMBER_REPEAT = "ACCOUNT_NUMBER_REPEAT"; //该银行账号已存在！
    String ACCOUNT_BASE_ONLY = "ACCOUNT_BASE_ONLY"; //该公司基本户已存在！
    String ACCOUNT_OPEN_SUBMIT_ERROR = "ACCOUNT_OPEN_SUBMIT_ERROR"; //工作流提交出错
    String ACCOUNT_RIGHT_LINE_NOT_FOUND = "ACCOUNT_RIGHT_LINE_NOT_FOUND"; //账户权限分配行未找到
    String ACCOUNT_RIGHT_BASE_NOT_FOUND = "ACCOUNT_RIGHT_BASE_NOT_FOUND"; //账户权限基础表未找到
    String ACCOUNT_RIGHT_BASE_ID_NULL = "ACCOUNT_RIGHT_BASE_ID_NULL"; //账户权限基础表id不应该为空
    String ACCOUNT_RIGHT_LINE_AC_REPEAT = "ACCOUNT_RIGHT_LINE_AC_REPEAT"; //账户权限分配表账号分配重复
    String ACCOUNT_RIGHT_BASE_USER_REPEAT = "ACCOUNT_RIGHT_BASE_USER_REPEAT"; //账户权限基础表员工重复
    String ACCOUNT_CHANGE_REPEAT = "ACCOUNT_CHANGE_REPEAT"; //当前变更账户已有申请在审批中，请结束后提交！
    String PAYMENT_BASEINFO_NOT_FOUND = "PAYMENT_BASEINFO_NOT_FOUND";//手工单头表未找到
    String PAYMENT_LINE_TRADECODE_NULL = "PAYMENT_LINE_TRADECODE_NULL";//行号为空
    String PAYMENT_LINE_NOT_FOUND = "PAYMENT_LINE_NOT_FOUND";//手工单创建行未找到
    String PAYMENT_HEAD_MANUAL_PAYMENT_LINECOUNT = "PAYMENT_HEAD_MANUAL_PAYMENT_LINECOUNT";//手工付款单最多不能超过100行
    String PAYMENT_RULE_REPEAT = "PAYMENT_RULE_REPEAT";//序号重复！
    String PAYMENT_INTERFACE_NOT_EXISTS = "PAYMENT_INTERFACE_NOT_EXISTS"; //付款单据信息不存在！
    String PAYMENT_INTERFACE_DOCUMENT_LOCKED = "PAYMENT_INTERFACE_DOCUMENT_LOCKED"; //当前单据已经处于被锁定状态，请勿重复锁定！
    String PAYMENT_INTERFACE_DOCUMENT_UNLOCKED = "PAYMENT_INTERFACE_DOCUMENT_UNLOCKED"; //当前单据已经处于未锁定状态，请勿重复解锁！
    String PAYMENT_INTERFACE_PAYMENT_FAILED = "PAYMENT_INTERFACE_PAYMENT_FAILED";//当前单据已经被退回，请勿重复操作！
    String PAYMENT_RULE_COMPANY_REPEAT = "PAYMENT_RULE_COMPANY_REPEAT";//该公司已被分配！
    String PAYMENT_RULE_EMP_LEVEL_REPEAT = "PAYMENT_RULE_EMP_LEVEL_REPEAT";//该员工级别已被分配！
    String PAYMENT_BASE_ID_NULL = "PAYMENT_BASE_ID_NULL";//头id未找到
    String PAYMENT_PURPOSE = "PAYMENT_PURPOSE";//付款用途未找到
    String PAYMENT_TENANT_ID_NULL = "PAYMENT_TENANT_ID_NULL";//租户id未找到
    String PAYMENT_PROP_FLAG_NULL = "PAYMENT_PROP_FLAG_NULL";//公私标志未找到
    String PAYMENT_CARD_SIGN_NULL = "PAYMENT_CARD_SIGN_NULL";//卡折标志未找到
    String PAYMENT_PAYMENT_METHOD_NULL = "PAYMENT_PAYMENT_METHOD_NULL";//付款方式未找到
    String PAYMENT_PAYMENT_STATUS_NULL = "PAYMENT_PAYMENT_STATUS_NULL";//付款状态未找到
    String PAYMENT_SOURCE_SYSTEM_NULL = "PAYMENT_SOURCE_SYSTEM_NULL";//来源系统未找到
    String PAYMENT_WARNING_STATUS_NULL = "PAYMENT_WARNING_STATUS_NULL";//预警状态未找到
    String SET_OF_BOOKS_PAYMENT_SECURITY_STRATEGY_NOT_ONE = "SET_OF_BOOKS_PAYMENT_SECURITY_STRATEGY_NOT_ONE";//账套下支付安全策略不唯一
    String PAYMENT_TOO_MANY_ROW = "PAYMENT_TOO_MANY_ROW";//不能超过1000条
    String TENANT_ID_PAYMENT_SECURITY_STRATEGY_NOT_ONE = "TENANT_ID_PAYMENT_SECURITY_STRATEGY_NOT_ONE";//租户下支付安全策略不唯一
    String PAYMENT_SUBMIT_ERROR = "PAYMENT_SUBMIT_ERROR"; //审批中或已审批的单据不允许重复提交！
    String PAYMENT_INFO_NOT_EXISTS = "PAYMENT_INFO_NOT_EXISTS"; //该申请单不存在！
    String PAYMENT_INTERFACE_CONTAIN_LOCK = "PAYMENT_INTERFACE_CONTAIN_LOCK";//选中行包含锁定单据！
    String IS_REVIEW_STATUS = "IS_REVIEW_STATUS";//所选单据包含已复核单据
    String IS_NOT_REVIEW_STATUS = "IS_NOT_REVIEW_STATUS";//所选单据包含未复核单据
    String HISTORY_NOT_REVIEW = "HISTORY_NOT_REVIEW"; //请先复核上月余额调节表！
    String HAVE_NEW_HISTORY = "HAVE_NEW_HISTORY"; //已生成新的期初余额，历史余额不可取消复核！
    String AUTO_GATHER_DATE_INVALID = "AUTO_GATHER_DATE_INVALID";//自动归集日期格式无效！
    String AUTO_GATHER_WEEK_INVALID = "AUTO_GATHER_WEEK_INVALID";//自动归集周格式无效！
    String AUTO_GATHER_TIME_INVALID = "AUTO_GATHER_TIME_INVALID";//自动归集时间格式无效！
    String DEBIT_CREDIT_AMOUNT_DIFFERENCE = "DEBIT_CREDIT_AMOUNT_DIFFERENCE"; //借贷金额不同！
    String BEGIN_BALANCE_NO_REVIEW = "BEGIN_BALANCE_NO_REVIEW"; //本月期初余额未复核！
    String NOT_HAVE_BEGIN_BALANCE = "NOT_HAVE_BEGIN_BALANCE"; //未维护期初余额！
    String FUND_BALANCE_FAIL = "FUND_BALANCE_FAIL"; //对账失败,请刷新
    String BEGIN_BALANCE_IS_EXIST = "BEGIN_BALANCE_IS_EXIST"; //当月余额表已复核，请先取消复核后再试！
    String ADJUST_AMOUNT_DIFFERENCE = "ADJUST_AMOUNT_DIFFERENCE"; //调整后余额需相同！
    String BANK_PARAS_NOT_FOUND = "BANK_PARAS_NOT_FOUND"; //该银行未开通银企直连或银企直连参数未维护！
    String AUTO_GATHER_ACCOUNT_EXISTS = "AUTO_GATHER_ACCOUNT_EXISTS"; //该母账号已存在！
    String BALANCE_MAINTAIN_HAVE_DISPLAY = "BALANCE_MAINTAIN_HAVE_DISPLAY";//已有可显示期初余额维护！
    String BALANCE_MAINTAIN_CANNOT_MODIFY = "BALANCE_MAINTAIN_CANNOT_MODIFY";//以复核不可修改！
    String AUTO_GATHER_RATE_INVALID = "AUTO_GATHER_RATE_INVALID";//归集比例格式无效，比例需介于0~100！
    String REGION_CODE_REPEAT = "REGION_CODE_REPEAT";//区域代码重复！
    String AUTO_GATHER_LINE_ACCOUNT_EXISTS = "AUTO_GATHER_LINE_ACCOUNT_EXISTS";//被归集子账号已存在！
    String ADJUST_LINE_NOT_FOUND = "ADJUST_LINE_NOT_FOUND"; //调拨单行未找到！
    String ADJUST_BASE_NOT_FOUND = "ADJUST_BASE_NOT_FOUND"; //调拨单头未找到！
    String BALANCE_DATE_NOT_DELETE = "BALANCE_DATE_NOT_DELETE"; //已对账数据不能删除！
    String PAYMENT_RULE_BUS_TYPE_REPEAT = "PAYMENT_RULE_BUS_TYPE_REPEAT"; //业务类型重复分配！
    String FUND_REQUISITION_TYPE_EXISTS = "FUND_REQUISITION_TYPE_EXISTS"; //同一账套下，同一资金单据类型代码不运行重复！
    String SYS_DATA_NOT_EXISTS = "SYS_DATA_NOT_EXISTS";//数据不存在
    String READ_FILE_FAILED = "READ_FILE_FAILED";    //读取文件失败
    String ERROR_STATUS_QUERY_RESULT = "ERROR_STATUS_QUERY_RESULT";    //已发送状态才能查询支付结果
    String INTEREST_RULE_TYPE_FORMAT_ERROR = "INTEREST_RULE_TYPE_FORMAT_ERROR"; //计息规则格式不正确，只允许纯数字！
    String RULE_NO_FOUND = "RULE_NO_FOUND";//当前无可用规则，请维护！
    String PAYMENT_HAVING_PAID = "PAYMENT_HAVING_PAID"; //该付款单已支付
    String SUBMIT_USER_NO_FOUND = "SUBMIT_USER_NO_FOUND"; //提交制单人未找到
    String SUBMIT_FORM_NO_FOUND = "SUBMIT_FORM_NO_FOUND"; //审批流表单未找到
    String PAYMENT_INTERFACE_METHOD_ERROR = "PAYMENT_INTERFACE_METHOD_ERROR"; //该单据不是银企直联支付方式
    String BANK_FLOW_HAD_GENERATE = "BANK_FLOW_HAD_GENERATE"; //该流水已生成过单据
    String GENERATE_DATE_NOT_DELETE = "GENERATE_DATE_NOT_DELETE"; //已生成单据的流水不允许删除
    String NOT_SYSTEM_ACCOUNT_NUMBER = "NOT_SYSTEM_ACCOUNT_NUMBER"; //对方账户非系统内账户
    String BANK_FLOW_SN_REPECT = "BANK_FLOW_SN_REPECT"; //流水号重复
    String GET_ORACLE_BALANCE_ERROR = "GET_ORACLE_BALANCE_ERROR"; //未获取到总账余额

}
