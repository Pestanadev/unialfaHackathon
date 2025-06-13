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
    $url = $this->baseUrl . '/alunos';

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

}