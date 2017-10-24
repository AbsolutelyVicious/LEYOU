<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='add.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/console/brand/list.do" method="get" style="padding-top:5px;">
品牌名称: <input type="text" name="name" value="${name}"/>
	<select name="isDisplay">
        <option value="1">是</option>
        <option value="0">否</option>
        <%--<c:if test="${isDisplay==null}">
            <option value="1">是</option>
            <option value="0">否</option>
        </c:if>
        <c:if test="${isDisplay==1}"><option value="1">是</option><option value="0">否</option></c:if>
		<c:if test="${isDisplay==0}"><option value="0">否</option><option value="1">是</option></c:if>--%>
        <script >
            $("select[name='isDisplay']").val('${isDisplay}')
        </script>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>

    <input type="hidden" name="nameAg" value="${name}"/>
    <input type="hidden" name="isDisplayAg" value="${isDisplay}"/>

<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkBox('ids',this.checked)"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	<c:forEach items="${brandPage.result}" var="brand">
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="8" name="ids"/></td>
			<td align="center">${brand.id}</td>
			<td align="center">${brand.name}</td>
			<td align="center"><img width="40" height="40" src="${brand.imgUrl}"/></td>
			<td align="center">${brand.description}</td>
			<td align="center">${brand.sort}</td>
			<td align="center">

				<c:if test="${brand.isDisplay==1}">是</c:if>
				<c:if test="${brand.isDisplay==0}">否</c:if>

			</td>
			<td align="center">
				<a class="pn-opt" href="/console/brand/edit.do?id=${brand.id}">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="/deleteById.do?id=${brand.id}">删除</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="page pb15">
	<span class="r inb_a page_b">
	
		<a href="/console/brand/list.do?pageNum=1">首页</a>
	
		<a href="/console/brand/list.do?pageNum=${brandPage.pageNum-1}&name=${name}&isDisplay=${isDisplay}">上一页</a>

        <c:if test="${brandPage.pageNum>=2}">
        <strong><a href="list.do?pageNum=${brandPage.pageNum-1}&name=${name}&isDisplay=${isDisplay}">${brandPage.pageNum-1}</a></strong>
        </c:if>

        <c:forEach begin="${brandPage.pageNum}" end="${brandPage.pageNum}" var="cx">
            <c:if test="${cx==brandPage.pageNum}"><strong>${cx}&nbsp;</strong></c:if>
        </c:forEach>

        <strong><a href="list.do?pageNum=${brandPage.pageNum+1}&name=${name}&isDisplay=${isDisplay}">${brandPage.pageNum+1}</a></strong>

		<a href="/console/brand/list.do?pageNum=${brandPage.pageNum+1}&name=${name}&isDisplay=${isDisplay}">下一页</a>
	
		<a href="/console/brand/list.do?pageNum=${brandPage.pages}&name=${name}&isDisplay=${isDisplay}">尾页</a>
	
		共<var>${brandPage.pages}</var>页 到第<input type="text" size="3" id="PAGENO"/>页 <input type="button" onclick="javascript:window.location.href = '/product/list.do?&amp;isShow=0&amp;pageNo=' + $('#PAGENO').val() " value="确定" class="hand btn60x20" id="skip"/>
	
	</span>
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/></div>
</div>
</body>
</html>