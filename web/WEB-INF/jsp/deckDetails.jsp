<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyFlashCard</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
        <script src="<c:url value="/resources/js/jQuery.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <style>
            footer {
                background-color: black;
                bottom: -50px;
                height: 60px;
                position: absolute;
                width: 100%;
            }
        </style>
    </head>
    <body>
   <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">MyFlashCard</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li class=""><a href="${pageContext.request.contextPath}/classlist">Class List</a></li>
                        <c:if test="${!empty username}">
                        <li><a href="${pageContext.request.contextPath}/addDeck">Add a Deck</a></li>
                        </c:if>
                </ul>
                <form method="post" class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" name="keyword">
                    </div>
                    <input type="submit" class="btn btn-default" value="Search" formaction="${pageContext.request.contextPath}/search"/>
                </form>
                <c:choose>
                    <c:when test="${empty username}">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="${pageContext.request.contextPath}/signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="${pageContext.request.contextPath}/signin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>                
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Hello, ${username}</a>
                                <ul class="dropdown-menu">
                                    <li><a href="${pageContext.request.contextPath}/mydecks"><span class="glyphicon glyphicon-folder-open"></span> My Decks</a></li>
                                    <li><a href="${pageContext.request.contextPath}/profile"><span class="glyphicon glyphicon-book"></span> Profile</a></li>
                                    <li class="divider"></li>
                                    <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                                </ul>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
    <div style="margin-top: 30px;"></div>
    <main role="main" class="container">
        <h2>Cards for ${deckName}</h2>
        <table class="table table-dark">
            <tr>
                <th>Priority</th>
                <th>Question</th>
                <th>Answer</th>
            </tr>
            <c:set var="count" value="1" scope="page" />
            <c:forEach var="card" items="${cardList}">
                <tr>
                    <td>${count}</td>
                    <td>${card.question}</td>
                    <td>${card.answer}</td>
                </tr>
                <c:set var="count" value="${count + 1}" scope="page"/>   
            </c:forEach>
        </table>
    </main>
    <footer class="container-fluid bg-4 text-center">
        <p>Bootstrap Theme Made By <a href="https://www.w3schools.com">www.w3schools.com</a></p> 
    </footer>
</body>
</html>
