package com.hand.hcf.app.fund.train.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.hand.hcf.app.fund.train.domain.InvTypeMaintain;
import com.hand.hcf.app.fund.train.service.InvTypeMaintainService;
import com.hand.hcf.core.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */


@Api(value="投资类型控制器", tags={"投资类型接口"})
@RestController
@RequestMapping("/api/invType/maintain")
public class InvTypeMaintainController {

    @Autowired
    private InvTypeMaintainService invTypeMaintainService;

    /**
     * 多条件查询投资类型维护信息
     * @return
     */

    @ApiOperation(value = "多条件查询" ,  notes="多条件查询")
    @GetMapping("/pageByCondition")
    public ResponseEntity<List<InvTypeMaintain>> pageInvTypeMaintainByCond(@RequestParam(required = false) Long setOfBooksId,
                                                                           @RequestParam(required = false) String invTypeCode,
                                                                           @RequestParam(required = false) String invTypeName,
                                                                           @RequestParam(required = false) Integer startStatus,
                                                                           @RequestParam(value = "page",defaultValue = "0") int page,
                                                                           @RequestParam(value = "size",defaultValue = "4") int size) {
        Page mybatisPage = PageUtil.getPage(page, size);
        List<InvTypeMaintain> list = invTypeMaintainService.pageInvTypeMaintainByCond(setOfBooksId,invTypeCode,invTypeName,startStatus,mybatisPage);
        HttpHeaders httpHeaders = PageUtil.getTotalHeader(mybatisPage);
        return new ResponseEntity<>(list,httpHeaders, HttpStatus.OK);
    }

    /**
     * 更新投资类型维护信息
     * @param invTypeMaintain
     * @return
     */
    @ApiOperation(value = "更新投资类型维护信息" ,  notes="更新投资类型维护信息")
    @PutMapping("/update")
    public boolean updateInvTypeMaintainById(@RequestBody InvTypeMaintain invTypeMaintain ) {

        return invTypeMaintainService.updateInvTypeMaintainById(invTypeMaintain);

    }


    /**
     * 添加投资类型维护信息
     * @param invTypeMaintain
     * @return
     */
    @ApiOperation(value = "添加投资类型维护信息" ,  notes="添加投资类型维护信息")
    @PostMapping("/add")
    public int addInvTypeMaintain(@RequestBody InvTypeMaintain invTypeMaintain) {

        return  invTypeMaintainService.addInvTypeMaintain(invTypeMaintain);

    }

}
