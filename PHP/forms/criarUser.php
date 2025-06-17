<?php
session_start();

require_once '../classes/ApiComNode.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['register-name'] ?? '';
    $email = $_POST['register-email'] ?? '';
    $telefone = $_POST['register-phone'] ?? '';
    $senha = $_POST['register-password'] ?? '';

    $api = new ApiComNode();
    $dados = [
        'nome' => $nome,
        'email' => $email,
        'telefone' => $telefone,
        'senha' => $senha
    ];

    $response = $api->inscreverUsuario($dados);
    header( 'Location: ../forms/login.php');
    exit;
}
?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title class="h2Login">Acesse sua conta</title>
    <link rel="stylesheet" href="../style/form.css">
</head>

<body>
    <div class="login-container">
        <div class="login-left" id="login-left">

            <form class="form-area"  method="POST" action="">
                <img src="../style/img/logowhite.png" alt="logo" class="logo-form">
                <h2>Criar conta</h2>
                <label for="register-name">Nome</label>
                <input type="text" id="register-name" name="register-name" required>
                <label for="register-email">E-mail</label>
                <input type="email" id="register-email" name="register-email" required>
                <label for="register-phone">Telefone</label>
                <input type="tel" id="register-phone" name="register-phone" required>
                <label for="register-password">Senha</label>
                <input type="password" id="register-password" name="register-password" required>
                <button type="submit">Confirmar</button>
                <div class="form-footer">
                    <span>Já possui conta? <a href="../forms/login.php" id="show-login">Entrar</a></span>
                </div>
            </form>
        </div>

        <div class="login-right">
            <div class="image-bg"></div>
            <img src="../style/img/even_unialfaLogo.png" alt="Logo" class="logo-overlay">
        </div>
    </div>
