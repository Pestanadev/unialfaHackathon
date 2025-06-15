-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/06/2025 às 20:59
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `hackathon`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `evento`
--

CREATE TABLE `evento` (
  `cod` int(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `valor` varchar(20) DEFAULT NULL,
  `urlImg` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  `palestrante` varchar(100) DEFAULT NULL,
  `organizacao` varchar(100) DEFAULT NULL,
  `patrocinador` varchar(100) DEFAULT NULL,
  `modalidade` varchar(50) DEFAULT NULL,
  `data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `evento`
--

INSERT INTO `evento` (`cod`, `nome`, `valor`, `urlImg`, `endereco`, `descricao`, `palestrante`, `organizacao`, `patrocinador`, `modalidade`, `data`) VALUES
(1, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(2, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(3, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(4, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(5, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(6, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(7, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(8, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(9, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11'),
(10, 'Vestibular de Inverno', 'Gratuito', 'https://imgur.com/a/vC5Nl2E.png', 'Av Paraná 7327, Umuarama, PR, 87502-000 ', 'O Vestibular de Inverno da UniALFA está com inscrições abertas, e essa pode ser a oportunidade que vai dar o start na sua trajetória acadêmica. Aqui na instituição, você conta com um ensino de qualidade, infraestrutura moderna e um corpo docente altamente qualificado, comprometido com o seu desenvolvimento pessoal e profissional.', 'Fernando', 'UniAlfa', 'ecodedigital', 'Concurso', '2025-07-11');
--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`cod`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `evento`
--
ALTER TABLE `evento`
  MODIFY `cod` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;