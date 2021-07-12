<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/static/head.html"%>
<body>
	<div class="container">



		<%@ include file="/WEB-INF/static/header.html"%>

		<header>
			<h2>Register</h2>
		</header>


		<form:form class="form" id="regForm" modelAttribute="user"
			action="registerProcess" method="post">
			<div>
				<form:label path="username"> Username</form:label>
				<form:input path="username" name="username" id="username" />
			</div>
			<div>
				<form:label path="password"> Password</form:label>
				<form:password path="password" name="password" id="password" />
			</div>
			<div>
				<form:label path="firstname"> FirstName</form:label>
				<form:input path="firstname" name="firstname" id="firstname" />
			</div>
			<div>
				<form:label path="lastname"> LastName</form:label>
				<form:input path="lastname" name="lastname" id="lastname" />
			</div>
			<div>
				<form:label path="email"> Email</form:label>
				<form:input path="email" name="email" id="email" />
			</div>
			<div>
				<form:label path="address"> Address</form:label>
				<form:input path="address" name="address" id="address" />
			</div>
			<div>
				<form:label path="phone"> Phone</form:label>
				<form:input path="phone" name="phone" id="phone" />
			</div>
			<div>
				<form:button id="register" name="register"> Register</form:button>
			</div>

		</form:form>
		<br>
		<center>${message}</center>
		<br>
		<%@ include file="/WEB-INF/static/footer.html"%>
	</div>
</body>
</html>