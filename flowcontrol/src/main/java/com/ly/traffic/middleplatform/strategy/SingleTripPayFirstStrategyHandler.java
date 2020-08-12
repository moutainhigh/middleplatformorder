package com.ly.traffic.middleplatform.strategy;


import com.ly.traffic.middleplatform.event.EventType;
import com.ly.traffic.middleplatform.state.LockFailedStateHandler;
import com.ly.traffic.middleplatform.state.WaitingIssueTicketStateHandler;
import com.ly.traffic.middleplatform.state.WaitingLockSeatStateHandler;
import com.ly.traffic.middleplatform.state.WaitingPayStateHandler;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: 单一行程先支付再占座策略
 * @date 2020/7/22 14:47
 */
public class SingleTripPayFirstStrategyHandler extends AbstractStrategyHandler{


    private void init() {
        // 待出票处理
        WaitingIssueTicketStateHandler waitingIssueTicketStateHandler = new WaitingIssueTicketStateHandler();
        // 占座失败处理器
        LockFailedStateHandler lockFailedStateHandler = new LockFailedStateHandler();
        // 待支付处理器
        WaitingPayStateHandler waitingPayStateHandler = new WaitingPayStateHandler();
        // 待占座处理器
        WaitingLockSeatStateHandler waitingLockSeatStateHandler = new WaitingLockSeatStateHandler();

        // 支付成功事件 触发 转移到 待占座处理器
        waitingPayStateHandler.setNextHandler(EventType.PAID_SUCCESS, waitingLockSeatStateHandler);

        // 占座成功事件 触发 转移到 待出票处理器
        waitingLockSeatStateHandler.setNextHandler(EventType.LOCK_SUCCESS, waitingIssueTicketStateHandler);
        // 占座失败事件 触发 转移到 占座失败处理器
        waitingLockSeatStateHandler.setNextHandler(EventType.LOCK_FAILED, lockFailedStateHandler);

        super.registerHandler(1, waitingPayStateHandler);

        // 待占座， 占座中 可以使用同一个处理器
        super.registerHandler(20, waitingLockSeatStateHandler);
        super.registerHandler(21, waitingLockSeatStateHandler);
    }

    SingleTripPayFirstStrategyHandler () {
        init();
    }


}
