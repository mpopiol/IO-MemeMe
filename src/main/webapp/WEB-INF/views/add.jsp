<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
  <button type="submit" class="btn btn-default">Dodaj</button>
</form:form>

</body>
</html>