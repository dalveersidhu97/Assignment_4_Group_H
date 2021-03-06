<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/static/head.html"%>
<body>
	<div class="container">
	<%@ include file="/WEB-INF/static/header.html"%>

	<section>
		<header>
			<h2>Login</h2>
		</header>
	
		<form:form class="form" id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<div>
				<form:label path="username"> Username: </form:label></td>
				<form:input path="username" name="username" id="username" />
			</div>
			<div>
				<form:label path="password"> Password:</form:label>
				<form:password path="password" name="password" id="password" />
			</div>
			<div>
				<form:button id="login" name="login">Login</form:button>
			</div>
		</form:form>
		<br>
		<center>${message}</center>
	</section>
	
	
	<%@ include file="/WEB-INF/static/footer.html"%>
	</div>
</body>
</html>