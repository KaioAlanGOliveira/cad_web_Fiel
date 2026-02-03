<%@page import="br.com.kaio.persistence.dao.FielDao"%>
<%@page import="br.com.kaio.domain.Fiel"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String cpf = request.getParameter("cpf");
Fiel fiel = null;
if (cpf != null) {
	fiel = new FielDao().pegar(cpf);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Formulario de fiel</title>
</head>
<body>
	<div class="boxAgenda">
		<h1>Formulario do Fiel</h1>
		<p>
			<%=(fiel == null ? "Adicionar:" : "Atualizar:")%></p>
		<form action="<%=fiel == null ? "fielinsert" : "fielupdate"%>">
			<label>NOME</label> <input placeholder="Nome" type="text" name="nome">
			<label>IDADE</label> <input placeholder="Idade" type="number"
				name="idade"> 
				<label>CPF</label> 
				<input type="number"  value="<%=cpf%>" <%=fiel == null ? "" : "disabled"%> >
				<input type="hidden" name="cpf" value="<%=cpf%>">
				
					
				
				
				<label>TELEFONE</label>
				<input placeholder="Telefone" type="number" name="fone">
			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>