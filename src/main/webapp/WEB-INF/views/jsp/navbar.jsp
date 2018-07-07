<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">


<head>
<title>footballWorld</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="footballWorld/css/layout.css" rel="stylesheet" type="text/css" media="all">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="icon" type="image/png" href="footballWorld/images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="footballWorld/css/util.css">
	<link rel="stylesheet" type="text/css" href="footballWorld/css/main.css">
	<link href="footballWorld/css/live.css" rel="stylesheet" type="text/css">
	<!--===============================================================================================-->

</head>
<body id="top">

<div class="wrapper row1">
  <header id="header" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="one_half first">
      <h1 class="logoname"><a href="./index"><span>FOOTBALL</span>world</a></h1>
    </div>
    <!-- ################################################################################################ -->
  </header>
  
<nav class="navbar navbar-inverse" style="background-color: SteelBlue    ">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Home</a>
    </div>
    <ul class="nav navbar-nav">
       <li><a href="./live">LIVESCORE</a></li>
      <li><a href="#">tips</a></li>
      <li><a href="#">statistics</a></li>
      <li><a href="#">fixtures</a></li>
      <li><a href="#">results</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="
      #">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:choose>
      <c:when test="${not empty sessionScope.user}">
        	 <li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
     		 <li><a href="./signout"><span class="glyphicon glyphicon-log-in"></span> Sign Out</a></li>
    </c:when>
       <c:otherwise>
             <li><a href="./register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     		 <li><a href="./login"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
       	</c:otherwise>
	</c:choose>
    </ul>
  </div>
</nav>
</div>