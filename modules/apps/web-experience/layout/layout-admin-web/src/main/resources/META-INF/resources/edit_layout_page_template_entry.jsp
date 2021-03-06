<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
LayoutPageTemplateDisplayContext layoutPageTemplateDisplayContext = new LayoutPageTemplateDisplayContext(renderRequest, renderResponse, request);

String redirect = layoutPageTemplateDisplayContext.getEditLayoutPageTemplateEntryRedirect();

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(layoutPageTemplateDisplayContext.getLayoutPageTemplateEntryTitle());
%>

<portlet:actionURL name="/layout/edit_layout_page_template_fragments" var="editLayoutPageTemplateFragmentsURL">
	<portlet:param name="mvcPath" value="/edit_layout_page_template_entry.jsp" />
</portlet:actionURL>

<portlet:actionURL name="/layout/render_fragment_entry" var="renderFragmentEntryURL" />

<%
Map<String, Object> layoutPageTemplateEditorContext = new HashMap<>();

layoutPageTemplateEditorContext.put("fragments", layoutPageTemplateDisplayContext.getFragmentEntryLinksJSONArray());
layoutPageTemplateEditorContext.put("fragmentCollections", layoutPageTemplateDisplayContext.getFragmentCollectionsJSONArray());
layoutPageTemplateEditorContext.put("layoutPageTemplateEntryId", layoutPageTemplateDisplayContext.getLayoutPageTemplateEntryId());
layoutPageTemplateEditorContext.put("portletNamespace", renderResponse.getNamespace());
layoutPageTemplateEditorContext.put("renderFragmentEntryURL", renderFragmentEntryURL);
layoutPageTemplateEditorContext.put("spritemap", themeDisplay.getPathThemeImages() + "/lexicon/icons.svg");
layoutPageTemplateEditorContext.put("updatePageTemplateURL", String.valueOf(editLayoutPageTemplateFragmentsURL));
%>

<soy:template-renderer
	context="<%= layoutPageTemplateEditorContext %>"
	module="layout-admin-web/js/fragments_editor/LayoutPageTemplateEditor.es"
	templateNamespace="LayoutPageTemplateEditor.render"
/>