<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to FAMediazoto Project</title>
</head>

<body>
Artist Listing<p/>
<c:forEach items="${artists}" var="artists">
ID: ${artists.id} | Surname: ${artists.lastname} | Name : ${artists.name} | Stage Name: ${artists.stageName} ||<a href="<c:url value="/deleteArtist.form"><c:param name="id" value="${artists.id}"/></c:url>">Kill the Artist</a>  || <a href="<c:url value="/loadArtist.form"><c:param name="id" value="${artists.id}"/></c:url>">Update</a><br>
</c:forEach>

</body>
</html>