package com.yjyq.user.initdata;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 任务启动方式：InitializingBean, 这种方式比其他两种优先级更高
 * @author sunxingba
 * @version 1.0 $
 */
@Component
public class RunTaskInitializingBeanTest implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("任务启动方式：InitializingBean");
    }
}
