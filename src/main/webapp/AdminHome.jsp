<%@page import="java.util.Base64"%>
<%@page import="dto.Movie_DTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<style>

table,th,td{
border: 2px solid black;
text-align: center;
border-collapse: collapse;
}

table{
width:100.3%;
}
th{
padding: 20px;
color:red;
font-size: 20px;
background-color: skyblue;
}
td{
font-size: 20px;
}

#nav{
border: 2px solid black;
height:100px;
display: flex;
gap:250px;
width:100%;
border-bottom: none;
}
#title{
font-size: 40px;
margin-left: 500px;
}
#button{
margin-top: 35px;
padding: 15px;
border: 1.5px solid green;
font-size:18px;
text-transform:capitalize;
border-radius: 10px;
width:150px;
}
#button:hover{
background-color: black;
color:white;
transform:scale(1.1);
transition:0.3s;
}
#title1{
position: relative;
font-size: 40px;
margin-left: -227px;

}
.para::first-letter {
	font-size: 50px;
	color: red;
}

#delete{
border: 1px solid green;
width:80px;
padding: 5px;
}

#delete:hover {
background-color: black;
color:white;
transform:scale(1.1);
transition:0.2s;
border-radius: 10px;	
}
#button2{
width:150px;
position:absolute; 
right:30px;
margin-top: 35px;
padding: 15px;
border: 1.5px solid green;
font-size:18px;
text-transform:capitalize;
border-radius: 10px;
}

#button2:hover{
background-color: black;
color:white;
transform:scale(1.1);
transition:0.3s;
}

</style>

</head>
<body>

<nav id="nav">
<p id="title" class="para">MOVIE</p> <p id="title1" class="para">LIST</p>
<a href="AddMovie.jsp" target="_self"><input type="button" value="add Movie" id="button"></a>
<a href="AddMovie.jsp" target="_self"><input type="button" value="profile" id="button2"></a>
</nav>

<% List<Movie_DTO> movie = (List)request.getAttribute("movies"); %>

<table id="table">
<tbody>
<tr>
<th>Movie Id</th>
<th>Movie Name</th>
<th>Movie Price</th>
<th>Movie Rating</th>
<th>Movie Genre</th>
<th>Movie Language</th>
<th>Movie Image</th>
<th>Delete</th>
<th>Update</th>
</tr>

<% for(Movie_DTO movies : movie) { %>

<tr>
<td><%= movies.getMovieId() %></td>
<td><%= movies.getMovieName() %></td>
<td><%= movies.getMovieCost() %></td>
<td><%= movies.getMovieRating() %></td>
<td><%= movies.getMovieGeneral() %></td>
<td><%= movies.getMovieLanguage() %></td>

<% String image = Base64.getEncoder().encodeToString(movies.getMovieImage()); %>
<td><img alt="" src="data:image/jpeg;base64,<%= image %>" height="100px" width="100px"></td>
<td><a href="DeleteAdmin?id=<%= movies.getMovieId()%>"><input type="button" value="Delete" id="delete"></a></td>
<td><a href="UpdateAdmin?id=<%= movies.getMovieId()%>"><input type="button" value="Update" id="delete"></a></td>
</tr>
<%} %>


</tbody>
</table> <br><br>


</body>
</html>