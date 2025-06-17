<?php
session_start();
require_once '../classes/ApiComNode.php';
// Só permite acesso se estiver logado (tem aluno na sessão)
if (empty($_SESSION['aluno'])) {
    header('Location: ../forms/login.php');
    exit;
}

$email = $_SESSION['aluno']['email'];
$api = new ApiComNode();
$meusEventos = $api->getInscricoesPorEmail($email);
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meus Eventos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../style/style.css">
</head>

<body>
    <?php include '../templates/header.php'; ?>
    <div class="container my-5">
        <h2 class="mb-4">Meus Eventos</h2>
        <?php if (empty($meusEventos)): ?>
            <p>Você ainda não está inscrito em nenhum evento.</p>
        <?php else: ?>
            <div class="row g-4">
                <?php foreach ($meusEventos as $evento): ?>
                    <div class="col-md-4">
                        <div class="card h-100">
                            <img src="<?= htmlspecialchars($evento['urlImg']) ?>" class="card-img-top" alt="Foto do evento">
                            <h1><?= htmlspecialchars($evento['nome']) ?></h1>
                            <div class="evento-detalhes d-flex justify-content-left gap-1 flex-wrap mb-2">
                                <span class="evento-det">
                                    <?= date('d/m/Y', strtotime($evento['data'])) ?>
                                </span>
                                <span class="evento-det">
                                    <?= htmlspecialchars($evento['endereco']) ?>
                                </span>
                                <?php if (!empty($evento['modalidade'])): ?>
                                    <span class="evento-det">
                                        <?= htmlspecialchars($evento['modalidade']) ?>
                                    </span>
                                <?php endif; ?>
                            </div>
                        </div>
                    </div>
                <?php endforeach; ?>
            </div>
        <?php endif; ?>
    </div>
    <?php include '../templates/footer.php'; ?>
</body>

</html>