<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="see-products">
		Email Id : <input type="text" name="email" required><br>
		Customer Name : <input type="text" name="name" required><br>
		Select Category : <select id="categoryId" name="category" required>
    							<c:forEach items="${distinctCategoryList}" var="category">
    									<option name="category" value="${category}">${category}</option>
								</c:forEach>
													  
  						</select>
  						<br>
  		<input type="submit" value="See Products"><br> 
	</form>

</body>
</html>