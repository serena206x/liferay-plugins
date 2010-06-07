/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.workflow.jbpm.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Set;

import org.jbpm.taskmgmt.exe.PooledActor;

/**
 * <a href="AssigneeRetrievalUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Marcellus Tavares
 */
public class AssigneeRetrievalUtil {

	public static Assignee getAssignee(
			long companyId, String actorId, Set<PooledActor> pooledActors)
		throws PortalException, SystemException {

		Assignee assignee = new Assignee();

		if (pooledActors != null && !pooledActors.isEmpty()) {
			assignee.setAssigneeClassName(Role.class.getName());

			PooledActor pooledActor = pooledActors.iterator().next();

			Role role = null;

			if (Validator.isNumber(pooledActor.getActorId())) {
				role = RoleLocalServiceUtil.getRole(
					GetterUtil.getLong(pooledActor.getActorId()));
			}
			else {
				role = RoleLocalServiceUtil.getRole(
					companyId, pooledActor.getActorId());
			}

			assignee.setAssigneeClassPK(role.getClassPK());
		}
		else {
			assignee.setAssigneeClassName(User.class.getName());

			User user = null;

			if (Validator.isEmailAddress(actorId)) {
				user = UserLocalServiceUtil.getUserByEmailAddress(
					companyId, actorId);
			}
			else {
				user = UserLocalServiceUtil.getUser(
					GetterUtil.getLong(actorId));
			}

			assignee.setAssigneeClassPK(user.getUserId());
		}

		return assignee;
	}

}