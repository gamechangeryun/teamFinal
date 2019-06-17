<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
<header>
	<tiles:insertAttribute name="header" />
	<hr />
</header>

<nav>
	<tiles:insertAttribute name="nav" />
</nav>

<section>
<article>
	<tiles:insertAttribute name="body" />
</article>
</section>

	
	<hr />
<footer>
	<tiles:insertAttribute name="footer" />
</footer>
</body>
</html>