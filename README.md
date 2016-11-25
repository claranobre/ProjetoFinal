## ProjetoFinal

Projeto de criação de um jogo de Batalha Naval da disciplina de Linguagem de Programação II. 
Esse projeto é um fork de outro projeto já existente [GitHub](https://github.com/dcampos/Batalha-Naval).
O jogo apresenta as regras tradicionais do Batalha Naval, em que o jogador e uma Inteligencia Artificial(I.A.) estarão disputando quem irá descobrir a localização da frota do oponente e destruí-la primeiro. Cada jogador possui 4 tipos de navios diferentes(Fragata, Destroyer, Submarino e Corveta), o jogador usuário poderá posicionar aleatoriamente seus navios em um tabuleiro 10x10, já a inteligencia artificial terá seus navios dispostos aleatoriamente em um outro tabuleiro com as mesmas definições.

# O Jogo
O jogo basicamente é baseado em ações (eventos) em quê o usuário precisa escolher o lugar no tabuleiro do adversário em que irá atirar, se caso acertar um quadrado que pertence a região onde encontra-se um navio, o jogador poderá atacar novamente na tentativa de destruir o navio por completo, cada navio tem tamanhos diferentes:
 * Corveta 1x2 
 * Submarino 1x3  
 * Fragata 1x4 
 * Destroyer 1x5 

Se caso o jogador selecionar um quadrado que não contém nenhum navio o próximo terá sua vez de jogar e assim sucessivamente até que um dos jogadores encontre e destrua todos os navios do oponente. 
Lembrando que nenhum navio poderá estar sobreoposto ao outro. 

# Classes mais importantes para o desenvolvimento do jogo

* JOGO

A classe ```Jogo``` é onde iremos definir a ```ArrayList``` dos eventos, esses eventos são baseados em estados, em que o jogo começou, o jogador está jogando, esperando jogada do adversário  e por fim o fim do jogo. Existe também as dificuldades do jogo (Fácil, médio e difícil) que irá definir o algoritmo de "inteligência" da I.A. para acertar os navios do jogador.

```python
private ArrayList<Evento> eventos;

    public Jogo(int dif) {
        jogadores = new Jogador[2];
        jogadores[0] = new Jogador(this);
        jogadores[1] = new Robo(this);

        dificuldade = dif;

        eventos = new ArrayList<Evento>();

        setEstado(POSICIONANDO_NAVIOS);
    }
```