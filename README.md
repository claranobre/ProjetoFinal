# ProjetoFinal

Alunos: Ana Clara Nobre [[GitHub]] (https://github.com/claranobre)
		Icaro Heitor [[GitHub]](https://github.com/icarotangara)

Projeto de criação de um jogo de Batalha Naval da disciplina de Linguagem de Programação II. 
Esse projeto é um fork de outro projeto já existente [GitHub](https://github.com/dcampos/Batalha-Naval).
O jogo apresenta as regras tradicionais do Batalha Naval, em que o jogador e uma Inteligencia Artificial(I.A.) estarão disputando quem irá descobrir a localização da frota do oponente e destruí-la primeiro. Cada jogador possui 4 tipos de navios diferentes(Fragata, Destroyer, Submarino e Corveta), em quê poderá posicionar aleatoriamente seus navios em um tabuleiro 10x10. Já a inteligencia artificial terá seus navios dispostos aleatoriamente em um outro tabuleiro com as mesmas definições.

## O Jogo
O jogo basicamente é baseado em ações (eventos) quê o usuário precisa escolher o lugar no tabuleiro do adversário em que irá atirar, caso acerte um quadrado que pertence a região onde encontra-se um navio, o jogador poderá atacar novamente na tentativa de destruir o navio por completo. Cada navio tem tamanhos diferentes:
 * Corveta 1x2 
 * Submarino 1x3  
 * Fragata 1x4 
 * Destroyer 1x5 

Se o jogador selecionar um quadrado que não contém navio o próximo terá sua vez de jogar e assim sucessivamente até que um dos jogadores encontre e destrua todos os navios do oponente. 
Lembrando que nenhum navio poderá estar sobreposto ao outro. 

## Classes mais importantes para o desenvolvimento do jogo

* [JOGO] (Jogo.java)

A classe ```Jogo``` é onde iremos definir a ```ArrayList``` dos eventos, esses eventos são baseados em estados, em que o jogo começou, o jogador está jogando, esperando a jogada do adversário  e o fim do jogo. Para ser possível captar esses estados foi utilizado ```Serialização``` dos objetos. Sabendo que como a classe Pai implementou ```Serializable``` então as subclasses implicitamente farão Serialização, e como trabalhamos com Herança e Polimorfismo todas as demais classes implementam ```Serializable```.Existe também as dificuldades do jogo (fácil, médio e difícil) que irá definir o algoritmo de "inteligência" da I.A. para posicionar os seus navios.


* [JOGADOR] (Jogador.java)

A classe ```Jogador``` será onde chamaremos a função de construção(```constroiNavio```) dos Navios, dando origem a frota do jogador e onde ele irá posicioná-la, todo o jogo funciona em função de ```ArrayList``` portanto a localização dos navios é dada por manipulação de linhas e colunas. O ato de ```atirar``` e ```atirar aleatoriamente``` é definida na classe para que possa ser utilizado tanto pelo jogador quanto pelo robô (I.A.) garantindo que ambos atirem em suas jogadas, caso contrário, uma exceção é tratada. O navio é destruído quando o jogador consegue atirar em todos os quadrados pertencentes a imagem do navio, que depende do tipo de navio, e consequentemente seu tamanho, cada navio possui uma ID identificadora que é decrementada cada vez que o oponente acerta um navio completo, portanto quando esse valor chegar a 0 significa que todos os navios (pois todas as IDs foram removidas) foram afundados, e um campeão do jogo é setado.

* [NAVIO] (Navio.java)

A classe ```Navio``` conterá todas as informações da frota que o jogo possuirá, em que cada um terá o seu identificador, permitirá que o usuário posicione o navio em duas posições (horizontal e vertical), organizará a ordem em que os navios serão entregues ao usuário para posicioná-los, irá verificar se o navio foi posicionado corretamente, caso contrário o erro será tratado e por fim irá verificar e retornar se o navio foi destruído no jogo para retornar seu estado atual ao usuário no tabuleiro.  

* [ROBO] (Robo.java)

A classe ```Robô``` é que cria a inteligencia artificial, verificando as posições dos navios (utilizando orientação cartesiana),  criando por meio da escolha de dificuldade onde melhor posicionar sua frota dificultando o acerto do adversário, utilizando da função ```Math.random``` em todas as posições, inclusive para atirar.

* [TABULEIRO] (Tabuleiro.java)

A classe ```Tabuleiro``` é que irá formar toda a matriz do mapa, tamanho, irá verificar se no espaço em que o jogador está tentando colocar um navio de sua frota tem área suficiente para a imagem e irá retornar todas as posições onde os navios se encontram.

## Interface Gráfica

A interface gráfica do jogo foi desenvolvida usando a biblioteca Java Swing, no pacote ```batalhanaval.gui```, teremos três classes ```JanelaPrincipal```, ```JanelaSobre``` e ```PainelGrade```, na primeira utilizando ```JFrame```
faremos a chamada das imagens de fundo do jogo, imagens dos navios, do tiro e todas as barras de menu, setando tamanho, cor e formato desejado.

```python
ActionListener fazJogada = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (JanelaPrincipal.this.jogo.getEstado() == Jogo.VEZ_JOG2) {
					int res = JanelaPrincipal.this.jogo.getJogador(1).atira();
					mapa1.repaint();

					if (res == 1) {
						temp.stop();
						JanelaPrincipal.this.jogo.setEstado(Jogo.VEZ_JOG1);
					} else if ( res > 1) {
						if (JanelaPrincipal.this.jogo.getEstado() == Jogo.TERMINADO) {
							temp.stop();
                            mostraEventos();
						} else if (JanelaPrincipal.this.jogo.getJogador(
								0 ).getNavio(res).estaDestruido())
                            mostraEventos();
					}
				}
			}
		};
```
O ```actionListener``` acima fará a chamada dos eventos do jogo, garantindo o início do jogo, espera de jogada dos jogadores e finalização do jogo.		
A classe ```JanelaSobre``` foi desenvolvida só para fornecer informações sobre o jogo, dos desenvolvedores e a versão.
Já a classe ```PainelGrade``` é onde será tratado todos os movimentos do mouse usando de herança das bibliotecas ```MouseListener``` e ```MouseMotionListener```, o método garante que o jogador selecione a posição do seu navio e rotacione para a horizontal ou vertical como desejar e irá verificar se o local onde você está tentando posicioná-lo tem quadrados suficientes para o tamanho do navio que está sendo posicionado.	

![alt tag] (http://i.imgur.com/LAUiAOW.png)

## Como rodar o jogo