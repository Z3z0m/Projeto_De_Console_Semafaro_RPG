package ZeRPG;

public class Main {
    public static void main(String[] args) {
        int limiteJogadores = 3; 
        int totalJogadores = 10;

        NPC npc = new NPC(limiteJogadores);

        for (int i = 1; i <= totalJogadores; i++) {
            Jogador jogador = new Jogador(i, npc);
            jogador.start();
        }
    }
}