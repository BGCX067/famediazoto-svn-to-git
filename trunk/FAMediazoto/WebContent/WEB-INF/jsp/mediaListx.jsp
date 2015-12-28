<?xml version="1.0" encoding="UTF-8"?><%--
 --%><%@page contentType="text/xml" pageEncoding="UTF-8"%><%--
 --%><%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
 --%><%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <medias>
        <c:forEach items="${media}" var="media">
            <media id="${media.id}">
            	<title>${media.title}</title>
            	<yr>${media.yr}</yr>            	       	
            </media> 
        </c:forEach>
        </medias>
