<?php

$host = "127.0.0.1"; 
$port = 1234; 
$message = "Mensaje para el servidor"."\n"; 

$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("No se pudo crear el socket\n");

$result = socket_connect($socket, $host, $port) or die("No se pudo conectar con el servidor\n"); 

socket_write($socket, $message, strlen($message)) or die("No se pudo enviar datos al servidor\n"); 

$result = socket_read ($socket, 1024) or die("No se pudo leer la respuesta del servidor\n"); 
echo "El servidor dice :<br>".$result; 
socket_close($socket); 

?>

