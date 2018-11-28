package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

public class ArmazenarPontuacaoJogador {

    private void definirNovaPontuacao(int codigoJogador, int ponto) {
        String chave = String.format("jogador:%04d:codigo", codigoJogador);
        Jedis jedis = new Jedis("localhost");

        long novaPontuacao = jedis.hincrBy(chave, "pontuacao", ponto);

        System.out.println(
                String.format("A pontuação do jogador %04d é :%d",
                        codigoJogador, novaPontuacao)
        );
    }

    public void adicionarVitoria(int codigoJogador) {
        definirNovaPontuacao(codigoJogador, 1);
    }

    public void adicionarDerrota(int codigoJogador) {
        definirNovaPontuacao(codigoJogador, -1);
    }

    public static void main(String[] args) {
        int codigoJogador = 1;

        ArmazenarPontuacaoJogador pontuacao = new ArmazenarPontuacaoJogador();

        pontuacao.adicionarVitoria(codigoJogador);
        pontuacao.adicionarVitoria(codigoJogador);
        pontuacao.adicionarDerrota(codigoJogador);
        pontuacao.adicionarVitoria(codigoJogador);
    }
}
