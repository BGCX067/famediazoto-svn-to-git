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
        <h1>Update Track </h1>
        <form action="<c:url value="/updateTrack.form"/>" method="POST">
            Title<input type="text" name="title" value="${track.title}"/><br/>
            year<input type="text" name="yr" value="${track.yr}"/><br/>
            length<input type="text" name="length" value="${track.length}"/><br/>
           <input type="hidden" name="id" value="${track.id}"/><br/>
            <input type="submit" name="update" value="Update"/>
        </form>
    </body>
</html>