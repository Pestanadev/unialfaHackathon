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
            <div class="evento-info">
                <h1>Nome do Evento</h1>
                <div class="evento-detalhes">
                    <span class="evento-det">
                        <span class="evento-icon">
                            <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                <rect x="3" y="7" width="18" height="14" rx="2" stroke="#0e76a8" stroke-width="2" />
                                <path d="M16 3v4M8 3v4" stroke="#0e76a8" stroke-width="2" />
                                <path d="M3 11h18" stroke="#0e76a8" stroke-width="2" />
                            </svg>
                        </span>
                        20/07/2025
                    </span>
                    <span class="evento-det">
                        <span class="evento-icon">
                            <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                <path d="M12 21c4.418 0 8-4.477 8-10a8 8 0 1 0-16 0c0 5.523 3.582 10 8 10Z" stroke="#0e76a8" stroke-width="2" />
                                <circle cx="12" cy="11" r="3" stroke="#0e76a8" stroke-width="2" />
                            </svg>
                        </span>
                        Centro de Convenções
                    </span>
                    <span class="evento-det">
                        <span class="evento-icon">
                            <svg width="20" height="20" viewBox="0 0 24 24" fill="none">
                                <circle cx="12" cy="12" r="9" stroke="#0e76a8" stroke-width="2" />
                                <path d="M12 7v5l4 2" stroke="#0e76a8" stroke-width="2" />
                            </svg>
                        </span>
                        19h
                    </span>
                </div>
                <p>Descrição: Participe do maior evento de tecnologia do ano! Inscreva-se abaixo para garantir sua vaga.</p>
            </div>
        </div>
        <div class="form-box-white">
            <form class="form-area" id="evento-form" method="POST" action="../public/evento_cadastro.php" autocomplete="off">
                <img src="../style/img//logo.png" alt="logo" class="logo-form">
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

                <button type="submit">Inscrever-se</button>
            </form>
        </div>
    </div>

</body>

</html>