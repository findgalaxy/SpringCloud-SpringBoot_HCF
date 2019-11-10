package com.hand.hcf.app.fund.dto;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/4/25
 */
@Data
public class ReturnTempErrorDTO {

    private List<ErrorData> errorData;

    private Integer failureEntities;

    private Integer successEntities;
}
