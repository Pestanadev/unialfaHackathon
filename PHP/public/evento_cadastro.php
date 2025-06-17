<?php
session_start();
if (empty($_SESSION['aluno'])) {
    header('Location: ../forms/login.php');
    exit;
}
require_once '../classes/ApiComNode.php';

// Pegue os dados só de $_SESSION['aluno'] e do POST (cep, endereço, etc)
$aluno = $_SESSION['aluno'];
$codEvento = $_POST['cod'] ?? '';
$cep = $_POST['cep'] ?? '';
$estado = $_POST['estado'] ?? '';
$cidade = $_POST['cidade'] ?? '';
$bairro = $_POST['bairro'] ?? '';
$logradouro = $_POST['logradouro'] ?? '';
$aceito_termos = isset($_POST['aceito-termos']) ? true : false;

$dados = [
    'evento_id' => (int)$codEvento,
    'nome'      => $aluno['nome'],
    'email'     => $aluno['email'],
    'cep'       => $cep,
    'estado'    => $estado,
    'cidade'    => $cidade,
    'bairro'    => $bairro,
    'logradouro' => $logradouro,
    'aceito_termos' => $aceito_termos
];

$api = new ApiComNode();
$resultado = $api->inscreverUsuario($dados);

if (isset($resultado['erro'])) {
    echo 'Erro ao inscrever: ' . htmlspecialchars($resultado['erro']);
    exit;
}

header('Location: ../public/MeusEventos.php');
exit;
