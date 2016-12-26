	<?php

if($_SERVER["REQUEST_METHOD"]=="POST"){
	
	include 'connect.php';

	checkUser($_POST['email'],$_POST['password']);


}
function checkUser($email,$password)
  {
    global $connect;
    $query="select * FROM user  WHERE  password ='$password' and Email ='$email'";
 	
	$result = mysqli_query($connect, $query);
	$number_of_rows = mysqli_num_rows($result);
	
	$temp_array  = array();
	
	if($number_of_rows > 0) {
		while ($row = mysqli_fetch_assoc($result)) {
			$temp_array[] = $row;
			
		}
	}
	if (count($temp_array)==0) {
		$s="0";
		# code...
	}
	else{$s="1";}
	
	header('Content-Type: application/json');
	echo json_encode($s);
	mysqli_close($connect);
	
}
   
 


?>


