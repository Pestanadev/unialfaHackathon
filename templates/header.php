<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary fixed-top">
        <div class="container-fluid">
            <img src="../style/img/logo.png" id="logo" alt="logo">

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../public/index.php">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../public/listar.php">Eventos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../public/MeusEventos.php">Meus Eventos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../public/certificados.php">Meus Certificados</a>
                    </li>
                    <?php
                    // Remover session_start() daqui!
                    if (!empty($_SESSION['aluno'])):
                        $nome = explode(' ', $_SESSION['aluno']['nome'])[0];
                    ?>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <?= htmlspecialchars($nome) ?>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end">
                                <li><a class="dropdown-item" href="../forms/editar_perfil.php">Editar informações</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="../public/logout.php">Sair</a></li>
                            </ul>
                        </li>
                    <?php else: ?>
                        <li class="nav-item">
                            <a class="nav-link" href="../forms/login.php">Eu</a>
                        </li>
                    <?php endif; ?>
                </ul>
            </div>
        </div>
    </nav>
</header>