### Link para o Github - https://github.com/Leosagara/Global-Solution.git

## INTEGRANTES
- Ayslan Garcia – responsável pela implementação de API’s e auxílio na parte de projetos;
- Leonardo Sagara – responsável pelo desenvolvimento back-end e auxílio na parte de projetos;
- Matheus Oliveira – responsável pela integração Cloud do sistema, desenvolvimento da lógica de machine learning e auxílio na parte de projetos;
- Paulo Maldonado – responsável pelo desenvolvimento da interface gráfica e auxílio na parte de projetos;
- Pedro Kokuba – responsável pela criação do banco de dados e sua lógica e auxílio na parte de projetos.

## Problema
Muitas vezes as pessoas deixam de fazer exames regulares, por subestimá-los ou por falta de informação, o que pode gerar diagnósticos tardios e consequentemente menos eficazes.

## Solução
Pensando nisso a aplicação tem como objetivo através de inteligência artificial, analisar uma série de requisitos disponibilizados pelo usuário, para assim recomendar exames e com que frequência devem ser feitos, buscando tornar este acesso mais fácil e rápido para aumentar a eficácia dos tratamentos.

## Escopo do Projeto
### Objetivo principal
Melhorar a disponibilidade de exames tornando-os mais rápidos e fáceis, para aumentar  a eficácia de tratamentos.

### Descrição do produto
Plataforma online que através de requisitos passados pelo paciente, consiga, utilizando inteligência artificial, prescrever exames médicos e com que frequência devem ser feitos.

### Requisitos
- Permitir aos usuários inserir informações sobre seus sintomas, histórico médico, idade e gênero;
- Utilizar algoritmos de aprendizado de máquina para analisar dados e identificar padrões relacionados a sintomas e recomendações de exames;
- Gerar recomendações personalizadas de exames com base nas características únicas de cada usuário.

### Entregáveis
- Protótipo Funcional da Plataforma de Predição de Exames;
- Documentação Técnica Detalhada;
- Relatório de Testes e Validação.

## O que ficará fora do escopo
O projeto não incluirá a prestação de serviços médicos ou consultas diretas aos usuários.
Não serão adicionados novos dados ao modelo do Machine Learning.
A plataforma não terá a capacidade de prescrever medicamentos.


## Teconologias utilizadas
- Linguagem de programção - Java 18;
- Frameworks - Springboot 3.1.5, Hibernate 3;
- Fornt-end - React 18;
- Banco de dados: Oracle database 19.0.0;
- Controle de Versão - Git;
- Serviços de Cloud - Docker 4.25.2.

## Como utilizar]
Abra o prjeto em uma IDE de sua preferência e coloque a classe Main para rodar, iniciada a aplicação abra no navegador: localhost:8082/client. Estando na interface escolher entre adicionar usuário e gerar formulário (o envio de ambos resulta no armazenamento dos respectivos objetos no banco de dados). Caso escolha gerar um formulário basta preencher com seus dados e clicar em enviar para obter sua resposta.

## Diagrama de classes
<img width="728" alt="Captura de Tela (172)" src="https://github.com/Leosagara/Global-Solution/assets/75694982/23adb2de-60f8-4e3d-b970-04c5aad12339">




