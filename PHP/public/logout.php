<?php
session_start();
session_destroy();
header('Location: ../forms/login.php');
exit;
?>