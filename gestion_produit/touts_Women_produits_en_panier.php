<?php
if($_SERVER["REQUEST_METHOD"]=="GET"){
    require 'connect.php';
    global $connect;
  
    //fetch table rows from mysql db
    $sql = "select * from article where article.categorie='Women'";
    $result = mysqli_query($connect, $sql) or die("Error in Selecting " . mysqli_error($connect));

    //create an array
    $article = array();
    while($row =mysqli_fetch_assoc($result))
    {
        $article[] = $row;
    }
    echo json_encode(array('Women' => $article));

    //close the db connection
    mysqli_close($connect);
}
?>