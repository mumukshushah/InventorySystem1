<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<form action="book-order">
		Select Multiple Products from Category : <select name="product" id="productId" multiple>
													<c:forEach items="${productList}" var="product" varStatus = "s">
    													<option name="product" value="${product.productId}">${product.productName}</option>
													</c:forEach>
													  
												</select>
  												<br>
  		<input type ="hidden" name="emailId" value="${email}"><br>
  		<input type ="hidden" name="customerName" value="${name}"><br>
  		<input type="submit" value="Order"><br> 
	</form>
</body>
</html>