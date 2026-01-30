package com.lsh.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StopWatchTest {

    private static final Logger log = LoggerFactory.getLogger(StopWatchTest.class);

    @RequestMapping("/stopWatchTest1")
    public String stopWatchTest1() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("测试");
        stopWatch.start("task1");
        Thread.sleep(2000);
        stopWatch.stop();
        stopWatch.start("task2");
        Thread.sleep(3000);
        stopWatch.stop();
        log.error("耗时：{}", stopWatch);
        return stopWatch.toString();
    }
}
