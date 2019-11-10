package com.hand.hcf.app.fund.train.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hand.hcf.app.fund.train.domain.InvTypeMaintain;
import com.hand.hcf.app.fund.train.persistence.InvTypeMaintainMapper;
import com.hand.hcf.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@Service
public class InvTypeMaintainService extends BaseService<InvTypeMaintainMapper, InvTypeMaintain> {

    @Autowired
    private InvTypeMaintainMapper invTypeMaintainMapper;


    /**
     * 多条件分页查询投资类型维护表
     * @param setOfBooksId
     * @param invTypeCode
     * @param invTypeName
     * @param startStatus
     * @param mybatisPage
     * @return
     */
    public List<InvTypeMaintain> pageInvTypeMaintainByCond(Long setOfBooksId, String invTypeCode, String invTypeName, Integer startStatus, Page mybatisPage) {
        List<InvTypeMaintain> invTypeMaintainList = baseMapper.selectPage(mybatisPage,new EntityWrapper<InvTypeMaintain>()
                .like(invTypeCode != null,"inv_type_code",invTypeCode)
                .eq(setOfBooksId != null,"set_of_books_id",setOfBooksId)
                .like(invTypeName != null,"inv_type_name",invTypeName)
                .eq(startStatus != null,"start_status",startStatus));

        return invTypeMaintainList;
    }


    /**
     * 添加投资类型维护信息
     * @param invTypeMaintain
     * @return
     */
    public int addInvTypeMaintain(InvTypeMaintain invTypeMaintain) {
        return baseMapper.insert(invTypeMaintain);
    }


    /**
     * 通过id来更新投资类型维护信息
     * @param invTypeMaintain
     * @return
     */
    public boolean updateInvTypeMaintainById(InvTypeMaintain invTypeMaintain) {

        if(invTypeMaintain == null) {
            return false;
        } else {
            if(invTypeMaintain.getId() != null) {
                return baseMapper.updateById(invTypeMaintain)>0;
            } else {
                return false;
            }
        }

    }


    /**
     * 通过InvTypeName来查询InvTypeId
     * @param name
     * @return
     */
    public Long selectInvTypeIdByInvTypeName(String name) {
        return invTypeMaintainMapper.selectInvTypeIdByInvTypeName(name);
    }


    /**
     * 通过ID来查询InvTypeMaintain
     * @param id
     * @return
     */
    public InvTypeMaintain selectById(Long id) {
        return baseMapper.selectById(id);
    }
}
