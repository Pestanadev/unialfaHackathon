<?php
session_start();

// Recebe os dados do formulário
$codEvento = $_POST['cod'] ?? '';
$nome = $_POST['nome'] ?? '';
$email = $_POST['email'] ?? '';
$cep = $_POST['cep'] ?? '';
$estado = $_POST['estado'] ?? '';
$cidade = $_POST['cidade'] ?? '';
$bairro = $_POST['bairro'] ?? '';
$logradouro = $_POST['logradouro'] ?? '';

// Carrega inscrições já existentes
$inscricoesFile = __DIR__ . '/../data/inscricoes.json';
if (!file_exists($inscricoesFile)) {
    file_put_contents($inscricoesFile, '[]');
}
$inscricoes = json_decode(file_get_contents($inscricoesFile), true);

// Salva a inscrição associada ao email do usuário
$novaInscricao = [
    'codEvento' => $codEvento,
    'nome' => $nome,
    'email' => $email,
    'cep' => $cep,
    'estado' => $estado,
    'cidade' => $cidade,
    'bairro' => $bairro,
    'logradouro' => $logradouro,
    'dataInscricao' => date('Y-m-d H:i:s')
];
$inscricoes[] = $novaInscricao;

// Salva de volta no arquivo
file_put_contents($inscricoesFile, json_encode($inscricoes, JSON_PRETTY_PRINT));

// Salva email do usuário na sessão para identificar depois
$_SESSION['email'] = $email;

// Redireciona para MeusEventos
header('Location: ../public/MeusEventos.php');
exit;
?>