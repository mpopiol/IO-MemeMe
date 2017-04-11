<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
	.meme {
	    color: blue;
	}
	.memeAuthor {
		color: red;
	}
	.memeTitle {
		color: yellow;
	}
	</style>
</head>
<body>
<c:forEach items="${memeList}" var="item">
	<div class="meme">
		<div class="titleSection">
			<span class="memeTitle">${item.title }</span>
			<span class="memeAuthor">Autor: ${item.author }</span>
		</div>
		<div class="memeContent">
			${item.content}
		</div>
	</div>
</c:forEach>
</body>
</html>
