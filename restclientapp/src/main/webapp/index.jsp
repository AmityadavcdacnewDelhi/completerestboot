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
	 //   int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		RestTemplate client = new RestTemplate();
		String url = "http://localhost:8000/products/all";//?categoryId=" + categoryId;
		ResponseEntity<String> responseEntity = client.getForEntity(url, String.class);
		String jsonResponse = responseEntity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonResponse);
		Iterator<JsonNode> iter = rootNode.elements();
		while(iter.hasNext())
		{
			JsonNode firstNode = iter.next();		
	%>
		<tr>
		<td><%=firstNode.path("id").path("categoryId").asText() %></td>
		<td><%=firstNode.path("id").path("productId").asText() %></td>
		<td><%=firstNode.path("productName").asText()%></td>
		<td><%=firstNode.path("productDescription").asText()%></td>
		<td><%=firstNode.path("productImageUrl").asText()%></td>
		<td><%=firstNode.path("productPrice").asText()%></td>
		</tr>
			
	
<%-- 			<tr>
				<td><%=productName%></td>
				<td><%=productDescription%></td>
				<td><%=productPrice%></td>
				<td><%=productImageUrl%></td>
			</tr>	
	--%>
	<%
		}
	%>
		
	</table>
	<%=jsonResponse %>
</body>
</html>
 