<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.fasterxml.jackson.databind.ObjectReader"%>
<%@page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="org.springframework.http.ResponseEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" %>
<%@ page import="org.springframework.web.client.RestTemplate" %>
<html>
<body>

	<table border='1'>
	<%
		RestTemplate client = new RestTemplate();
		String url = "http://localhost/category/get/1";
		ResponseEntity<String> responseEntity = client.getForEntity(url, String.class);
		String jsonResponse = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonResponse);
				
	%>
		<tr>
		<td><%=rootNode.path("categoryId").asText() %></td>
		<td><a href='index.jsp?categoryId=<%=rootNode.path("categoryId").asText()%>'><%=rootNode.path("categoryName").asText()%></td>
		<td><%=rootNode.path("categoryDescription").asText()%></td>
		<td><%=rootNode.path("categoryImageUrl").asText()%></td>
		
		</tr>
			
	
<%-- 			<tr>
				<td><%=productName%></td>
				<td><%=productDescription%></td>
				<td><%=productPrice%></td>
				<td><%=productImageUrl%></td>
			</tr>	
	--%>
	<%
		
	%>
		
	</table>
	
</body>
</html>
 