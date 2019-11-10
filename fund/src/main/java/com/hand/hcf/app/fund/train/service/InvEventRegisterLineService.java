package com.hand.hcf.app.fund.train.service;

import com.hand.hcf.app.fund.train.domain.InvEventRegisterLine;
import com.hand.hcf.app.fund.train.persistence.InvEventRegisterLineMapper;
import com.hand.hcf.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@Service
public class InvEventRegisterLineService extends BaseService<InvEventRegisterLineMapper, InvEventRegisterLine> {

    @Autowired
    private InvEventRegisterLineMapper invEventRegisterLineMapper;

    /**
     * 根据投资事件登记头表ID查询出对应的投资事件登记行
     * @param id
     * @return
     */
    public InvEventRegisterLine selectByInvEventHeaderId(Long id) {
       return invEventRegisterLineMapper.selectByInvEventHeaderId(id);
    }


    /**
     * 更新投资事件登记行
     * @param invEventRegisterLine
     * @return
     */
    public boolean updateByInvEventHeaderId(InvEventRegisterLine invEventRegisterLine) {

        if(invEventRegisterLine == null) {
            return false;
        } else {
            return baseMapper.updateById(invEventRegisterLine) > 0;
        }
    }


    /**
     * 添加投资事件登记行
     * @param invEventRegisterLine
     * @return
     */
    public int addInvEventRegisterLine(InvEventRegisterLine invEventRegisterLine) {

        return baseMapper.insert(invEventRegisterLine);

    }


    /**
     * 根据行ID删除投资事件登记行
     * @param id
     * @return
     */
    public int deleteInvEventRegisterLine(Long id) {
        InvEventRegisterLine invEventRegisterLine = baseMapper.selectById(id);
        if(invEventRegisterLine != null) {
           return baseMapper.deleteById(id);
        } else {
            return 0;
        }
    }

    /**
     * 根据头ID来删除所有的投资事件登记行
     * @param headerId
     */
    public void deleteAllLinesByHeaderId(Long headerId) {
        invEventRegisterLineMapper.deleteAllLinesByHeaderId(headerId);
    }
}
