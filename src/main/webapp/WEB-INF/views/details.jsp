<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
	
	body {
	  margin:0px;
	  position:static;
	  left:auto;
	  text-align:left;
	  width: 100%;
	}
	
	.meme {
	    color: black;
	    border: solid;
	    margin:100px auto;
	    width: 50%;
	}
	.titleSection{
		margin: 20px;
		border: solid;
		width: 30%;
		display: inline-block;
    	position: relative;
	}
	.titleSection span{
		display:block;
		text-align: center;
	}
	
	.memeContent {
		
		margin: auto;
		text-align: center
	}
	
	.memeImg{
		margin: 20px;
	}
	
	.memeInfo{
		margin: 20px;
	}
	</style>
</head>
<body>
		<div id="errors">
			${errorMessage}
		</div>
		<div class="meme">
			<div class="titleSection">
				<span class="memeTitle">${meme.title }</span>
				<span class="memeAuthor">Autor: ${meme.author }</span>
			</div>
			<div class="memeContent">
				<img class="memeImg" src="http://aos-static-files.americanorchidso.netdna-cdn.com/img/menu-icon.svg" width="50" height="50"/>
				<div class="memeInfo">
					<p>${meme.content}</p>
					<p>${meme.details}</p>
				</div>
			</div>
		</div>
		
		

</body>
</html>
