<?xml version="1.0" encoding="UTF-8"?><%--
 --%><%@page contentType="text/xml" pageEncoding="UTF-8"%><%--
 --%><%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
 --%><%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <artists>
        <c:forEach items="${artists}" var="artist">
            <artist id="${artist.id}">
            	<name>${artist.name}</name>
            	<lastName>${artist.lastname}</lastName> 
            	<birthDate>${artist.birthDate}</birthDate>       	
            </artist> 
        </c:forEach>
        </artists>
