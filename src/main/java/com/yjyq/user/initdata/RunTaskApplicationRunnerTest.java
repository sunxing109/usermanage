package com.yjyq.user.initdata;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


/** 任务启动方式：ApplicationRunner
 *  Servlet/Jsp 项目使用的是LiServletContextListener
 *  传参方式 java -jar usermanage.jar 三国演义 江南风光 --age=25
 * @author sunxingba
 * @version 1.0 $
 */
//@Component
//@Order(101)
public class RunTaskApplicationRunnerTest implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("任务启动方式：ApplicationRunner" + args.getNonOptionArgs());
        System.out.println("任务启动方式：ApplicationRunner" + args.getOptionNames());
        System.out.println("任务启动方式：ApplicationRunner" + args.getOptionValues("age"));
        System.out.println("任务启动方式：ApplicationRunner" + args.getSourceArgs());
    }

}
