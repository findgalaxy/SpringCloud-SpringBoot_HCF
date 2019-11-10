package com.hand.hcf.app.fund.implement.web;

import com.hand.hcf.app.fund.client.FundInterface;
import com.hand.hcf.app.fund.client.dto.FundPaymentInInterfaceCO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 刘亮 on 2017/11/6.
 */
@RestController
//@PreAuthorize("hasRole('" + AuthoritiesConstants.INTEGRATION_CLIENTS + "')")
public class ImplementController implements FundInterface {
//    @Autowired
//    private PaymentInInterfaceService paymentInInterfaceService;

    @Override
    public boolean saveInterfaceData(@RequestBody List<FundPaymentInInterfaceCO> paymentInInterface) {
        return false;
    }
}
