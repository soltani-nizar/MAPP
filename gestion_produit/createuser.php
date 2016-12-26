<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
	require 'connect.php';
	createuser();
}


function createuser()
{
	global $connect;
	
	$nom_user = $_POST["nom_user"];	
	$Email = $_POST["Email"];
	$password = $_POST["password"];
	
	$query = " Insert into user(nom_user,Email,password) values ('$nom_user','$Email','$password');";
	
	mysqli_query($connect, $query) or die (mysqli_error($connect));
	mysqli_close($connect);
	
}








?>

