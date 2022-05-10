
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addProduct" method="get">
		Enter Product Name <input type="text" name="name"><br>
		Enter Category
		<select name="category">
		<option value="ELECTRONICS">ELECTRONICS</option>
		<option value="TOYS">TOYS</option>
		<option value="SPORTS">SPORTS</option>
		<option value="SHOES">SHOES</option>
		<option value="STATIONERY">STATIONERY</option>
		<option value="APPARELS">ELECTRONICS</option>
		</select>
		Enter Brand <input type="text" name="brand"><br> 
		Enter Price <input type="text" name="price"><br> 
		<input	type="submit" value="Add Employee">
	</form>
</body>
</html>