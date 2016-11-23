package batalhanaval;

/**
 * Representa um evento do jogo
 */

public class Evento {
   private String mensagem;

   public Evento (String mensagem) {
        this.mensagem = mensagem;   
   }

   public String getMensagem() {
        return this.mensagem;
   }
}