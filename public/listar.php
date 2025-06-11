<?php
    require_once 'classes/ApiComNode.php';

    $api = new PostApiService();
    $usuarios = $api->getPosts(); // agora é sua API própria que retorna usuários
?>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="icon" href="data:,">
    <link rel="stylesheet" href="../style/style.css">
</head>

<body>
    <div class="centralizado">
        <?php include '../templates/header.php'; ?>

        <div class="card" style="width: 23rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <?php foreach($usuarios as $usuario): ?>
                    <div class="card">
                        <h2><?= htmlspecialchars($usuario['nome']) ?></h2>
                        <p><strong>Email:</strong> <?= htmlspecialchars($usuario['email']) ?></p>
                    </div>
                <?php endforeach; ?>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        </div>
    </div>
    <?php include '../templates/footer.php'; ?>
</body>

</html>