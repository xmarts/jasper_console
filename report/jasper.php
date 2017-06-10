<?php


$type=$_GET["type"];
$id=$_GET["id"];
$file=$type."-".$id.".pdf";

//echo "java -cp Jasper.jar Jasper ".$type." ".$id." \"jdbc:mysql://localhost/provin_test\" root mysql2014!  ";
//exec("java -cp Jasper.jar Jasper ".$type." ".$id." \"jdbc:mysql://localhost/provin_test\" provin_root mysql2012   ");
//exec("java -cp Jasper.jar Jasper ".$type." ".$id." \"jdbc:mysql://localhost/provin_test\" root XserviceMysql!   ");
exec("java -cp Jasper.jar Jasper ".$type." ".$id." \"jdbc:mysql://localhost/provincrm\" root 1ntegranetMatam0r0sbernard0   ");
//echo "java -cp Jasper.jar Jasper ".$type." ".$id." \"jdbc:mysql://10.7.45.22/alonso_provincrm\" alonso_provincrm XserviceMysql!  ";
//echo "java -cp Jasper.jar Jasper ".$type." ".$id." \"jdbc:mysql://localhost/provincrm\" root 1ntegranetMatam0r0sbernard0   "


header('Content-type: application/pdf');
header('Content-Disposition: attachment; filename="'.$file.'"');
readfile("report/pdf/".$file);




?>
