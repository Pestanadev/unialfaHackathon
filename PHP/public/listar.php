<?php
session_start();
if (empty($_SESSION['aluno'])) {
    header('Location: ../forms/login.php');
    exit;
}
require_once '../classes/ApiComNode.php';

$api = new ApiComNode();
$eventos = $api->getEventos();

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuários</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="icon" href="data:,">
    <link rel="stylesheet" href="../style/style.css">
</head>

<body>
    <div class="container my-5">
        <?php include '../templates/header.php'; ?>

        <div class="row g-4">
            <?php foreach ($eventos as $eventos): ?>
                <div class="col-md-4">
                    <div class="card h-100">
                        <img src="<?= htmlspecialchars($eventos['urlImg']) ?>" class="card-img-top" alt="Foto do evento">
                        <div class="card-body">
                            <h5 class="card-title"><?= htmlspecialchars($eventos['nome']) ?></h5>
                            <p class="card-text"><strong>descrição:</strong> <?= htmlspecialchars($eventos['descricao']) ?></p>
                        </div>
                        <div class="card-footer text-center">
                            <a href="eventos.php?cod=<?= urlencode($eventos['cod']) ?>" class="btn btn-primary">Ver mais</a>


                        </div>
                    </div>
                </div>
            <?php endforeach; ?>
        </div>


        <?php include '../templates/footer.php'; ?>
    </div>
</body>

</html>