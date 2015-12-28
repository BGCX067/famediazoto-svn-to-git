<?xml version="1.0" encoding="UTF-8"?><%--
 --%><%@page contentType="text/xml" pageEncoding="UTF-8"%><%--
 --%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%--
 --%><%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<albums> <c:forEach items="${albums}" var="album">
	
		<album id="${album.id}">
			<title>${album.title}</title>
			<artist id="${album.artist.id}"/>
			<genre>${album.genre.genre}</genre>
			<tracks>
				<c:forEach items="${album.tracks}" var="track">
				<track id="${track.id}" />
				</c:forEach>
			</tracks>
		</album>
	
</c:forEach> </albums>
