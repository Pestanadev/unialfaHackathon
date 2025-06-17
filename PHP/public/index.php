<?php
session_start();
require_once '../classes/ApiComNode.php';
$api = new ApiComNode();
$eventos = $api->getEventos();

function agruparPorCategoria($eventos)
{
    $agrupados = [];
    foreach ($eventos as $evento) {
        $cat = $evento['modalidade'] ?? 'Outros';
        $agrupados[$cat][] = $evento;
    }
    return $agrupados;
}
$eventosPorCategoria = agruparPorCategoria($eventos);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EventFlow</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="icon" href="data:,">
    <link rel="stylesheet" href="../style/style.css">
    
</head>

<body>
    <div class="centralizado">
        <?php include '../templates/header.php'; ?>

        <div class="banner-container">
            <div class="banner-text">
                <h1 class="banner-title">Descubra seu Próximo Evento</h1>
                <p class="banner-desc">Venha participar de uma experiência única! Participe dos nossos Eventos.</p>
                <a href="../public/listar.php" class="btn-ver-eventos">Ver Eventos</a>
            </div>
            <img src="../style/img/banner1.png" alt="banner1" class="top-banner">
        </div>

        <?php foreach ($eventosPorCategoria as $categoria => $eventosCategoria): ?>
            <h3 class="mt-5"><?= htmlspecialchars($categoria) ?></h3>
            <div class="draggable-wrapper mb-4 py-2">
                <?php foreach (array_slice($eventosCategoria, 0, 12) as $evento): ?>
                    <div class="card event-card h-100">
                        <img src="<?= htmlspecialchars($evento['urlImg']) ?>" class="card-img-top" alt="Imagem do evento">
                        <div class="card-body">
                            <h5 class="card-title"><?= htmlspecialchars($evento['nome']) ?></h5>
                            <p class="card-text"><?= htmlspecialchars($evento['descricao']) ?></p>
                        </div>
                        <div class="card-footer text-center">
                            <a href="eventos.php?cod=<?= urlencode($evento['cod']) ?>" class="btn btn-primary">Ver mais</a>
                        </div>
                    </div>
                <?php endforeach; ?>
            </div>
        <?php endforeach; ?>

        <div class="col-md-6" id="divMaps">
            <iframe
                src="https://www.google.com/maps/embed/v1/place?q=Av.%20Paran%C3%A1,%207327%20-%20Zona%20III,%20Umuarama%20-%20PR,%2087502-000&key=AIzaSyCLzO0N2NyOSOwEoHxHl1SZ6osym2fHlkE"
                width="100%"
                height="400"
                frameborder="0"
                style="border:0;"
                allowfullscreen>
            </iframe>
        </div>
    </div>
    <?php include '../templates/footer.php'; ?>

    <script>
        // Função para tornar o wrapper arrastável com mouse/touch
        document.querySelectorAll('.draggable-wrapper').forEach(function(wrapper) {
            let isDown = false;
            let startX;
            let scrollLeft;

            wrapper.addEventListener('mousedown', function(e) {
                isDown = true;
                wrapper.classList.add('active');
                startX = e.pageX - wrapper.offsetLeft;
                scrollLeft = wrapper.scrollLeft;
            });
            wrapper.addEventListener('mouseleave', function() {
                isDown = false;
                wrapper.classList.remove('active');
            });
            wrapper.addEventListener('mouseup', function() {
                isDown = false;
                wrapper.classList.remove('active');
            });
            wrapper.addEventListener('mousemove', function(e) {
                if (!isDown) return;
                e.preventDefault();
                const x = e.pageX - wrapper.offsetLeft;
                const walk = (x - startX) * 2; // scroll-fast
                wrapper.scrollLeft = scrollLeft - walk;
            });

            // Touch events para mobile
            let touchStartX = 0;
            let touchScrollLeft = 0;
            wrapper.addEventListener('touchstart', function(e) {
                isDown = true;
                touchStartX = e.touches[0].pageX;
                touchScrollLeft = wrapper.scrollLeft;
            });
            wrapper.addEventListener('touchend', function() {
                isDown = false;
            });
            wrapper.addEventListener('touchmove', function(e) {
                if (!isDown) return;
                const x = e.touches[0].pageX;
                const walk = (x - touchStartX) * 2;
                wrapper.scrollLeft = touchScrollLeft - walk;
            });
        });
    </script>
</body>

</html>