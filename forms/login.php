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
      <form class="form-area" id="login-form" method="POST" action="../public/index.php">
        <img src="../style/img/logowhite.png" alt="logo" class="logo-form">
        <h2>Acesse sua conta</h2>
        <label for="login-email">E-mail</label>
        <input type="email" id="login-email" name="login-email" required>
        <label for="login-password">Senha</label>
        <input type="password" id="login-password" name="login-password" required>
        <button type="submit" formaction="../public/index.php">Entrar</button>
        <div class="form-footer">
          <span>Caso não tenha uma conta: <a href="../forms/login.php" id="show-register">criar conta</a></span>
        </div>
      </form>

      <form class="form-area" id="register-form" style="display:none;" method="POST" action="../public/index.php">
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
        <button type="submit" formaction="../public/index.php">Confirmar</button>
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

  <script>
    document.getElementById('show-register').onclick = function(e){
      e.preventDefault();
      document.getElementById('login-form').style.display = 'none';
      document.getElementById('register-form').style.display = 'flex';
    };
    document.getElementById('show-login').onclick = function(e){
      e.preventDefault();
      document.getElementById('register-form').style.display = 'none';
      document.getElementById('login-form').style.display = 'flex';
    };
  </script>
</body>
</html>