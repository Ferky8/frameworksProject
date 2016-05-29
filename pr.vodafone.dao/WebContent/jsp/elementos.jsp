<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	    <title><s:text name="label.pedido.subject"/></title>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.pedidos.title"/></div>
		<h1><s:text name="label.elemento.subject"/> <s:text name="label.elemento.from"/> <s:property value="idPedido"/></h1>
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
		        <th><s:text name="label.elemento.cantidad"/></th>
		        <th><s:text name="label.elemento.nombre"/></th>
		        <th><s:text name="label.elemento.importe"/></th>
		        <th>&nbsp;&nbsp;</th>
		    </tr>
		    <s:iterator value="elementos" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="cantidad"/></td>
		            <td class="nowrap"><s:property value="nombre"/></td>
		            <td class="nowrap"><s:property value="importe"/></td>
		        </tr>
		    </s:iterator>
		</table>
	</body>
</html>