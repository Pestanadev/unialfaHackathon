<?php
session_start();

require_once '../classes/ApiComNode.php';

$codEvento = $_POST['cod'] ?? '';
$nome = $_POST['nome'] ?? '';
$email = $_POST['email'] ?? '';
$cep = $_POST['cep'] ?? '';
$estado = $_POST['estado'] ?? '';
$cidade = $_POST['cidade'] ?? '';
$bairro = $_POST['bairro'] ?? '';
$logradouro = $_POST['logradouro'] ?? '';

// Aqui você pode obter o id do usuário logado, se tiver autenticação por login
//$alunoId = $_SESSION['id'] ?? null;

$api = new ApiComNode();

$dados = [
    //'aluno_id' => $alunoId, // Se você tiver, envie o id do aluno logado
    'evento_id' => (int)$codEvento,
    'nome'      => $nome,
    'email'     => $email,
    'cep'       => $cep,
    'estado'    => $estado,
    'cidade'    => $cidade,
    'bairro'    => $bairro,
    'logradouro' => $logradouro
];

// Altere o método da ApiComNode para encaixar com o endpoint correto
$resultado = $api->inscreverUsuario($dados);

if (!empty($resultado['erro'])) {
    echo 'Erro ao inscrever: ' . htmlspecialchars($resultado['erro']);
    exit;
}

// Coloque o email na sessão para filtrar depois (ou id, se for o caso)
$_SESSION['email'] = $email;

// Redireciona para MeusEventos
header('Location: ../public/MeusEventos.php');
exit;
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
                                    <span class="evento-icon">
                                        <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                            <rect x="3" y="7" width="18" height="14" rx="2" stroke="#0e76a8" stroke-width="2" />
                                            <path d="M16 3v4M8 3v4" stroke="#0e76a8" stroke-width="2" />
                                            <path d="M3 11h18" stroke="#0e76a8" stroke-width="2" />
                                        </svg>
                                    </span>
                                    <?= date('d/m/Y', strtotime($evento['data'])) ?>
                                </span>
                                <span class="evento-det">
                                    <span class="evento-icon">
                                        <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                            <path d="M12 21c4.418 0 8-4.477 8-10a8 8 0 1 0-16 0c0 5.523 3.582 10 8 10Z" stroke="#0e76a8" stroke-width="2" />
                                            <circle cx="12" cy="11" r="3" stroke="#0e76a8" stroke-width="2" />
                                        </svg>
                                    </span>
                                    <?= htmlspecialchars($evento['endereco']) ?>
                                </span>
                                <?php if (!empty($evento['modalidade'])): ?>
                                    <span class="evento-det">
                                        <span class="evento-icon">
                                            <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                                <circle cx="12" cy="12" r="9" stroke="#0e76a8" stroke-width="2" />
                                                <path d="M12 7v5l4 2" stroke="#0e76a8" stroke-width="2" />
                                            </svg>
                                        </span>
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