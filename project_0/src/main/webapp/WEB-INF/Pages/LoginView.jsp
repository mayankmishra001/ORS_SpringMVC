<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
</br>
<div class="row">

<div class="col-md-4"></div>
	<div class="col-md-4">
		<div class="card c1">
			<div class="card-body c1 ">
				<h3 class="text-center default-text py-3">
					<s:message code="label.login"></s:message>
				</h3>
				
				<div>
					<c:if test="${error!=null }">
						<div class="alert alert-danger alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="message">
								<i class="nc-icon nc-bell-55"></i>${error}
							</div>
						</div>
					</c:if>

					<c:if test="${success!=null }">
						<div class="alert alert-success alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="message">
								<i class="nc-icon nc-bell-55"></i>${success}
							</div>
						</div>
					</c:if>
				</div>
				<div>
				<sf:form class="register-form" method="POST" modelAttribute="form">
				<sf:hidden path="uri" value="${uri}"/>
				
					
					<sf:label path="emailId">
						<s:message code="label.email" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fas fa-envelope  grey-text"></span>
							</span>
						</div>
						<sf:input path="emailId" class="form-control" 
							placeholder="${enteremail}" />
					</div>

					<font color="red"><sf:errors path="emailId" /></font>
					<br>
					
						<sf:label path="password">
						<s:message code="label.password" />
						<span style="color: red;">*</span>
					</sf:label>
					<div class="input-group">

						<div class="input-group-prepend">
							<span class="input-group-text"> <span
								class="fa fa-key  grey-text"></span>
							</span>
						</div>
						<sf:input type="password" path="password" class="form-control" 
							placeholder="${enterpassword}" />
					</div>

					<font color="red"><sf:errors path="password" /></font>
					<br>
					<br>
					<br>
					<center>
					<button class="btn btn-outline-success" 
					name="operation" value="SignIn">
				<s:message code="label.login" />
				</button>
				<button class="btn btn-outline-danger" 
					name="operation" value="SignUp">
					<s:message code="label.signup" />
				</button>
				<br>
				<div class="forgot">
					<button class="btn btn-link btn-outline-info" 
					name="operation" value="ForgotPassword">
					<s:message code="label.forgetpassword" />
				</button>
				</center>
				
				
			</div>
			<style>
.card{
background-color: #dbbea6e3;
}
	.c1{
	 border-width:5px;  
    border-style:ridge;
  border-radius: 25px;
	}
	.btn{
	padding:13px;
	}
	  
</style>
			
			
			
				</sf:form>
				
				

				</div>
				
				
				

			</div>

		</div>

	</div>

</div>