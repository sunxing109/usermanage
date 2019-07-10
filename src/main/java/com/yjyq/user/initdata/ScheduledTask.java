package com.yjyq.user.initdata;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/** 定时任务Scheduled实现
 * @author sunxingba
 * @version 1.0 $
 */
public class ScheduledTask {

    /**
     * @Scheduled 使用简单的定时任务
     */
//    @Scheduled(fixedRate = 2000)
//    public void fixedRate(){
//        System.out.println("fixedRate>>>"+ new Date());
//    }

//    @Scheduled(fixedDelay = 2000)
//    public void fixedDelay(){
//        System.out.println("fixedDelay>>>"+ new Date());
//    }

    /**
     *      ? 表示不指定值，即不关心某个字段的取值时使用。需要注意的是，月份中的日期和星期可能会起冲突，因此在配置时这两个得有一个是 ?
     *
     *      * 表示所有值，例如:在秒的字段上设置 *,表示每一秒都会触发
     *
     *      , 用来分开多个值，例如在周字段上设置 "MON,WED,FRI" 表示周一，周三和周五触发
     *
     *      - 表示区间，例如在秒上设置 "10-12",表示 10,11,12秒都会触发
     *
     *      / 用于递增触发，如在秒上面设置"5/15" 表示从5秒开始，每增15秒触发(5,20,35,50)
     *
     *      # 序号(表示每月的第几个周几)，例如在周字段上设置"6#3"表示在每月的第三个周六，(用 在母亲节和父亲节再合适不过了)
     * cron = [秒] [分] [小时] [日] [月] [周] [年]
     */
//    @Scheduled (cron = "0/15 * * * * *" )
//    public void cron () {
//        System.out.println("cron>>>" + new Date());
//    }
}
