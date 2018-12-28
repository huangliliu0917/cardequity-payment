package com.youyu.cardequity.payment.api;

import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月12日 下午10:00:00
 * @work 对账信息管理Api定义
 */
@Api(tags = "对账信息管理Api")
@FeignClient(name = "cardequity-payment")
@RequestMapping(path = "/payCheckDeatail")
public interface PayCheckDeatailApi {


}
