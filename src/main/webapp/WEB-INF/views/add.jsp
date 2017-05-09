<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>Dodaj</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

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

.form-group {
	 
	    border: solid rgb(51,51,51);
	    margin: auto;
	    width: 50%;
	    background: rgb(51,51,51); 
	}
	
	.formularz{
		width: 100%;
		margin: 100px auto;
		background: rgb(51,51,51);
	}
	
	.but{
		margin: 10px auto;
		text-align: center;
		
	}
</style>

</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<header>
	<div class="topnav">
		<nav class="menu">
			<nav class="menu">
			<a href=".">Główna</a>
			<a href="add">Dodaj</a>
			<a href="random">Losowy</a>
		</nav>
		</nav>
	</div>
</header>

<div class="formularz">
	<form:form method="POST" action="/mvc/add" modelAttribute="meme">
	  <div class="form-group">
	    <form:label path="title">Tytul:</form:label>
	    <form:input path="title" class="form-control" />
	  </div>
	  <div class="form-group">
	    <form:label path="content">Krotki opis:</form:label>
	    <form:input path="content" class="form-control" />
	  </div>
	  <div class="form-group">
	    <form:label path="imgLink">Link obrazka:</form:label>
	    <form:input path="imgLink" class="form-control" />
	  </div>
	  <div class="form-group">
	    <form:label path="details">Szczegoly:</form:label>
	    <form:input path="details" class="form-control" />
	  </div>
	  <div class="form-group">
	    <form:label path="author">Twoj podpis:</form:label>
	    <form:input path="author" class="form-control" />
	  </div>
	  <div class="but">
	  <button type="submit" class="btn btn-default">Dodaj</button>
	  </div>
	</form:form>
</div>

</body>
</html>