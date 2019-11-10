package com.hand.hcf.app.fund.train.web;

import com.hand.hcf.app.fund.train.domain.InvEventRegisterLine;
import com.hand.hcf.app.fund.train.service.InvEventRegisterLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */


@Api(value="投资事件登记行明细控制器", tags={"行接口"})
@RestController
@RequestMapping("/api/invEvent/register/line")
public class InvEventRegisterLineController {

    @Autowired
    private InvEventRegisterLineService invEventRegisterLineService;


    /**
     * 根据投资事件登记头表ID查询出对应的投资事件登记行
     * @param id
     * @return
     */

    @ApiOperation(value = "根据投资事件登记头表ID查询出对应的投资事件登记行")
    @GetMapping("/{id}")
    public ResponseEntity<InvEventRegisterLine> selectByInvEventHeaderId(@PathVariable(value = "id") Long id) {
        InvEventRegisterLine invEventRegisterLine = invEventRegisterLineService.selectByInvEventHeaderId(id);
        return new ResponseEntity<>(invEventRegisterLine, HttpStatus.OK);
    }


    /**
     * 更新投资事件登记行
     * @param invEventRegisterLine
     * @return
     */

    @ApiOperation(value = "更新投资事件登记行" ,  notes="更新投资事件登记行")
    @PutMapping("/update")
    public boolean updateByInvEventHeaderId(@RequestBody InvEventRegisterLine invEventRegisterLine ) {
        return invEventRegisterLineService.updateByInvEventHeaderId(invEventRegisterLine);
    }


    /**
     * 添加投资事件登记行
     * @param invEventRegisterLine
     * @return
     */

    @ApiOperation(value = "添加投资事件登记行" ,  notes="添加投资事件登记行")
    @PostMapping("/add")
    public int addInvEventRegisterLine(@RequestBody InvEventRegisterLine invEventRegisterLine) {

        return invEventRegisterLineService.addInvEventRegisterLine(invEventRegisterLine);
    }


    /**
     * 根据行ID删除投资事件登记行
     * @param id
     * @return
     */

    @ApiOperation(value = "根据行ID删除投资事件登记行" ,  notes="根据行ID删除投资事件登记行")
    @DeleteMapping("/delete")
    public int deleteInvEventRegisterLine(@RequestParam Long id) {
        return invEventRegisterLineService.deleteInvEventRegisterLine(id);
    }



}
