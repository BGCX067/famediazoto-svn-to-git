<?xml version="1.0" encoding="UTF-8"?><%--
 --%><%@page contentType="text/xml" pageEncoding="UTF-8"%><%--
 --%><%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
 --%><%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <tracks>
        <c:forEach items="${tracks}" var="track">
            <track id="${track.id}">
            	<title>${track.title}</title>
            	<length>${track.length}</length>
            	
            	<artist id="${track.artist.id}"/>
            	<yr>${track.yr}</yr>
            	<genre>${track.genre.genre}</genre>
            	<lyrics>${track.lyrics}</lyrics>              	
            </track> 
        </c:forEach>
        </tracks>
