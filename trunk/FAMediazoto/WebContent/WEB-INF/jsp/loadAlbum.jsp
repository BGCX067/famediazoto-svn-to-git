<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAMediazoto Project</title>
    </head>

    <body>
        <h1>Album Update </h1>
        <form action="<c:url value="/updateAlbum.form"/>" method="POST">
            Title:<input type="text" name="title" value="${album.title}"/><br/>
            Artist id:<input type="text" name="yr" value="${album.artist.id}"/><br/>
            Genre: <input type="text" name="length" value="${album.genre.genre}"/><br/>
            Image:<br>
            Tracks<br>
           <input type="hidden" name="id" value="${album.id}"/><br/>
            <input type="submit" name="update" value="Update"/>
        </form>
    </body>
</html>