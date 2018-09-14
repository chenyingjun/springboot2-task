package com.chenyingjun.task.rest;

import com.chenyingjun.task.Task3;
import com.chenyingjun.task.Task4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * 测试接口
 */
@Controller
@RequestMapping(value = "/api/cron")
public class cronRest {

    @Autowired
    private Task3 task3;

    private static Task4 task4;

    /**
     * 改变task3的cron
     * @param cron cron值
     * @return 成功标志
     */
    @RequestMapping(value = { "/setTask3Cron" }, method = RequestMethod.GET)
    @ResponseBody
    public String setTask3Cron(String cron) {
        task3.setCron(cron);
        return "success";
    }

    /**
     * 初始化task4
     * 这里的代码不应该写在rest层上， 应该写在service层上
     */
    @PostConstruct
    private void initTask4() {
        //初始化task4任务调度器cron，可以从数据库中查询到cron值
        setTask4Cron("0/3 * * * * ?");
    }

    /**
     * 改变task4的cron
     * @param cron cron值
     * @return 成功标志
     */
    @RequestMapping(value = { "/setTask4Cron" }, method = RequestMethod.GET)
    @ResponseBody
    public String setTask4Cron(String cron) {
        if (null == task4) {
            task4 = new Task4();
        }

        task4.reStart(cron);
        return "success";
    }
}
