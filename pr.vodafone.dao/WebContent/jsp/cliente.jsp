<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	    <title><s:text name="label.cliente.subject"/></title>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.pedidos.title"/></div>
		<h1><s:text name="label.cliente.subject"/> <s:property value="dni"/></h1>
		<br/>
		<table>
			<tr>
				<td>
					<s:url id="urlLogout" action="showLogin" escapeAmp="false"/>
					<a href="<s:property value="#urlLogout"/>"><s:text name="label.pedido.logout"/></a>
				</td>
			</tr>
		</table>
		<br/>
		<table class="borderAll">
		    <tr>
		        <th><s:text name="label.cliente.nombre"/></th>
		        <th><s:text name="label.cliente.direccion"/></th>
		        <th><s:text name="label.cliente.email"/></th>
		        <th>&nbsp;&nbsp;</th>
		    </tr>
	        <tr class="even">
	            <td class="nowrap"><s:property value="%{cliente.nombre}"/></td>
	            <td class="nowrap"><s:property value="%{cliente.direccion}"/></td>
	            <td class="nowrap"><s:property value="%{cliente.email}"/></td>
	        </tr>
		</table>
	</body>
</html>