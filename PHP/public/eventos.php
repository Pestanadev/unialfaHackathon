<?php
session_start();
if (empty($_SESSION['aluno'])) {
    header('Location: ../forms/login.php');
    exit;
}
require_once '../classes/ApiComNode.php';

$api = new ApiComNode();
$eventos = $api->getEventos();

// Pegando o cod da URL
$cod = $_GET['cod'] ?? null;
$eventoSelecionado = null;

// Buscando o evento com o código correspondente
foreach ($eventos as $evento) {
    if ($evento['cod'] == $cod) {
        $eventoSelecionado = $evento;
        break;
    }
}

if (!$eventoSelecionado) {
?>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Evento não encontrado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../style/style.css">
    </head>

    <body>
        <?php include '../templates/header.php'; ?>
        <div class="evento-erro-container">
            <div class="evento-erro-card">
                <img src="https://cdn-icons-png.flaticon.com/512/4076/4076549.png" alt="Nenhum evento encontrado">
                <h2>Evento não encontrado</h2>
                <p>Não encontramos o evento que você procura.<br>
                    Verifique se o nome está correto ou veja a lista de eventos disponíveis.</p>
                <a href="../public/listar.php" class="btn btn-primary">Ver todos os eventos</a>
            </div>
        </div>
        <?php include '../templates/footer.php'; ?>
    </body>

    </html>
<?php
    exit;
}
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes do Evento</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../style/style.css">
</head>

<body>
    <div class="container mt-5 text-dark">
        <?php include '../templates/header.php'; ?>

        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="p-4 border rounded bg-light">
                    <div class="mb-3 text-center">
                        <img src="<?= htmlspecialchars($eventoSelecionado['urlImg']) ?>" alt="Imagem do evento"
                            class="img-fluid" style="max-height: 300px;">
                    </div>
                    <h3 class="text-center"><?= htmlspecialchars($eventoSelecionado['nome']) ?></h3>
                    <p><strong>Código:</strong> <?= htmlspecialchars($eventoSelecionado['cod']) ?></p>
                    <p><strong>Descrição:</strong> <?= htmlspecialchars($eventoSelecionado['descricao']) ?></p>
                    <p><strong>Valor:</strong> <?= htmlspecialchars($eventoSelecionado['valor']) ?></p>
                    <p><strong>Endereço:</strong> <?= htmlspecialchars($eventoSelecionado['endereco']) ?></p>
                    <p><strong>Palestrante:</strong> <?= htmlspecialchars($eventoSelecionado['palestrante']) ?></p>
                    <p><strong>Organização:</strong> <?= htmlspecialchars($eventoSelecionado['organizacao']) ?></p>
                    <p><strong>Patrocinador:</strong> <?= htmlspecialchars($eventoSelecionado['patrocinador']) ?></p>
                    <p><strong>Modalidade:</strong> <?= htmlspecialchars($eventoSelecionado['modalidade']) ?></p>
                    <p><strong>Data:</strong> <?= date('d/m/Y', strtotime($eventoSelecionado['data'])) ?></p>

                    <div class="text-center mt-4">
                        <a href="listar.php" class="btn btn-secondary">Voltar</a>
                    </div>
                    <div class="text-center mt-3">
                        <a href="inscricao.php?cod=<?= urlencode($eventoSelecionado['cod']) ?>"
                            class="btn btn-success">
                            Inscreva-se
                        </a>

                    </div>
                </div>
            </div>
        </div>

        <?php include '../templates/footer.php'; ?>
    </div>
</body>

</html>