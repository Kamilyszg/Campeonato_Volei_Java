## Gerenciador de Campeonato de Vôlei
Este é um projeto de console desenvolvido em Java com foco na aplicação de conceitos de Programação Orientada a Objetos (POO). O sistema permite a gestão de um campeonato de vôlei, incluindo a criação de times, registro de jogadores, registro de partidas e a geração de um ranking.

### Recursos Principais
- Gestão de Times: Adicionar e gerenciar times que participam do campeonato.
- Gestão de Jogadores: Adicionar jogadores a cada time, com validação para evitar a duplicação de números de camisa.
- Registro de Partidas: Registrar os resultados das partidas por sets e atualizar automaticamente a pontuação dos times.
- Geração de Ranking: Gerar uma classificação dos times com base na pontuação obtida.
- Listagem de Jogadores: Listar os jogadores de um time específico, incluindo a informação do técnico.

### Design Orientado a Objetos (POO)
O projeto foi estruturado utilizando princípios de POO para modelar as entidades do mundo real e suas interações de forma clara e eficiente.
- Classes e Objetos: O sistema é composto por classes que representam as entidades do projeto, como Campeonato, Time, Partida, Jogador e Tecnico.
- Herança: A classe abstrata Pessoa é a base para as classes Jogador e Tecnico, que herdam atributos e comportamentos comuns. Isso evita a duplicação de código e promove a reutilização.
- Encapsulamento: Os atributos das classes são privados e acessados através de métodos getters e setters, garantindo o controle sobre a modificação dos dados.
- Enumeração: A classe Posicao utiliza uma enumeração, o que restringe os valores de uma propriedade para um conjunto predefinido de constantes (ex: LEVANTADOR, OPOSTO), tornando o código mais legível e menos propenso a erros.

### Tecnologias Utilizadas
- Java

### Como Executar o Projeto
- Clone o repositório em sua máquina local.
- Compile os arquivos .java usando um compilador Java.
- Execute a classe principal (provavelmente Main.java ou similar) a partir do terminal.

___

English Version
## Volleyball Championship Manager
This is a console project developed in Java with a focus on applying Object-Oriented Programming (OOP) concepts. The system allows for the management of a volleyball championship, including the creation of teams, registration of players, recording of matches, and the generation of a ranking.

### Key Features
- Team Management: Add and manage teams participating in the championship.
- Player Management: Add players to each team, with validation to prevent duplicate jersey numbers.
- Match Recording: Record match results by sets and automatically update team scores.
- Ranking Generation: Generate a ranking of teams based on their scores.
- Player Roster: List the players of a specific team, including the coach's information.

### Object-Oriented Design (OOP)
The project was structured using OOP principles to model real-world entities and their interactions in a clear and efficient manner.
- Classes and Objects: The system is composed of classes that represent the project's entities, such as Campeonato (Championship), Time (Team), Partida (Match), Jogador (Player), and Tecnico (Coach).
- Inheritance: The abstract Pessoa (Person) class serves as the base for the Jogador and Tecnico classes, which inherit common attributes and behaviors. This avoids code duplication and promotes reusability.
- Encapsulation: Class attributes are private and accessed through getters and setters methods, ensuring control over data modification.
- Enumeration: The Posicao (Position) class uses an enumeration, which restricts a property's values to a predefined set of constants (e.g., LEVANTADOR, OPOSTO), making the code more readable and less prone to errors.

### Technologies Used
- Java

### How to Run the Project
- Clone the repository to your local machine.
- Compile the .java files using a Java compiler.
- Run the main class (likely Main.java or similar) from the terminal.

Author
Kamily Gracia - [LinkedIn](https://www.linkedin.com/in/kamily-de-souza-gracia/) | [Github](https://github.com/Kamilyszg/)
