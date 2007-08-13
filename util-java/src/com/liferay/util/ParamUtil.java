/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.util;

import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.util.xml.DocUtil;
import com.liferay.util.xml.XMLFormatter;

import java.io.IOException;

import java.text.DateFormat;

import java.util.Date;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowStateException;

import javax.servlet.ServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * <a href="ParamUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 *
 */
public class ParamUtil {

	// Servlet Request

	public static boolean getBoolean(ServletRequest req, String param) {
		return GetterUtil.getBoolean(req.getParameter(param));
	}

	public static boolean getBoolean(
		ServletRequest req, String param, boolean defaultValue) {

		return get(req, param, defaultValue);
	}

	public static boolean[] getBooleanValues(
		ServletRequest req, String param) {

		return getBooleanValues(req, param, new boolean[0]);
	}

	public static boolean[] getBooleanValues(
		ServletRequest req, String param, boolean[] defaultValue) {

		return GetterUtil.getBooleanValues(
			req.getParameterValues(param), defaultValue);
	}

	public static Date getDate(
		ServletRequest req, String param, DateFormat df) {

		return GetterUtil.getDate(req.getParameter(param), df);
	}

	public static Date getDate(
		ServletRequest req, String param, DateFormat df, Date defaultValue) {

		return get(req, param, df, defaultValue);
	}

	public static double getDouble(ServletRequest req, String param) {
		return GetterUtil.getDouble(req.getParameter(param));
	}

	public static double getDouble(
		ServletRequest req, String param, double defaultValue) {

		return get(req, param, defaultValue);
	}

	public static double[] getDoubleValues(ServletRequest req, String param) {
		return getDoubleValues(req, param, new double[0]);
	}

	public static double[] getDoubleValues(
		ServletRequest req, String param, double[] defaultValue) {

		return GetterUtil.getDoubleValues(
			req.getParameterValues(param), defaultValue);
	}

	public static float getFloat(ServletRequest req, String param) {
		return GetterUtil.getFloat(req.getParameter(param));
	}

	public static float getFloat(
		ServletRequest req, String param, float defaultValue) {

		return get(req, param, defaultValue);
	}

	public static float[] getFloatValues(ServletRequest req, String param) {
		return getFloatValues(req, param, new float[0]);
	}

	public static float[] getFloatValues(
		ServletRequest req, String param, float[] defaultValue) {

		return GetterUtil.getFloatValues(
			req.getParameterValues(param), defaultValue);
	}

	public static int getInteger(ServletRequest req, String param) {
		return GetterUtil.getInteger(req.getParameter(param));
	}

	public static int getInteger(
		ServletRequest req, String param, int defaultValue) {

		return get(req, param, defaultValue);
	}

	public static int[] getIntegerValues(ServletRequest req, String param) {
		return getIntegerValues(req, param, new int[0]);
	}

	public static int[] getIntegerValues(
		ServletRequest req, String param, int[] defaultValue) {

		return GetterUtil.getIntegerValues(
			req.getParameterValues(param), defaultValue);
	}

	public static long getLong(ServletRequest req, String param) {
		return GetterUtil.getLong(req.getParameter(param));
	}

	public static long getLong(
		ServletRequest req, String param, long defaultValue) {

		return get(req, param, defaultValue);
	}

	public static long[] getLongValues(ServletRequest req, String param) {
		return getLongValues(req, param, new long[0]);
	}

	public static long[] getLongValues(
		ServletRequest req, String param, long[] defaultValue) {

		return GetterUtil.getLongValues(
			req.getParameterValues(param), defaultValue);
	}

	public static short getShort(ServletRequest req, String param) {
		return GetterUtil.getShort(req.getParameter(param));
	}

	public static short getShort(
		ServletRequest req, String param, short defaultValue) {

		return get(req, param, defaultValue);
	}

	public static short[] getShortValues(ServletRequest req, String param) {
		return getShortValues(req, param, new short[0]);
	}

	public static short[] getShortValues(
		ServletRequest req, String param, short[] defaultValue) {

		return GetterUtil.getShortValues(
			req.getParameterValues(param), defaultValue);
	}

	public static String getString(ServletRequest req, String param) {
		return GetterUtil.getString(req.getParameter(param));
	}

	public static String getString(
		ServletRequest req, String param, String defaultValue) {

		return get(req, param, defaultValue);
	}

	public static boolean get(
		ServletRequest req, String param, boolean defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static Date get(
		ServletRequest req, String param, DateFormat df, Date defaultValue) {

		return GetterUtil.get(req.getParameter(param), df, defaultValue);
	}

	public static double get(
		ServletRequest req, String param, double defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static float get(
		ServletRequest req, String param, float defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static int get(ServletRequest req, String param, int defaultValue) {
		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static long get(
		ServletRequest req, String param, long defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static short get(
		ServletRequest req, String param, short defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static String get(
		ServletRequest req, String param, String defaultValue) {

		String returnValue =
			GetterUtil.get(req.getParameter(param), defaultValue);

		if (returnValue != null) {
			return returnValue.trim();
		}

		return null;
	}

	public static void print(ServletRequest req) {
		Enumeration e = req.getParameterNames();

		while (e.hasMoreElements()) {
			String param = (String)e.nextElement();

			String[] values = req.getParameterValues(param);

			for (int i = 0; i < values.length; i++) {
				System.out.println(param + "[" + i + "] = " + values[i]);
			}
		}
	}

	// Portlet Request

	public static boolean getBoolean(PortletRequest req, String param) {
		return GetterUtil.getBoolean(req.getParameter(param));
	}

	public static boolean getBoolean(
		PortletRequest req, String param, boolean defaultValue) {

		return get(req, param, defaultValue);
	}

	public static boolean[] getBooleanValues(
		PortletRequest req, String param) {

		return getBooleanValues(req, param, new boolean[0]);
	}

	public static boolean[] getBooleanValues(
		PortletRequest req, String param, boolean[] defaultValue) {

		return GetterUtil.getBooleanValues(
			req.getParameterValues(param), defaultValue);
	}

	public static Date getDate(
		PortletRequest req, String param, DateFormat df) {

		return GetterUtil.getDate(req.getParameter(param), df);
	}

	public static Date getDate(
		PortletRequest req, String param, DateFormat df, Date defaultValue) {

		return get(req, param, df, defaultValue);
	}

	public static double getDouble(PortletRequest req, String param) {
		return GetterUtil.getDouble(req.getParameter(param));
	}

	public static double getDouble(
		PortletRequest req, String param, double defaultValue) {

		return get(req, param, defaultValue);
	}

	public static double[] getDoubleValues(PortletRequest req, String param) {
		return getDoubleValues(req, param, new double[0]);
	}

	public static double[] getDoubleValues(
		PortletRequest req, String param, double[] defaultValue) {

		return GetterUtil.getDoubleValues(
			req.getParameterValues(param), defaultValue);
	}

	public static float getFloat(PortletRequest req, String param) {
		return GetterUtil.getFloat(req.getParameter(param));
	}

	public static float getFloat(
		PortletRequest req, String param, float defaultValue) {

		return get(req, param, defaultValue);
	}

	public static float[] getFloatValues(PortletRequest req, String param) {
		return getFloatValues(req, param, new float[0]);
	}

	public static float[] getFloatValues(
		PortletRequest req, String param, float[] defaultValue) {

		return GetterUtil.getFloatValues(
			req.getParameterValues(param), defaultValue);
	}

	public static int getInteger(PortletRequest req, String param) {
		return GetterUtil.getInteger(req.getParameter(param));
	}

	public static int getInteger(
		PortletRequest req, String param, int defaultValue) {

		return get(req, param, defaultValue);
	}

	public static int[] getIntegerValues(PortletRequest req, String param) {
		return getIntegerValues(req, param, new int[0]);
	}

	public static int[] getIntegerValues(
		PortletRequest req, String param, int[] defaultValue) {

		return GetterUtil.getIntegerValues(
			req.getParameterValues(param), defaultValue);
	}

	public static long getLong(PortletRequest req, String param) {
		return GetterUtil.getLong(req.getParameter(param));
	}

	public static long getLong(
		PortletRequest req, String param, long defaultValue) {

		return get(req, param, defaultValue);
	}

	public static long[] getLongValues(PortletRequest req, String param) {
		return getLongValues(req, param, new long[0]);
	}

	public static long[] getLongValues(
		PortletRequest req, String param, long[] defaultValue) {

		return GetterUtil.getLongValues(
			req.getParameterValues(param), defaultValue);
	}

	public static short getShort(PortletRequest req, String param) {
		return GetterUtil.getShort(req.getParameter(param));
	}

	public static short getShort(
		PortletRequest req, String param, short defaultValue) {

		return get(req, param, defaultValue);
	}

	public static short[] getShortValues(PortletRequest req, String param) {
		return getShortValues(req, param, new short[0]);
	}

	public static short[] getShortValues(
		PortletRequest req, String param, short[] defaultValue) {

		return GetterUtil.getShortValues(
			req.getParameterValues(param), defaultValue);
	}

	public static String getString(PortletRequest req, String param) {
		return GetterUtil.getString(req.getParameter(param));
	}

	public static String getString(
		PortletRequest req, String param, String defaultValue) {

		return get(req, param, defaultValue);
	}

	public static boolean get(
		PortletRequest req, String param, boolean defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static Date get(
		PortletRequest req, String param, DateFormat df, Date defaultValue) {

		return GetterUtil.get(req.getParameter(param), df, defaultValue);
	}

	public static double get(
		PortletRequest req, String param, double defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static float get(
		PortletRequest req, String param, float defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static int get(PortletRequest req, String param, int defaultValue) {
		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static long get(
		PortletRequest req, String param, long defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static short get(
		PortletRequest req, String param, short defaultValue) {

		return GetterUtil.get(req.getParameter(param), defaultValue);
	}

	public static String get(
		PortletRequest req, String param, String defaultValue) {

		String returnValue =
			GetterUtil.get(req.getParameter(param), defaultValue);

		if (returnValue != null) {
			return returnValue.trim();
		}

		return null;
	}

	public static void print(PortletRequest req) {
		Enumeration e = req.getParameterNames();

		while (e.hasMoreElements()) {
			String param = (String)e.nextElement();

			String[] values = req.getParameterValues(param);

			for (int i = 0; i < values.length; i++) {
				System.out.println(param + "[" + i + "] = " + values[i]);
			}
		}
	}

	public static String toXML(PortletRequest req, PortletResponse res) {
		String xml = null;

		Document doc = DocumentHelper.createDocument();

		Element request = doc.addElement("request");

		DocUtil.add(request, "container-type", "portlet");
		DocUtil.add(request, "container-namespace", req.getContextPath());
		DocUtil.add(request, "content-type", req.getResponseContentType());
		DocUtil.add(request, "server-name", req.getServerName());
		DocUtil.add(request, "server-port", req.getServerPort());
		DocUtil.add(request, "secure", req.isSecure());
		DocUtil.add(request, "auth-type", req.getAuthType());
		DocUtil.add(request, "remote-user", req.getRemoteUser());
		DocUtil.add(request, "context-path", req.getContextPath());
		DocUtil.add(request, "locale", req.getLocale());
		DocUtil.add(request, "portlet-mode", req.getPortletMode());
		DocUtil.add(request, "portlet-session-id", req.getRequestedSessionId());
		DocUtil.add(request, "scheme", req.getScheme());
		DocUtil.add(request, "window-state", req.getWindowState());

		if (req instanceof RenderRequest) {
			DocUtil.add(request, "action", Boolean.FALSE);
		}
		else if (req instanceof ActionRequest) {
			DocUtil.add(request, "action", Boolean.TRUE);
		}

		if (res instanceof RenderResponse) {
			_toXML((RenderResponse)res, request);
		}

		Element parameters = request.addElement("parameters");

		Enumeration enu = req.getParameterNames();

		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();

			Element parameter = parameters.addElement("parameter");

			DocUtil.add(parameter, "name", name);

			String[] values = req.getParameterValues(name);

			for (int i = 0; i < values.length; i++) {
				DocUtil.add(parameter, "value", values[i]);
			}
		}

		try {
			xml = XMLFormatter.toString(doc);
		}
		catch (IOException ioe) {
		}

		return xml;
	}

	private static void _toXML(RenderResponse res, Element request) {
		DocUtil.add(request, "portlet-namespace", res.getNamespace());

		PortletURL url = res.createRenderURL();

		DocUtil.add(request, "render-url", url);

		try {
			url.setWindowState(LiferayWindowState.EXCLUSIVE);

			DocUtil.add(request, "render-url-exclusive", url);
		}
		catch (WindowStateException wse) {
		}

		try {
			url.setWindowState(LiferayWindowState.MAXIMIZED);

			DocUtil.add(request, "render-url-maximized", url);
		}
		catch (WindowStateException wse) {
		}

		try {
			url.setWindowState(LiferayWindowState.MINIMIZED);

			DocUtil.add(request, "render-url-minimized", url);
		}
		catch (WindowStateException wse) {
		}

		try {
			url.setWindowState(LiferayWindowState.NORMAL);

			DocUtil.add(request, "render-url-normal", url);
		}
		catch (WindowStateException wse) {
		}

		try {
			url.setWindowState(LiferayWindowState.POP_UP);

			DocUtil.add(request, "render-url-pop-up", url);
		}
		catch (WindowStateException wse) {
		}
	}

}