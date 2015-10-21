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

package com.liferay.portal.verify;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.StringBundler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 */
public class VerifyOracle extends VerifyProcess {

	protected void alterVarchar2Columns() throws Exception {
		int buildNumber = getBuildNumber();

		StringBundler sb = new StringBundler(3);

		sb.append("select table_name, column_name, data_length from ");
		sb.append("user_tab_columns where data_type = 'VARCHAR2' and ");
		sb.append("char_used = 'B'");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();

			ps = con.prepareStatement(sb.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				String tableName = rs.getString(1);

				if (!isPortalTableName(tableName)) {
					continue;
				}

				String columnName = rs.getString(2);
				int dataLength = rs.getInt(3);

				if (isBetweenBuildNumbers(
						buildNumber, ReleaseInfo.RELEASE_5_2_9_BUILD_NUMBER,
						ReleaseInfo.RELEASE_6_0_0_BUILD_NUMBER) ||
					isBetweenBuildNumbers(
						buildNumber, ReleaseInfo.RELEASE_6_0_5_BUILD_NUMBER,
						ReleaseInfo.RELEASE_6_1_20_BUILD_NUMBER)) {

					// LPS-33903

					if (!ArrayUtil.contains(
							_ORIGINAL_DATA_LENGTH_VALUES, dataLength)) {

						dataLength = dataLength / 4;
					}
				}

				try {
					runSQL(
						con,
						"alter table " + tableName + " modify " + columnName +
							" varchar2(" + dataLength + " char)");
				}
				catch (SQLException sqle) {
					if (sqle.getErrorCode() == 1441) {
						if (_log.isWarnEnabled()) {
							StringBundler warn = new StringBundler(6);

							warn.append("Unable to alter length of column ");
							warn.append(columnName);
							warn.append(" for table ");
							warn.append(tableName);
							warn.append(" because it contains values that are");
							warn.append(" larger than the new column length");

							_log.warn(warn.toString());
						}
					}
					else {
						throw sqle;
					}
				}
			}
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}

	@Override
	protected void doVerify() throws Exception {
		DB db = DBFactoryUtil.getDB();

		String dbType = db.getType();

		if (!dbType.equals(DB.TYPE_ORACLE)) {
			return;
		}

		alterVarchar2Columns();
	}

	protected boolean isBetweenBuildNumbers(
		int buildNumber, int startBuildNumber, int endBuildNumber) {

		if ((buildNumber >= startBuildNumber) &&
			(buildNumber < endBuildNumber)) {

			return true;
		}

		return false;
	}

	private static final int[] _ORIGINAL_DATA_LENGTH_VALUES = {
		75, 100, 150, 200, 255, 500, 1000, 1024, 2000, 4000
	};

	private static final Log _log = LogFactoryUtil.getLog(VerifyOracle.class);

}