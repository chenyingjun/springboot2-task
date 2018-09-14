package com.chenyingjun.task.schedual;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Task2 {

    private static Log logger = LogFactory.getLog(Task2.class);

    public void method2() {
        logger.info("Task2----method2>>>>" + new Date());
    }
}
