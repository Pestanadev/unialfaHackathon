<?php
session_start();

require_once '../classes/ApiComNode.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  $email = $_POST['email'] ?? '';
  $senha = $_POST['senha'] ?? '';


  $url = 'http://localhost:3001/login';
  $data = [
    'email' => $email,
    'senha' => $senha
  ];

  $api = new ApiComNode();
  $response = $api->login($email, $senha);

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
      <form class="form-area" id="login-form" method="POST" action="">
        <img src="../style/img/logowhite.png" alt="logo" class="logo-form">
        <h2>Acesse sua conta</h2>
        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" required>
        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" required>
        <button type="submit">Entrar</button>
        <div class="form-footer">
          <span>Caso não tenha uma conta: <a href="../forms/criarUser.php">criar
              conta</a></span>
        </div>
      </form>

    </div>

    <div class="login-right">
      <div class="image-bg"></div>
      <img src="../style/img/even_unialfaLogo.png" alt="Logo" class="logo-overlay">
    </div>
  </div>
</body>

</html>
