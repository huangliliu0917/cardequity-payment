package com.youyu.cardequity.payment.biz.config;

import com.youyu.cardequity.payment.biz.component.properties.RabbitmqProperties;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月21日 下午15:54:27
 * @work Rabbitmq Exchange Config 交换机配置
 */
@Configuration
public class RabbitmqExchangeConfig {

    @Autowired
    private RabbitmqProperties rabbitmqProperties;

    /**
     * 支付异步通知消息:Exchange
     *
     * @return
     */
    @Bean("payAsyncMessageExchange")
    public DirectExchange payAsyncMessageExchange() {
        return new DirectExchange(rabbitmqProperties.getPayAsyncMessageExchange(), true, false);
    }

    /**
     * 支付盘后对账退款消息通知:Exchange
     *
     * @return
     */
    @Bean("payAfterRefundMessageExchange")
    public DirectExchange payAfterRefundMessageExchange() {
        return new DirectExchange(rabbitmqProperties.getPayAfterRefundMessageExchange(), true, false);
    }

    /**
     * 支付盘后对账退款状态消息通知:Exchange
     *
     * @return
     */
    @Bean("payAfterRefundStatusMessageExchange")
    public DirectExchange payAfterRefundStatusMessageExchange() {
        return new DirectExchange(rabbitmqProperties.getPayAfterRefundStatusMessageExchange(), true, false);
    }

    /**
     * 支付宝盘后对账支付失败状态且非日切的消息通知:Exchange
     *
     * @return
     */
    @Bean("payAfterPayFailNotDayCutMessageExchange")
    public DirectExchange payAfterPayFailNotDayCutMessageExchange() {
        return new DirectExchange(rabbitmqProperties.getPayAfterPayFailNotDayCutMessageExchange(), true, false);
    }

    /**
     * 支付宝盘后对账退款失败状态且非日切的消息通知:Exchange
     *
     * @return
     */
    @Bean("payAfterReturnFailNotDayCutMessageExchange")
    public DirectExchange payAfterReturnFailNotDayCutMessageExchange() {
        return new DirectExchange(rabbitmqProperties.getPayAfterReturnFailNotDayCutMessageExchange(), true, false);
    }
}