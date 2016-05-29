<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	    <title><s:text name="label.pedido.subject"/></title>
	</head>
	<body>
		<div class="titleDiv"><s:text name="application.pedidos.title"/></div>
		<h1><s:text name="label.pedido.subject"/> <s:text name="label.pedido.from"/> <s:property value="username"/></h1>
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
		        <th><s:text name="label.pedido.id"/></th>
		        <th><s:text name="label.pedido.fecha"/></th>
		        <th><s:text name="label.pedido.entregado"/></th>
		        <th>&nbsp;&nbsp;</th>
		    </tr>
		    <s:iterator value="pedidos" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="idPedido"/></td>
		            <td class="nowrap"><s:property value="fecha"/></td>
		            <td class="nowrap"><s:property value="entregado"/></td>
		            <td><s:url action="showCliente" id="cliente" >
				          <s:param name="dni"><s:property value="dni"/></s:param>
				       </s:url>
				       <s:a href="%{cliente}">Cliente</s:a></td>
				    <td><s:url action="showElementos" id="elementos" >
				          <s:param name="idPedido"><s:property value="idPedido"/></s:param>
				       </s:url>
				       <s:a href="%{elementos}">Elementos</s:a></td>
		        </tr>
		    </s:iterator>
		</table>
		
		<s:actionerror />
		<s:actionmessage />
		<s:form action="pedidos!selectPedido.action" method="post">
		    <s:select name="selectedPedido.idPedido" list="pedidos" listKey="idPedido" listValue="idPedido" label="%{getText('label.pedido.select')}"/>
		    <s:hidden name="username" value="%{username}" />
		    <s:submit value="%{getText('button.label.submit')}"/>
		</s:form>
	</body>
</html>