package ZeRPG;

public class Jogador extends Thread {
    private int id;
    private long timestampEntrada;
    private NPC npc;

    public Jogador(int id, NPC npc) {
        this.id = id;
        this.npc = npc;
        this.timestampEntrada = System.currentTimeMillis();
    }

    public int getIdJogador() {
        return id;
    }

    public long getTimestampEntrada() {
        return timestampEntrada;
    }

    @Override
    public void run() {
        try {
            System.out.println("\u001B[33mJogador " + id + " entrou na fila para comprar.\u001B[0m"); 
            npc.atenderJogador(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}