<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<c:choose>
	<c:when test="${user == null}">
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/ENI-Encheres/">ENI-Encheres</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="ServletCreationCompte"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="Connection"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
		</div>
		</nav>
	</c:when>
	<c:otherwise>
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Servlet">ENI-Encheres</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="Servlet">Enchères</a></li>
				<li><a href="NewArticle">Vendre un article</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="monProfil"><span
						class="glyphicon glyphicon-user"></span> ${user.getPseudo()}</a></li>
				<li><a href="deconnexion"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
		</div>
		</nav>
	</c:otherwise>
</c:choose>
