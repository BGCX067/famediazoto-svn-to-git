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
        <h1>Update Person </h1>
        <form action="<c:url value="/updateArtist.form"/>" method="POST">
            Name<input type="text" name="name" value="${artists.name}"/><br/>
            LastName<input type="text" name="lastname" value="${artists.lastname}"/><br/>
            StageName<input type="text" name="stageName" value="${artists.stageName}"/><br/>
            Birth Date<input type="text" name="brithDate" value=""/><br/>
            Photo<br/>
            <input type="hidden" name="id" value="${artists.id}"/><br/>
            <input type="submit" name="update" value="Update"/>
        </form>
    </body>
</html>