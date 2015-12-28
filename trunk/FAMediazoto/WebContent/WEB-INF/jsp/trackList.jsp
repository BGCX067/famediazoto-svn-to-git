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
<h1>Track list of FAMediazoto</h1>
<c:forEach items="${tracks}" var="track">
	<table border="1">
		<tr class="yellow"><td>Id</td><td>${track.id}</td></tr>
		<tr><td>Title</td><td>${track.title}</td></tr>
		<tr><td>year</td><td>${track.yr}</td></tr>
		<tr><td>length</td><td>${track.length}</td></tr>
		<tr><td>Artist name</td><td>${track.artist.name}</td></tr>
		<tr><td>Artist lastname</td><td>${track.artist.lastname}</td></tr>
		<tr><td>Stage name</td><td>${track.artist.stageName}</td></tr>
		<tr><td>Genre</td><td>${track.genre.genre}</td></tr>
		<tr><td>Lyrics</td><td><a href="">Click here to see the lyrics</td></tr>
		<tr><td><a href="<c:url value="/deleteTrack.form"><c:param name="id" value="${track.id}"/></c:url>">Delete Track</a></td><td><a href="<c:url value="/loadTrack.form"><c:param name="id" value="${track.id}"/></c:url>">Update</a></td></tr>
		</table><br/>	
</c:forEach>
		<a href="<c:url value="/insertTrack.jsp"/>">Crea</a><br>
		cosa serve sta immagine qua???<br>
		Picture: <img src="/faml/images/Morak.jpg" width="150" >
</body>
</html>