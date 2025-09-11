<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- create JSP FILE and on file do
* define 2 variable id name with any values 
* define function with input id and name and return concatination with id and name
* call function and print it on jsp file -->

<%
	int id = 1 ;
	String name = "Mohamed Sayed";
	
%>

<%!
	public String concatenate (int id , String name){
	return "Id is : " + id + "<br>" + "Name is : " + name;
}
%>


<%String result =  concatenate(id,name); %>

<h2>Result from Function:</h2>
<p><%= result %></p>
</body>
</html>