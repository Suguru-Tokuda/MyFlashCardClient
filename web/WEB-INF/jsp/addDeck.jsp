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
        </style>
    </head>

    <body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">MyFlashCard</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
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
    
    <main role="main" class="container">
        
        <div class="col-md-6">
            <div class="form-grup">
                <p>Class list:</p>
                <select class="form-control" id="classList">
                    <c:forEach var="schoolClass" items="schoolClassList">
                        <option>${schoolClass.classnumber} ${schoolClass.classname}</option>
                    </c:forEach>
                </select>
                <span style="margin-top: 50px;"/>
                <p>Not in the list? Add it.</p>
                <div class="row">
                    <label class="control-label">Class Number:</label>
                    <input type="text" name="classnumber" />
                </div>
                <div class="row">
                    <label class="control-label">Class Name:</label>
                    <input type="text" name="classname" />
                </div>
            </div>            
        </div>
        <div class="col-md-6">
            
            
        </div>

    </main>


    <footer class="container-fluid bg-4 text-center">
        <p>Bootstrap Theme Made By <a href="https://www.w3schools.com">www.w3schools.com</a></p> 
    </footer>


</body>
</html>
