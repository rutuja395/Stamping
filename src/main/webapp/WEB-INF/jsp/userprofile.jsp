<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>


<html>
	<head>
		<title>Your Profile</title>
		      <link rel="stylesheet" href="resources/css/style.css">

		 <meta name="viewport" content="width=device-width, initial-scale=1">
      	<link rel="stylesheet" href="resources/css/style.css">
		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"> 
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	</head>
	<body class="bg2">
          <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top scrolling-navbar">
                <a class="navbar-brand" href="#"><img src="../resources/images/logo.png" alt="logo" ><span class="apptitle">Stamping</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  <div class="collapse navbar-collapse" id="navbarNav">
				    <ul class="navbar-nav">
				      <li class="nav-item active">
				        <a class="nav-link" href="profile">Profile <span class="sr-only">(current)</span></a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="friends">Friends</a>
				      </li>
				    </ul>
				  </div>
            </nav>
            
<!-- 		    <div class="bg" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/background.jpg'),linear-gradient(to bottom, #e6e6e6,#f2f2f2 ); background-repeat: no-repeat; background-size: cover; background-position: center center; ">
 -->			<br>
            <br>
         <div class="container">
			<div class="row panel">
		        <div class="col-md-8  col-xs-12">
		          <img  class="profilepicture" src="${imgsrc}" alt="Profile Page Picture" />
		           <div class="header">
		                <h2>${username}</h2>
		                <h4>${userdes}</h4>
		                
		<h3>Public Link:</h3><h4><a href="${imgsrc}">${imgsrc}</a></h4>
		           </div>
		        </div>
		    </div>   
		 </div>
		 
<!-- 		 </div>
 -->		 
		 

	</body>
</html>