<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
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
	
	
	<style>
	
body header {
    top: 0;
	width: 100%;
	height: 50px;  
	background: rgb(64,0,64);  
	box-shadow: 2px 3px 4px rgb(51,51,51);
	position: fixed;
    overflow: hidden;
}


body .topnav a {
      float: left;
      display: block;
      color: white;
      padding-left: 10px;
      padding-right: 10px;
      text-decoration: none;
      font-size: 18px;
      text-align: center;
      width: 90px; 
      
}
      
body .topnav a:hover {
      background-color: rgb(40,0,40);
      color: white; 
}



body {
	  margin:0px;
	  position:static;
	  left:auto;
	  text-align:left;
	  width: 100%;
	  color: white;
	  font-size: 18px;
	  background: rgb(95,95,95);
}
	
	.meme {
	 
	    border: solid rgb(51,51,51);
	    margin:100px auto;
	    width: 50%;
	    background: rgb(51,51,51); 
	}
	.titleSection{
		margin: 20px;
		border: solid rgb(51,51,51);
		width: 30%;
		display: inline-block;
    		}
	.titleSection span{
		display:block;
		text-align: center;
	}
	
	.memeTitle{
		font-weight: bold;
	}
	
	.memeAuthor{
		font-size: 12px;
		font-style: italic;
	}
	
	.memeContent {
		
		margin: auto;
		text-align: center
	}
	
	.memeImg{
		margin: auto;
		max-width: 90%;
	}
	
	.memeInfo{
		margin: 20px;
	}
	</style>
</head>
<body>

<header>
	<div class="topnav">
		<nav class="menu">
			<a href=".">Główna</a>
			<a href="add">Dodaj</a>
			<a href="random">Losowy</a>
			<span class="searchBar" id="searchBar"><input type="text" value="" name="query" id="query"/><button id="searchLink">Szukaj</button></a></span>
		</nav>
	</div>
</header>
	<div class="meme">
		<div class="titleSection">
			<span class="memeTitle">${meme.title }</span>
			<span class="memeAuthor">Autor: ${meme.author }</span>
		</div>
		<div class="memeContent">
			<img class="memeImg" src="${meme.imgLink}"/>
			<div class="memeInfo">
				<p>${meme.content}</p>
				<p>${meme.details}</p>
			</div>
		</div>
	</div>
</body>
</html>
