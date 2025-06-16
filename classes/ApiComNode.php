<?php

class ApiComNode
{
    private string $baseUrl;

    public function __construct()
    {
        $this->baseUrl = 'http://localhost:3001';
    }
    public function getEventos()
    {
        $url = $this->baseUrl . '/evento';

        $curl = curl_init($url);
        curl_setopt_array($curl, [
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_TIMEOUT => 10,
            CURLOPT_HTTPHEADER => [
                'Accept: application/json',
                'User-Agent: PHP-Eventos-App'
            ]
        ]);

        $response = curl_exec($curl);
        curl_close($curl);

        if (!$response) {
            return [];
        }

        return json_decode($response, true);
    }
    public function inscreverUsuario($dados)
    {
        $url = $this->baseUrl . '/alunos/cadastrar';

        $curl = curl_init($url);

        curl_setopt_array($curl, [
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_TIMEOUT => 10,
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => json_encode($dados),
            CURLOPT_HTTPHEADER => [
                'Accept: application/json',
                'Content-Type: application/json',
                'User-Agent: PHP-Eventos-App'
            ]
        ]);

        $response = curl_exec($curl);
        curl_close($curl);

        if (!$response) {
            return false;
        }

        return json_decode($response, true);
    }
    public function login($email, $senha)
    {
        $url = $this->baseUrl . '/login';

        $data = [
            'email' => $email,
            'senha' => $senha
        ];

        $curl = curl_init($url);
        curl_setopt_array($curl, [
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_TIMEOUT => 10,
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => json_encode($data),
            CURLOPT_HTTPHEADER => [
                'Accept: application/json',
                'Content-Type: application/json',
                'User-Agent: PHP-Eventos-App'
            ]
        ]);

        $response = curl_exec($curl);
        curl_close($curl);

        if (!$response) {
            return false;
        }

        return json_decode($response, true);

    }
    public function editar($dados){
        $url = $this->baseUrl . '/alunos/editar/' . $_SESSION['aluno']['id'];

        $curl = curl_init($url);

        curl_setopt_array($curl, [
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_TIMEOUT => 10,
            CURLOPT_POST => true,
            CURLOPT_POSTFIELDS => json_encode($dados),
            CURLOPT_HTTPHEADER => [
                'Accept: application/json',
                'Content-Type: application/json',
                'User-Agent: PHP-Eventos-App'
            ]
        ]);

        $response = curl_exec($curl);
        $http = curl_getinfo($curl, CURLINFO_HTTP_CODE);

        curl_close($curl);

        if (!$response) {
            return false;
        }

       return in_array($http, [200, 201]) ? json_decode($response, true) : null;
    }
}