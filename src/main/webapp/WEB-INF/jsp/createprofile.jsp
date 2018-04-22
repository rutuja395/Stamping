<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Create Profile</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="resources/css/style.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	</head>
<body>
	<nav class="navbar navbar-light bg-light fixed-top scrolling-navbar">
    	<a class="navbar-brand" href="#"><img src="../resources/images/logo.png" alt="logo" ><span class="apptitle">Stamping</span></a>
    </nav>
    <div class="cont">
    <div class="bg" style="background-image: url('../resources/images/bg1.jpg'),linear-gradient(to bottom, #e6e6e6,#f2f2f2 ); background-repeat: no-repeat; background-size: cover; background-position: center center; ">
    	<h1>Welcome, ${username}!</h1>
    	<h2>Create Your Profile</h2>
    	<br>
    	<form action="/upload" class="uploadform"  method="post" enctype="multipart/form-data">
                <div class="form-group">
				    <label for="exampleFormControlFile1">Upload Profile Picture</label>
				    <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
				  </div>
<!--                 <input type="file" name="file">
 -->                <br>
 				 <div class="form-group">
				    <label >Enter your Description</label>
				    <textarea class="form-control" id="textform" rows="2" name="myDescription"></textarea>
				 </div>
                <!-- <div class="form-group">
                <input type="text" name="myDescription">
                </div>  -->
                <br>
                <input type="submit" class="btn btn-success">
            </form>
            </div>
    </div>
    

</body>
</html>