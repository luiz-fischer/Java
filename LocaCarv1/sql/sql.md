-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 01/03/2021 às 01:00
-- Versão do servidor: 10.4.17-MariaDB
-- Versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `LocaCar`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluguel`
--

CREATE TABLE `aluguel` (
  `idAluguel` int(10) UNSIGNED NOT NULL,
  `idCliente` int(10) UNSIGNED NOT NULL,
  `data_da_locacao` varchar(16) DEFAULT NULL,
  `data_da_devolucao` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `aluguel`
--

INSERT INTO `aluguel` (`idAluguel`, `idCliente`, `data_da_locacao`, `data_da_devolucao`) VALUES
(1, 1, '20/02/2021', '02/03/2021'),
(2, 1, '27/02/2021', '10/03/2021'),
(3, 1, '10/10/2020', '15/10/2020');

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(10) UNSIGNED NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `data_de_nascimento` varchar(16) DEFAULT NULL,
  `qtd_dias` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `nome`, `cpf`, `data_de_nascimento`, `qtd_dias`) VALUES
(1, 'Luiz', '2222', '1999/10/10', NULL),
(2, 'Raul José', '123.456.789-0', '1999/10/10', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `idVeiculo` int(10) UNSIGNED NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `valor_diaria` double DEFAULT NULL,
  `veiculo_idVeiculo` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura para tabela `veiculosAlugados`
--

CREATE TABLE `veiculosAlugados` (
  `idVeiculosAlugados` int(10) UNSIGNED NOT NULL,
  `idAluguel` int(10) UNSIGNED DEFAULT NULL,
  `idVeiculoLeve` int(10) UNSIGNED DEFAULT NULL,
  `idVeiculoPesado` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `veiculosAlugados`
--

INSERT INTO `veiculosAlugados` (`idVeiculosAlugados`, `idAluguel`, `idVeiculoLeve`, `idVeiculoPesado`) VALUES
(1, 1, 1, NULL),
(2, 2, NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `veiculo_leve`
--

CREATE TABLE `veiculo_leve` (
  `idVeiculoLeve` int(10) UNSIGNED NOT NULL,
  `marca` varchar(40) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `ano` int(10) UNSIGNED DEFAULT NULL,
  `valor_diaria` double UNSIGNED DEFAULT NULL,
  `cor` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `veiculo_leve`
--

INSERT INTO `veiculo_leve` (`idVeiculoLeve`, `marca`, `modelo`, `ano`, `valor_diaria`, `cor`) VALUES
(1, 'Ford', 'Fiesta', 1999, 100.32, 'Prata');

-- --------------------------------------------------------

--
-- Estrutura para tabela `veiculo_pesado`
--

CREATE TABLE `veiculo_pesado` (
  `idVeiculoPesado` int(10) UNSIGNED NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `ano` int(10) UNSIGNED DEFAULT NULL,
  `valor_diaria` double UNSIGNED DEFAULT NULL,
  `restricao` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `veiculo_pesado`
--

INSERT INTO `veiculo_pesado` (`idVeiculoPesado`, `marca`, `modelo`, `ano`, `valor_diaria`, `restricao`) VALUES
(1, 'Volvo', 'Scania V8', 2020, 5045.56, 'CATEGORIA AD ');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD PRIMARY KEY (`idAluguel`),
  ADD UNIQUE KEY `IdAluguel_UNIQUE` (`idAluguel`),
  ADD KEY `fk_aluguel_cliente1_idx` (`idCliente`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`),
  ADD UNIQUE KEY `IdCliente_UNIQUE` (`IdCliente`);

--
-- Índices de tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`idVeiculo`),
  ADD UNIQUE KEY `idVeiculo_UNIQUE` (`idVeiculo`),
  ADD KEY `fk_veiculo_veiculo1_idx` (`veiculo_idVeiculo`);

--
-- Índices de tabela `veiculosAlugados`
--
ALTER TABLE `veiculosAlugados`
  ADD PRIMARY KEY (`idVeiculosAlugados`),
  ADD UNIQUE KEY `IdVeiculosAlugados_UNIQUE` (`idVeiculosAlugados`),
  ADD KEY `fk_veiculosAlugados_aluguel1_idx` (`idAluguel`),
  ADD KEY `fk_veiculosAlugados_veiculo_leve1_idx` (`idVeiculoLeve`),
  ADD KEY `fk_veiculosAlugados_veiculo_pesado1_idx` (`idVeiculoPesado`);

--
-- Índices de tabela `veiculo_leve`
--
ALTER TABLE `veiculo_leve`
  ADD PRIMARY KEY (`idVeiculoLeve`),
  ADD UNIQUE KEY `IdVeiculoLeve_UNIQUE` (`idVeiculoLeve`);

--
-- Índices de tabela `veiculo_pesado`
--
ALTER TABLE `veiculo_pesado`
  ADD PRIMARY KEY (`idVeiculoPesado`),
  ADD UNIQUE KEY `idVeiculoPesado_UNIQUE` (`idVeiculoPesado`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluguel`
--
ALTER TABLE `aluguel`
  MODIFY `idAluguel` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `idVeiculo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `veiculosAlugados`
--
ALTER TABLE `veiculosAlugados`
  MODIFY `idVeiculosAlugados` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `veiculo_leve`
--
ALTER TABLE `veiculo_leve`
  MODIFY `idVeiculoLeve` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `veiculo_pesado`
--
ALTER TABLE `veiculo_pesado`
  MODIFY `idVeiculoPesado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `aluguel`
--
ALTER TABLE `aluguel`
  ADD CONSTRAINT `fk_aluguel_cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `veiculo`
--
ALTER TABLE `veiculo`
  ADD CONSTRAINT `fk_veiculo_veiculo1` FOREIGN KEY (`veiculo_idVeiculo`) REFERENCES `veiculo` (`idVeiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `veiculosAlugados`
--
ALTER TABLE `veiculosAlugados`
  ADD CONSTRAINT `fk_veiculosAlugados_aluguel1` FOREIGN KEY (`idAluguel`) REFERENCES `aluguel` (`IdAluguel`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_veiculosAlugados_veiculo_leve1` FOREIGN KEY (`IdVeiculoLeve`) REFERENCES `veiculo_leve` (`IdVeiculoLeve`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_veiculosAlugados_veiculo_pesado1` FOREIGN KEY (`idVeiculoPesado`) REFERENCES `veiculo_pesado` (`idVeiculoPesado`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;