<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to FAMediazoto Tracks Project</title>
<style type="text/css">
    body {margin: 2em;}
    .yellow {color: #000088;background: #FFFF00;}
    .imp {font-weight: bold; color: #CC0000;}
</style>
</head>

<body>
Welcome to FAMediazoto Album Project<p/>
<c:forEach items="${albums}" var="album">
 	<table border="1">
	<tr class="yellow"><td>Id</td><td>${album.id}</td></tr>
	<tr><td>Title</td><td>${album.title}</td></tr> 
	<tr><td>Artist</td><td>id: ${album.artist.id} stageName: ${album.artist.stageName}</td></tr>
	<tr><td>Genre</td><td>${album.genre.genre}</td></tr>
	<tr><td>Tracks</td><td>${album.tracks}</td></tr>
	<tr><td><a href="<c:url value="/deleteAlbum.form"><c:param name="id" value="${album.id}"/></c:url>">Delete Album</a></td><td><a href="<c:url value="/loadAlbum.form"><c:param name="id" value="${album.id}"/></c:url>">Update</a></td></tr>
</table><br/>
</c:forEach>
  <a href="<c:url value="/insertAlbum.jsp"/>">Crea</a>
</body>
</html>