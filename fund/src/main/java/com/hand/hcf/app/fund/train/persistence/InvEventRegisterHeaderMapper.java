package com.hand.hcf.app.fund.train.persistence;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hand.hcf.app.fund.train.domain.InvEventRegisterHeader;
import org.springframework.stereotype.Repository;

/**
 * @author meng.li@hand-china.com
 * @description:
 * @version:1.0
 * @date 2019/8/22
 */

@Repository
public interface InvEventRegisterHeaderMapper extends BaseMapper<InvEventRegisterHeader> {

     InvEventRegisterHeader selectByInvNumber(String invNumber);
}
