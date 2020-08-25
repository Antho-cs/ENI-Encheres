<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<c:choose>
    <c:when test="${user == null}">
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Servlet">ENI-Encheres</a>
    </div>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="ServletCreationCompte"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="Connection"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
    </c:when>
    <c:otherwise>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Servlet">ENI-Encheres</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Servlet">Enchères</a></li>
      <li><a href="NewArticle">Vendre un article</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
   		<li><a href="monProfil"><span class="glyphicon glyphicon-user"></span> ${user.getPseudo()}</a></li>
      	<li><a href="deconnexion"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
    </c:otherwise>
</c:choose>
