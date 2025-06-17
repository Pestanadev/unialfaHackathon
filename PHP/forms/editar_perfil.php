<?php
session_start();

require_once '../classes/ApiComNode.php';

if (!isset($_SESSION['token'])) {
    die("Voce precisa estar logado para acessar esta pagina ");
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nome = $_POST['editar-name'] ?? '';
    $email = $_POST['editar-email'] ?? '';
    $telefone = $_POST['editar-phone'] ?? '';
    $senha = $_POST['editar-password'] ?? '';

    $api = new ApiComNode();
    $dados = [
        'nome' => $nome,
        'email' => $email,
        'telefone' => $telefone,
        'senha' => $senha
    ];

    $response = $api->editar($dados);
    header('Location: ../public/index.php');
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

            <form class="form-area" method="POST" action="">
                <img src="../style/img/logowhite.png" alt="logo" class="logo-form">
                <h2>Editar perfil</h2>
                <label for="editar-name">Nome</label>
                <input type="text" id="editar-name" name="editar-name" value="" required>
                <label for="editar-email">E-mail</label>
                <input type="email" id="editar-email" name="editar-email" required>
                <label for="editar-phone">Telefone</label>
                <input type="tel" id="editar-phone" name="editar-phone" required>
                <label for="editar-password">Senha</label>
                <input type="password" id="editar-password" name="editar-password" required>
                <button type="submit">Confirmar</button>
                <div class="form-footer">
                    <span>Voltar? <a href="../public/index.php" id="show-login">Voltar</a></span>
                </div>
            </form>
        </div>

        <div class="login-right">
            <div class="image-bg"></div>
            <img src="../style/img/even_unialfaLogo.png" alt="Logo" class="logo-overlay">
        </div>
    </div>