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

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.base.BaseClayTag;

/**
 * @author Julien Castelain
 */
public class UserCardTag extends BaseClayTag {

	public UserCardTag() {
		super("card", "ClayUserCard", true);
	}

	public void setActionItems(Object actionItems) {
		putValue("actionItems", actionItems);
	}

	public void setDisabled(Boolean disabled) {
		putValue("disabled", disabled);
	}

	public void setGroupName(String groupName) {
		putValue("groupName", groupName);
	}

	public void setHref(String href) {
		putValue("href", href);
	}

	public void setImageAlt(String imageAlt) {
		putValue("imageAlt", imageAlt);
	}

	public void setImageSrc(String imageSrc) {
		putValue("imageSrc", imageSrc);
	}

	public void setInitials(String initials) {
		putValue("initials", initials);
	}

	public void setInputName(String inputName) {
		putValue("inputName", inputName);
	}

	public void setInputValue(String inputValue) {
		putValue("inputValue", inputValue);
	}

	public void setName(String name) {
		putValue("name", name);
	}

	public void setSelectable(Boolean selectable) {
		putValue("selectable", selectable);
	}

	public void setSelected(Boolean selected) {
		putValue("selected", selected);
	}

	public void setSubtitle(String subtitle) {
		putValue("subtitle", subtitle);
	}

	public void setUserColor(String userColor) {
		putValue("userColor", userColor);
	}

}