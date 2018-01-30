package com.bo.shiro.web.mvc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description shiro权限注解测试控制层
 * @author 王博
 * @version 2018年1月22日 下午11:07:14
 */
// shiro注解可用在类上表示访问该类需要的默认权限,方法权限注解优先级高于类权限注解
@Controller
@RequiresRoles("tourist")
public class AnnotationController {

	private static Logger logger = LoggerFactory.getLogger(AnnotationController.class);

	@RequestMapping(value = "/test01", method = { RequestMethod.GET, RequestMethod.POST })
	public String test01() {
		logger.info("test01 invoked..");
//		SecurityUtils.getSubject().checkRole("admin");
		return "home";
	}

	@RequiresRoles("user")
	@RequestMapping(value = "/test02", method = { RequestMethod.GET, RequestMethod.POST })
	public String test02() {
		logger.info("test02 invoked..");
		return "home";
	}

	@RequiresPermissions(value = { "user:delete", "user:create" }, logical = Logical.AND)
	@RequestMapping(value = "/test03")
	public String test03() {
		logger.info("test03 invoked..");
		return "home";
	}

}
