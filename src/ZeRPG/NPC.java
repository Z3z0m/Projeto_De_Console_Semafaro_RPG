package ZeRPG;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class NPC {
    private Semaphore semaforo;
    private PriorityBlockingQueue<Jogador> filaPrioridade;

    public NPC(int limiteJogadores) {
        this.semaforo = new Semaphore(limiteJogadores, true); 
        this.filaPrioridade = new PriorityBlockingQueue<>(10, (j1, j2) -> Long.compare(j1.getTimestampEntrada(), j2.getTimestampEntrada()));
    }

    public void atenderJogador(Jogador jogador) {
        try {
            filaPrioridade.put(jogador);
            semaforo.acquire();
            System.out.println("\u001B[32mJogador " + jogador.getIdJogador() + " está sendo atendido.\u001B[0m");
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sairDoAtendimento(jogador);
        }
    }

    public void sairDoAtendimento(Jogador jogador) {
        System.out.println("\u001B[31mJogador " + jogador.getIdJogador() + " terminou de negociar.\u001B[0m");
        semaforo.release();
    }
}