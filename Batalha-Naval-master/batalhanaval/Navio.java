package batalhanaval;

import java.awt.Point;
import java.io.Serializable;

/**
 * Classe de um navio.
 */
public class Navio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Constantes para os identificadores dos navios.
	public static final int BARCO_PATRULHA = 2; //Corveta
	public static final int SUBMARINO = 4; //Submarino
	public static final int ENCOURACADO = 8; //Fragata
	public static final int PORTA_AVIOES = 16; //Destroyer
	public static final int DESTROIER = 32; //Não utilizado

	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;

	private String nome;
	private int tamanho;
	private int id;

	private Jogador jogador;
	private Point posicao;
	private int orientacao;

	private Navio(String nome, int tamanho, int identificador, Jogador jogador) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.id = identificador;

		this.jogador = jogador;
		this.posicao = null;
		this.orientacao = HORIZONTAL;
	}

    public static Navio constroiNavio(int id, Jogador jog) {
		switch (id) {
            case BARCO_PATRULHA:
                return new Navio("Corveta", 2, 2, jog);
            case PORTA_AVIOES:                                             
                return new Navio("Destroyer", 5, 16, jog);
            case SUBMARINO:                                             
                return new Navio("Submarino", 3, 4, jog);
            case ENCOURACADO:                                           
                return new Navio("Fragata", 4, 8, jog);
            case DESTROIER:
            	return new Navio("Destroier", 4, 32, jog);
            default:
                return null;
		}
    }

	public String getNome() {
		return nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getId() {
		return id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public Point getPosicao() {
		return posicao;
	}
	
	/**
	 * Gera um array de pontos a partir da primeira posição
	 * do navio.
	 * 
	 * @return
	 * @throws NullPointerException Se o navio ainda não estiver posicionado.
	 */
	public Point[] getArrayPosicao() throws NullPointerException {
		Point[] arrayPos = new Point[tamanho];
		int i = posicao.x;
		int j = posicao.y;
		int k = 0;
		
		while(k < tamanho) {
			arrayPos[k++] = new Point(i, j);
			if (orientacao == VERTICAL)
				j++;
			else
				i++;	
		}
		return arrayPos;
	}

	public int getOrientacao() {
		return orientacao;
	}

	public void setPosicao(Point pos) {
		posicao = pos;
	}
	
	public void setOrientacao(int orientacao) {
		this.orientacao = orientacao;
	}

	public boolean estaDestruido() {
		for (Point p: getArrayPosicao()) {
			if (jogador.getTabuleiro().getPosicao(p.x, p.y) > 0) {
				return false;
			}
		}
		return true;
	}
}
