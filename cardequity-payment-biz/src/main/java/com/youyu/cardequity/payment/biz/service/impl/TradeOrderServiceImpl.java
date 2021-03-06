package com.youyu.cardequity.payment.biz.service.impl;

import com.youyu.cardequity.common.spring.service.BatchService;
import com.youyu.cardequity.common.spring.service.RabbitConsumerService;
import com.youyu.cardequity.payment.biz.dal.dao.TradeOrderMapper;
import com.youyu.cardequity.payment.biz.dal.entity.TradeOrder;
import com.youyu.cardequity.payment.dto.TradeOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.JSON.parseArray;

/**
 * @author panqingqing
 * @version v1.0
 * @date 2018年12月6日 下午10:00:00
 * @work 交易订单退款信息Service Impl
 */
@Service("tradeOrderService")
public class TradeOrderServiceImpl implements RabbitConsumerService {

    @Autowired
    private BatchService batchService;

    @Override
    @Transactional
    public void consumerMessage(String jsonMessage, String queueFlag) {
        List<TradeOrderDto> tradeOrderDtos = parseArray(jsonMessage, TradeOrderDto.class);
        List<TradeOrder> tradeOrders = new ArrayList<>();
        for (TradeOrderDto tradeOrderDto : tradeOrderDtos) {
            tradeOrders.add(new TradeOrder(tradeOrderDto));
        }

        batchService.batchDispose(tradeOrders, TradeOrderMapper.class, "insertSelective");
    }
}
