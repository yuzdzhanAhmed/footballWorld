<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	 <jsp:include page="header.jsp" />
	 </div>
	
	<div class="limiter">
	
		<div class="container-login100">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
				<form class="login100-form validate-form"  action="./register" method="post">
					<span class="login100-form-title p-b-33">
						REGISTER
					</span>
				       <c:if test="${not empty errorMessage}">
			                  <h2 style="color: red">${errorMessage}</h2>
		              </c:if>
                     <div >
						<input class="input100" type="text" name="username" placeholder="username">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email" placeholder="Email">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="container-login100-form-btn m-t-20">
						<button class="login100-form-btn">
							Sign up
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>