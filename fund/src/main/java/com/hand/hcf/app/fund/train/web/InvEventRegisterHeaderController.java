package com.hand.hcf.app.fund.train.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.hand.hcf.app.fund.train.domain.InvEventRegisterHeader;
import com.hand.hcf.app.fund.train.dto.InvEventRegisterHeaderDTO;
import com.hand.hcf.app.fund.train.service.InvEventRegisterHeaderService;
import com.hand.hcf.core.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@Api(value="投资事件登记头控制器", tags={"头接口"})
@RestController
@RequestMapping("/api/invEvent/register/header")
public class InvEventRegisterHeaderController {

    @Autowired
    private InvEventRegisterHeaderService invEventRegisterHeaderService;

    /**
     * 分页查询条件说明
     * @param setOfBooksId
     * @param invNumber
     * @param invTypeId
     * @param invProductName
     * @param equityCompanyId
     * @param amountFrom
     * @param amountTo
     * @param billStatus
     * @param page
     * @param size
     * @return
     */

    @ApiOperation(value = "多条件分页查询头表" )
    @GetMapping("/pageByCondition")
    public ResponseEntity<List<InvEventRegisterHeaderDTO>> pageInvEventRegisterHeaderByCond(@RequestParam(required = false) Long setOfBooksId,
                                                                                         @RequestParam(required = false) String invNumber,
                                                                                         @RequestParam(required = false) Long invTypeId,
                                                                                         @RequestParam(required = false) String invProductName,
                                                                                         @RequestParam(required = false) Long equityCompanyId,
                                                                                         @RequestParam(required = false) BigDecimal amountFrom,
                                                                                         @RequestParam(required = false) BigDecimal amountTo,
                                                                                         @RequestParam(required = false) Integer billStatus,
                                                                                         @RequestParam(value = "page",defaultValue = "0") int page,
                                                                                         @RequestParam(value = "size",defaultValue = "4") int size) {

        Page mybatisPage = PageUtil.getPage(page, size);
        List<InvEventRegisterHeaderDTO> invEventRegisterHeaderDTOList = invEventRegisterHeaderService.pageInvEventRegisterHeaderByCond(setOfBooksId,invNumber,invTypeId,invProductName,equityCompanyId,amountFrom,amountTo,billStatus,mybatisPage);
        HttpHeaders httpHeaders = PageUtil.getTotalHeader(mybatisPage);
        return new ResponseEntity<>(invEventRegisterHeaderDTOList,httpHeaders, HttpStatus.OK);
    }


    /**
     * 添加投资事件登记头
     * @param setOfBooksId
     * @param invNumber
     * @param invTypeID
     * @param invProductName
     * @param equityCompanyId
     * @param equityUnitId
     * @param otherCompany
     * @param managementId
     * @param maintenanceDate
     * @param invNote
     * @param attachmentInfo
     * @return
     */

    @ApiOperation(value = "添加投资事件登记头")
    @PostMapping("/add")
    public String addInvEventRegisterHeader(@RequestParam Long setOfBooksId,
                                         @RequestParam String invNumber,
                                         @RequestParam Long invTypeID,
                                         @RequestParam String invProductName,
                                         @RequestParam Long equityCompanyId,
                                         @RequestParam Long equityUnitId,
                                         @RequestParam String otherCompany,
                                         @RequestParam Long managementId,
                                         @RequestParam(required = false) Date maintenanceDate,
                                         @RequestParam(required = false) String invNote,
                                         @RequestParam(required = false) String attachmentInfo) {

         return invEventRegisterHeaderService.addInvEventRegisterHeader(setOfBooksId,invNumber,invTypeID,
                 invProductName,equityCompanyId,equityUnitId,otherCompany,managementId,maintenanceDate,invNote,attachmentInfo);
    }


    /**
     * 更新投资事件登记头
     * @param invEventRegisterHeader
     * @return
     */

    @ApiOperation(value = "更新投资事件登记头")
    @PutMapping("/update")
    public boolean updateInvEventRegisterHeader(@RequestBody InvEventRegisterHeader invEventRegisterHeader) {

        return invEventRegisterHeaderService.updateInvEventRegisterHeader(invEventRegisterHeader);
    }


    /**
     * 根据头ID来删除投资事件登记头和所有的投资事件登记行
     * @param headerId
     * @return
     */
    @ApiOperation(value = "根据头ID来删除投资事件登记头和所有的投资事件登记行")
    @DeleteMapping("/delete")
    public int deleteHeaderAndLine(@RequestParam Long headerId) {
        return invEventRegisterHeaderService.deleteHeaderAndLine(headerId);
    }





}
