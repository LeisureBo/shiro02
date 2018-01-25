package com.bo.shiro.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bo.shiro.dao.PermissionDao;
import com.bo.shiro.dao.PermissionDaoImpl;
import com.bo.shiro.entity.Permission;

/**
 * @Description
 * @author 王博
 * @version 2017年10月18日　下午5:24:55
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
	
	@Resource
	private PermissionDao permissionDao;

	/**
	 * @Description 创建权限
	 * @param permission
	 * @return
	 */
	public Permission createPermission(Permission permission) {
		return permissionDao.addPermission(permission);
	}

	/**
	 * @Description 更新权限
	 * @param permission
	 */
	public void updatePermission(Permission permission) {
		permissionDao.updatePermission(permission);
	}

	/**
	 * @Description 删除权限
	 * @param permissionId
	 */
	public void deletePermission(Long permissionId) {
		permissionDao.deletePermission(permissionId);
	}

	/**
	 * @Description 
	 * @param permission
	 * @return
	 */
	@Override
	public Permission findByIdentifier(String permission) {
		return permissionDao.findByIdentifier(permission);
	}
}
