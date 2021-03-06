/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.servermanager.executor;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.Map;
import java.util.Queue;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
public interface Executor {

	public void executeCreate(
			HttpServletRequest request, JSONObject responseJSONObject,
			Queue<String> arguments)
		throws Exception;

	public void executeDelete(
			HttpServletRequest request, JSONObject responseJSONObject,
			Queue<String> arguments)
		throws Exception;

	public void executeRead(
			HttpServletRequest request, JSONObject responseJSONObject,
			Queue<String> arguments)
		throws Exception;

	public void executeUpdate(
			HttpServletRequest request, JSONObject responseJSONObject,
			Queue<String> arguments)
		throws Exception;

	public Executor getNextExecutor(Queue<String> arguments);

	public Map<String, Executor> getNextExecutors();

}