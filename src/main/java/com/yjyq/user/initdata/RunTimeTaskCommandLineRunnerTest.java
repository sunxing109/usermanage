package com.yjyq.user.initdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 任务启动方式：CommandLineRunner
 *  传参方式 java -jar usermanage.jar 三国演义 江南风光
 * @author sunxingba
 * @version 1.0 $
 */
@Component
@Order(101)
public class RunTimeTaskCommandLineRunnerTest implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("任务启动方式：CommandLineRunner" + args);
    }
}
