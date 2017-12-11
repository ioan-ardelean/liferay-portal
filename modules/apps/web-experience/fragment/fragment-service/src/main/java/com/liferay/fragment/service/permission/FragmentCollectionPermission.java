/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.fragment.service.permission;

import com.liferay.fragment.model.FragmentCollection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 * @deprecated As of 1.0.0, with no direct replacement
 */
@Component(
	property = {"model.class.name=com.liferay.fragment.model.FragmentCollection"},
	service = BaseModelPermissionChecker.class
)
@Deprecated
public class FragmentCollectionPermission
	implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker,
			FragmentCollection fragmentCollection, String actionId)
		throws PortalException {

		_fragmentCollectionModelResourcePermission.check(
			permissionChecker, fragmentCollection, actionId);
	}

	public static void check(
			PermissionChecker permissionChecker, long fragmentCollectionId,
			String actionId)
		throws PortalException {

		_fragmentCollectionModelResourcePermission.check(
			permissionChecker, fragmentCollectionId, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker,
			FragmentCollection fragmentCollection, String actionId)
		throws PortalException {

		return _fragmentCollectionModelResourcePermission.contains(
			permissionChecker, fragmentCollection, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long fragmentCollectionId,
			String actionId)
		throws PortalException {

		return _fragmentCollectionModelResourcePermission.contains(
			permissionChecker, fragmentCollectionId, actionId);
	}

	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		_fragmentCollectionModelResourcePermission.check(
			permissionChecker, primaryKey, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.fragment.model.FragmentCollection)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<FragmentCollection> modelResourcePermission) {

		_fragmentCollectionModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<FragmentCollection>
		_fragmentCollectionModelResourcePermission;

}