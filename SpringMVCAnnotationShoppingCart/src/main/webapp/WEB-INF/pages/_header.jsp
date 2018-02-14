<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


  <div class="site-name">Online Shop</div>
 
    <div class="header-bar">
 <nav class="nav"><c:if test="${pageContext.request.userPrincipal.name != null}">
        Hello
        </c:if>
  <a class="nav-link active" href="${pageContext.request.contextPath}/accountInfo">${pageContext.request.userPrincipal.name} </a>
 &nbsp;|&nbsp;
  <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
   <c:if test="${pageContext.request.userPrincipal.name == null}">
   <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
</c:if>

</nav>
   </div>
 