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
                <a href="#eventos" class="btn-ver-eventos">Ver Eventos</a>
            </div>
            <img src="../style/img/banner1.png" alt="banner1" class="top-banner">
        </div>

        <div class="card" style="width: 16rem;">
            <img src="..." class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card’s content.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
        </div>
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

        <?php include '../templates/footer.php'; ?>
    </div>
</body>

</html>