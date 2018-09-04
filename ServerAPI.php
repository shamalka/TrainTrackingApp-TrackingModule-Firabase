<?php
//Host Name
$host = "localhost";
//User Name
$username = "root";
//Database Password
$pwd = "";
//Database Name
$db = "railwayappdb";

$con = mysqli_connect($host,$username,$pwd,$db) or die("Unable to connect");

if(mysqli_connect_error($con)){
	echo "Failed to connect";
}

$query = mysqli_query($con,"SELECT * FROM trains");

if($query){
	while($row=mysqli_fetch_array($query)){
		$flag[]=$row;
	}
	print(json_encode($flag));
}

mysqli_close($con);
?>