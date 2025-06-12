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
}