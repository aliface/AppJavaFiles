<?php
    $con = mysqli_connect("localhost", "rucharged", "v95st1aliface", "id1831064_rucharged");
    
    $Username = $_POST["Username"];
    $Password = $_POST["Password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM rucharged WHERE Username = ? AND Password = ?");
    mysqli_stmt_bind_param($statement, "ss", $Username, $Password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $Full_Name, $Username, $Password, $Car_Type, $License_Plate, $Email);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["Full_name"] = $Full_Name;
        $response["Username"] = $Username;
        $response["Password"] = $Password;
        $response["Car_Type"] = $Car_Type;
        $response["License_Plate"] = $License_place;
        $response["Email"] = $Email;
        
    }
    
    echo json_encode($response);
?>
