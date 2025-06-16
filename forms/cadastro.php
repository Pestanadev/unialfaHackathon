<?php
require_once '../classes/ApiComNode.php';
session_start();
if (empty($_SESSION['token'])) {
    // Não está logado, redireciona para login
    header('Location: ../forms/login.php');
    exit;
}

$api = new ApiComNode();
$eventos = $api->getEventos();

$cod = $_GET['cod'] ?? null;
$eventoSelecionado = null;

// Busca pelo evento
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
    <title>Cadastro no Evento</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="../style/cadastro.css">
</head>

<body>
    <?php include '../templates/header.php'; ?>
    <div class="evento-bg-topo"></div>
    <div class="centraliza-tudo">
        <div class="evento-box-white">
            <div class="evento-info text-center">
                <?php if (!empty($eventoSelecionado['urlImg'])): ?>
                    <div class="evento-bg-topo"
                        style="background: url('<?= htmlspecialchars($eventoSelecionado['urlImg']) ?>') center center/cover no-repeat; filter: blur(6px) brightness(0.85);">
                    </div>
                <?php endif; ?>
                <h1><?= htmlspecialchars($eventoSelecionado['nome']) ?></h1>
                <div class="evento-detalhes d-flex justify-content-left gap-1 flex-wrap mb-2">
                    <span class="evento-det">
                        <span class="evento-icon">
                            <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                <rect x="3" y="7" width="18" height="14" rx="2" stroke="#0e76a8" stroke-width="2" />
                                <path d="M16 3v4M8 3v4" stroke="#0e76a8" stroke-width="2" />
                                <path d="M3 11h18" stroke="#0e76a8" stroke-width="2" />
                            </svg>
                        </span>
                        <?= date('d/m/Y', strtotime($eventoSelecionado['data'])) ?>
                    </span>
                    <span class="evento-det">
                        <span class="evento-icon">
                            <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                <path d="M12 21c4.418 0 8-4.477 8-10a8 8 0 1 0-16 0c0 5.523 3.582 10 8 10Z" stroke="#0e76a8" stroke-width="2" />
                                <circle cx="12" cy="11" r="3" stroke="#0e76a8" stroke-width="2" />
                            </svg>
                        </span>
                        <?= htmlspecialchars($eventoSelecionado['endereco']) ?>
                    </span>
                    <?php if (!empty($eventoSelecionado['modalidade'])): ?>
                        <span class="evento-det">
                            <span class="evento-icon">
                                <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                    <circle cx="12" cy="12" r="9" stroke="#0e76a8" stroke-width="2" />
                                    <path d="M12 7v5l4 2" stroke="#0e76a8" stroke-width="2" />
                                </svg>
                            </span>
                            <?= htmlspecialchars($eventoSelecionado['modalidade']) ?>
                        </span>
                    <?php endif; ?>
                </div>
                <p><strong>Descrição:</strong> <?= htmlspecialchars($eventoSelecionado['descricao']) ?></p>
                <p><strong>Palestrante:</strong> <?= htmlspecialchars($eventoSelecionado['palestrante']) ?></p>
                <p><strong>Organização:</strong> <?= htmlspecialchars($eventoSelecionado['organizacao']) ?></p>
                <p><strong>Patrocinador:</strong> <?= htmlspecialchars($eventoSelecionado['patrocinador']) ?></p>
                <p><strong>Valor:</strong> <?= htmlspecialchars($eventoSelecionado['valor']) ?></p>
            </div>
        </div>
        <div class="form-box-white">
            <form class="form-area" id="evento-form" method="POST" action="../public/evento_cadastro.php" autocomplete="off">
                <input type="hidden" name="cod" value="<?= htmlspecialchars($eventoSelecionado['cod']) ?>">
                <img src="../style/img/logo.png" alt="logo" class="logo-form">
                <h2>Inscreva-se no Evento</h2>
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" placeholder="Nome: " required>

                <label for="email">E-mail</label>
                <input type="email" id="email" name="email" placeholder="Email: " required>

                <label for="cep">CEP</label>
                <input type="text" id="cep" name="cep" required pattern="\d{5}-?\d{3}" placeholder="Ex: 00000-000">

                <label for="estado">Estado</label>
                <input type="text" id="estado" name="estado" placeholder="Estado: " required>

                <label for="cidade">Cidade</label>
                <input type="text" id="cidade" name="cidade" placeholder="Cidade: " required>

                <label for="bairro">Bairro</label>
                <input type="text" id="bairro" name="bairro" placeholder="Bairro: " required>

                <label for="logradouro">Logradouro</label>
                <input type="text" id="logradouro" name="logradouro" placeholder="Logradouro: " required>

                <div class="termos-box">
                    <label for="cidade">Termos de Responsabilidade</label>
                    <div class="termos-texto" tabindex="0">
                        Ao se inscrever neste Evento, você declara estar de acordo com o nosso Código de Conduta.<br>
                        Declaro que li e aceito os Termos de Uso e a Política de Privacidade.
                        Autorizo, de forma livre e informada, o uso dos meus dados pela Artmed e pelas empresas do grupo para o envio de comunicações sobre produtos, serviços e novidades. Estou ciente de que posso revogar esta autorização a qualquer momento.
                    </div>
                    <div class="termos-checkbox">
                        <input type="checkbox" id="aceito-termos" name="aceito-termos" required>
                        <label for="aceito-termos">Li e concordo com os termos acima</label>
                    </div>
                </div>

                <button type="submit">Inscrever-se</button>
            </form>
        </div>
    </div>

</body>

</html>