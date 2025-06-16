<?php
session_start();

require_once '../classes/ApiComNode.php';

$api = new ApiComNode();
$eventos = $api->getEventos();

$emailUsuario = $_SESSION['email'] ?? null;
if (!$emailUsuario) {
    echo "<p>Você precisa se cadastrar em algum evento para visualizar esta página.</p>";
    exit;
}

// Carrega inscrições salvas
$inscricoesFile = __DIR__ . '/../data/inscricoes.json';
$inscricoes = [];
if (file_exists($inscricoesFile)) {
    $conteudo = file_get_contents($inscricoesFile);
    $inscricoes = json_decode($conteudo, true);
    if (!is_array($inscricoes)) {
        $inscricoes = [];
    }
}

$meusEventosCod = [];
foreach ($inscricoes as $inscricao) {
    if ($inscricao['email'] === $emailUsuario) {
        $meusEventosCod[] = $inscricao['codEvento'];
    }
}

// Filtra os eventos que o usuário está inscrito
$meusEventos = array_filter($eventos, function ($evento) use ($meusEventosCod) {
    return in_array($evento['cod'], $meusEventosCod);
});
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
                            <div class="card-body">
                                <h5 class="card-title"><?= htmlspecialchars($evento['nome']) ?></h5>
                                <p class="card-text"><strong>Descrição:</strong> <?= htmlspecialchars($evento['descricao']) ?></p>
                            </div>
                            <div class="card-footer text-center">
                                <a href="eventos.php?cod=<?= urlencode($evento['cod']) ?>" class="btn btn-primary">Ver detalhes</a>
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