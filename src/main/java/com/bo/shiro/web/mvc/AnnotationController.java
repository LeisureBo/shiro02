package com.bo.shiro.web.mvc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description spring mvc 控制器
 * @author 王博
 * @version 2018年1月22日　下午11:07:14
 */
@Controller
public class AnnotationController {
	
	private static Logger logger = LoggerFactory.getLogger(AnnotationController.class);

    @RequestMapping(value = "/test01", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello1() {
    	logger.info("test01 invoked..");
        SecurityUtils.getSubject().checkRole("admin");
        return "home";
    }

    @RequiresRoles("user")
    @RequestMapping(value = "/test02", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello2() {
    	logger.info("test02 invoked..");
        return "home";
    }

}
