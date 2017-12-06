<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyFlashCard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            footer {
                background-color: black;
                bottom: -50px;
                height: 60px;
                position: absolute;
                width: 100%;
            }
            .bannerPicture {
                width: 1700px;
                height: 360px;
            }
            .centered {
                position: absolute;
                top: 20%;
                left: 50%;
                transform: translate(-50%, -50%);
                font-size: 100%;
            }
        </style>
    </head>
    
    <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">MyFlashCard</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/addDeck">Add a Deck</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>
    <div style="margin-top: 30px;"></div>

<div class="container">
  <img class="bannerPicture" src="<c:url value="/resources/img/myFlashCardBanner.jpg" />" alt="bannerPic" style="width:100%;">
  <div class="centered"><h1>My Flash Card</h1></div>
</div>


    <main role="main" class="container">
        <h2>All Decks</h2>
        <form method="get">
            <table class="table table-striped">
                <tr>
                    <th>#</ht>
                    <th>Deck name</th>
                    <th>Action</th>
                </tr>
                <c:set var="count" value="1" scope="page" />
                <c:forEach var="deck" items="${deckList}">
                    <tr>
                        <td>${count}</td>
                        <td>${deck.deckname}</td>
                        <td><input type="submit" class="btn btn-default" value="View Deck" formaction="${pageContext.request.contextPath}/viewDeckDetails/${deck.id}" ></input></td>
                    </tr>
                    <c:set var="count" value="${count + 1}" scope="page"/>   
                </c:forEach>
            </table>
        </form>
    </main>
    <footer class="container-fluid bg-4 text-center">
        <p>MyFlashCard.com <a href="https://www.w3schools.com">MyFlashCard.com</a></p> 
    </footer>
</body>
</html>
