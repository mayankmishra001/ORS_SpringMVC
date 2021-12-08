<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: "Lato", sans-serif;
}

.sidebar {
  height: 80%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 75px;
  left: 0;
/*   background-color: #ddddbb; */
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 15px;
  
}

.sidebar a {
  padding: 5px 8px 8px 32px;
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidebar a:hover {
  color: ;
}

.sidebar .closebtn {
  position: absolute;
  top:0;
  right: 45px;
  font-size: 25px;
  margin-left: 0px;
}

.openbtn {
  font-size: 12px;
  
  background-color: #111;
  color: white;
  padding: 10px 15px;
  
}

.openbtn:hover {
  
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

/* On smaller screens, where height is less tha	n 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
</style>

</head>
<body>
<c:if test="${not empty sessionScope.user }">
<div id="mySidebar" class="sidebar" style="background-color: #ffb629 !important;">

  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">
 <i class="fa fa-remove"></i></a>
  <br>
  <a href="<c:url value="/ctl/User/UserListCtl"/>"><s:message code="label.userlist" /></a>
  <a href="<c:url value="/ctl/Role/RoleListCtl"/>"><s:message code="label.rolelist" /></a>
  <a href="<c:url value="/ctl/Marksheet/MarksheetListCtl"/>"><s:message code="label.marksheetlist"/></a>
  <a href="<c:url value="/ctl/College/CollegeListCtl"/>"><s:message code="label.collegelist" /></a>
  <a href="<c:url value="/ctl/Course/CourseListCtl"/>"><s:message code="label.courselist" /></a>
  <a href="<c:url value="/ctl/Subject/SubjectListCtl"/>"><s:message code="label.subjectlist" /></a>
  <a href="<c:url value="/ctl/Faculty/FacultyListCtl"/>"><s:message code="label.facultylist" /></a>
  <a href="<c:url value="/ctl/Student/StudentListCtl"/>"><s:message code="label.studentlist" /></a>
  <a href="<c:url value="/ctl/Timetable/TimetableListCtl"/>"><s:message code="label.timetablelist" /></a>
</div>


<div id="main">
  <button class="openbtn" onclick="openNav()"  style="background-image:url('<c:url value="http://localhost:8080/Project0/resources/img/11.jpg"></c:url>'); "><i class="fa fa-list"></i> Menu </button>  

</div>


<script>
function openNav() {
  document.getElementById("mySidebar").style.width = "230px";
  document.getElementById("main").style.marginLeft = "250px";
  openbtn="hide"
}

function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
  
</c:if>
</body>
</html> 