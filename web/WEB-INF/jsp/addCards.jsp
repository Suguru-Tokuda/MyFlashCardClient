<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        </style>
    </head>

    <body>
    <nav class="navbar navbar-inverse bg-primary">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">MyFlashCard</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="#">Page 1</a></li>
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
    <main>
        <div class="container">
            <div class="col-md-6">
                <div class="row">
                    <h2>Card List</h2> <h4>Deck Name: ${deck.deckname}</h4>
                    <h5>${classnumber}: ${classname}</h5>
                </div>
                <table class="table table-striped">
                    <tr>
                        <th>#</th>
                        <th>Question</th>
                        <th>Answer</th>
                        <th>Delete</th>
                    </tr>
                    <form method="get">
                        <c:set var="index" value="0" scope="page" />
                        <c:forEach var="card" items="${cardList}">
                            <tr>
                                <td>${card.priority}</td>
                                <td>${card.question}</td>
                                <td>${card.answer}</td>
                                <td><input type="submit" value="Delete" class="btn btn-default" name="index" formaction="${pageContext.request.contextPath}/removeCard//${index}"></input></td>
                            </tr>
                            <c:set var="index" value="${index + 1}" scope="page"/>
                        </c:forEach>
                    </form>
                </table>
            </div>
            <div class="col-md-6">
                <form method="post">
                    <div class="form-group">
                        <h3>Question</h3>
                        <textarea class="form-control" cols="100" rows="10" name="question" style="resize: none;"></textarea>
                    </div>
                    <div class="form-group">
                        <h3>Answer</h3>
                        <textarea class="form-control" cols="100" rows="10" name="answer" style="resize: none;"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/doAddCard" value="Add Card" />
                        <input type="submit" class="btn btn-danger" formaction="${pageContext.request.contextPath}/finalizeDeck" value="Finalize Your Deck" />
                        <label class="control-label danger" style="color: red;">${message}</label>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <footer class="container-fluid bg-4 text-center">
        <p>MyFlashCard.com <a href="https://www.w3schools.com">MyFlashCard.com</a></p> 
    </footer>
</body>
</html>
