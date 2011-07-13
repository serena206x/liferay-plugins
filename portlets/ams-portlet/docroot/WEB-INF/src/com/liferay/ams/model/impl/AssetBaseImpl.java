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

package com.liferay.ams.model.impl;

import com.liferay.ams.model.Asset;
import com.liferay.ams.service.AssetLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Asset service. Represents a row in the &quot;AMS_Asset&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetImpl
 * @see com.liferay.ams.model.Asset
 * @generated
 */
public abstract class AssetBaseImpl extends AssetModelImpl implements Asset {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset model instance should use the {@link Asset} interface instead.
	 */
	public void save() throws SystemException {
		AssetLocalServiceUtil.updateAsset(this);
	}
}