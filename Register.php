<?php
    $con = mysqli_connect("localhost", "rucharged", "v95st1aliface", "id1831064_rucharged");
    
    $Full_Name = $_POST["Full_Name"];
    $Username = $_POST["Username"];
    $Password = $_POST["Password"];
    $Car_Type = $_POST["Car_Type"];
    $License_Plate = $_POST["License_Plate"];
    $Email = $_POST["Email"];
    
    
    $statement = mysqli_prepare($con, "INSERT INTO rucharged (Full_Name, Username, Password, Car_Type, License_Plate, Email) VALUES (?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "siss", $Full_Name, $Username, $Password, $Car_Type, $License_Plate, $Email);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
