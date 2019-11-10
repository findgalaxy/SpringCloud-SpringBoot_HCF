package com.hand.hcf.app.fund.train.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hand.hcf.app.fund.train.domain.InvEventRegisterLine;
import org.springframework.stereotype.Repository;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@Repository
public interface InvEventRegisterLineMapper  extends BaseMapper<InvEventRegisterLine> {

    InvEventRegisterLine selectByInvEventHeaderId(Long id);

    int deleteAllLinesByHeaderId(Long headerId);

}
