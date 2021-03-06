<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	
    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
        $(function () {
            $('a').each(function () {
                var inner = $(this).height();
                var outer = $('header').height();
                $(this).css({
                    'padding-top': (outer - inner)/2,
                    'padding-bottom': (outer - inner)/2
                });
            });
            $("#searchLink").on("click", function() {
            	window.location.href = "./search/" + $("#query").val();
            });
            $("#searchBar").css({
      			'float': 'right',
      			'padding-top': 15
            });
        });
    </script>
</head>
<body>
<header>
	<div class="topnav">
		<nav class="menu">
			<a href=".">Główna</a>
			<a href="./add">Dodaj</a>
			<a href="./random">Losowy</a>			
			<span class="searchBar" id="searchBar"><input type="text" value="" name="query" id="query"/><button id="searchLink">Szukaj</button></a></span>
		</nav>
	</div>
</header>
	<c:forEach items="${memeList}" var="item">
		<div class="meme">
			<div class="titleSection">
				<a href="details/${item.id }"><span class="memeTitle">${item.title }</span></a>
				<span class="memeAuthor">Autor: ${item.author }</span>
			</div>
			<div class="memeContent">
				<img class="memeImg" src="${item.imgLink}"/>
				<div class="memeInfo">
					${item.content}
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>
