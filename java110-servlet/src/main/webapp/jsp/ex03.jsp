<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% //스크립트릿: 자바 코드를 두는 태그
int a;
%>
<head>
<meta charset="UTF-8">
<title>JSP 구동 원리</title>
</head>
<body>
<%
a = 100;
int b = a++;
%>
<h1>스크립트릿(scriptlet)</h1>
<pre>
- JSP 파일에 안에 작성하는 자바 코드이다.
    &lt;% 자바코드 %>
- 자바코드:
   스크립트릿 태그 안에 작성한 자바코드는  _jspService() 안에 그대로 복사된다.
</pre>

<%
out.println("<p>a=" + a + "</p>");
out.println("<p>b=" + b + "</p>");
%>

</body>
</html>