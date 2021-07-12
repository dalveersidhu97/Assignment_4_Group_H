<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/static/head.html"%>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/static/header.html"%>
		<header>
			<h2>Home</h2>
		</header>
		
		<p class="center">Welcome ${user.firstname}</p>
		<br>
		<p class="center"><a href="./logout">Logout</a></p>
		<br>
		<%@ include file="/WEB-INF/static/footer.html"%>
	</div>
</body>
</html>