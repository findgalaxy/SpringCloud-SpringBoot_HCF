package com.hand.hcf.app.fund.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/4/28
 */
public class AmountUtil {

    public static String getAmountDesc(BigDecimal amount){
        String amountS =amount.toString();
        StringBuilder amountDesc=new StringBuilder();
        int k= StringUtils.indexOf(amountS,'.');
        if(k>0){
            String before=StringUtils.substring(amountS,0,k);
            String after=StringUtils.substring(amountS,k,amountS.length());
            int l=before.length();
            if(l%3!=0){
                amountDesc.append(StringUtils.substring(before,0,l%3)).append(',');
            }
            for(int index = l%3;index <l;index+=3){
                amountDesc.append(StringUtils.substring(before,index,index+3)).append(',');
            }

            amountDesc.deleteCharAt(amountDesc.length()-1).append(after);
        }
        else{
            int l=amountS.length();
            if(l%3!=0){
                amountDesc.append(StringUtils.substring(amountS,0,l%3)).append(',');
            }
            for(int index = l%3;index <l;index+=3){
                amountDesc.append(StringUtils.substring(amountS,index,index+3));
                amountDesc.append(',');
            }
            amountDesc.deleteCharAt(amountDesc.length()-1).append(".00");
        }
        return amountDesc.toString();
    }
}
