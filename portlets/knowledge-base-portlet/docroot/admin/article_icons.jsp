<%
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
%>

<%@ include file="/admin/init.jsp" %>

<%
Article article = (Article)request.getAttribute(WebKeys.KNOWLEDGE_BASE_ARTICLE);

long resourcePrimKey = ParamUtil.getLong(request, "resourcePrimKey");
%>

<c:if test="<%= ArticlePermission.contains(permissionChecker, article, ActionKeys.DELETE) || ArticlePermission.contains(permissionChecker, article, ActionKeys.PERMISSIONS) || ArticlePermission.contains(permissionChecker, article, ActionKeys.UPDATE) %>">
	<div class="kb-article-icons">
		<table class="lfr-table">
		<tr>
			<c:if test="<%= ArticlePermission.contains(permissionChecker, article, ActionKeys.UPDATE) %>">
				<td>
					<portlet:renderURL var="editURL">
						<portlet:param name="jspPage" value="/admin/edit_article.jsp" />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="resourcePrimKey" value="<%= String.valueOf(article.getResourcePrimKey()) %>" />
					</portlet:renderURL>

					<liferay-ui:icon
						image="edit"
						label="<%= true %>"
						url="<%= editURL %>"
					/>
				</td>
			</c:if>

			<c:if test="<%= ArticlePermission.contains(permissionChecker, article, ActionKeys.PERMISSIONS) %>">
				<td>
					<liferay-security:permissionsURL
						modelResource="<%= Article.class.getName() %>"
						modelResourceDescription="<%= article.getTitle() %>"
						resourcePrimKey="<%= String.valueOf(article.getResourcePrimKey()) %>"
						var="permissionsURL"
					/>

					<liferay-ui:icon
						image="permissions"
						label="<%= true %>"
						url="<%= permissionsURL %>"
					/>
				</td>
			</c:if>

			<c:if test="<%= ArticlePermission.contains(permissionChecker, article, ActionKeys.DELETE) %>">
				<td>
					<portlet:renderURL var="homeURL">
						<portlet:param name="jspPage" value="/admin/view.jsp" />
						<portlet:param name="topLink" value="home" />
					</portlet:renderURL>

					<portlet:actionURL name="deleteArticle" var="deleteURL">
						<portlet:param name="redirect" value="<%= (article.getResourcePrimKey() == resourcePrimKey) ? homeURL : currentURL %>" />
						<portlet:param name="resourcePrimKey" value="<%= String.valueOf(article.getResourcePrimKey()) %>" />
					</portlet:actionURL>

					<liferay-ui:icon-delete
						label="<%= true %>"
						url="<%= deleteURL %>"
					/>
				</td>
			</c:if>
		</tr>
		</table>
	</div>
</c:if>