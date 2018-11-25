package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

public class Capitulo3 {

    public static void main(String[] args) {
        String chave = "resultado:megasena";
        String numerosDoUltimoSorteio = "2, 13, 24, 41, 42, 44";

        Jedis jedis = new Jedis("localhost");
        String resultado = jedis.set(chave, numerosDoUltimoSorteio);
        System.out.println(resultado);

        jedis.mset(
                formatarChaveSorteio("04-09-2013"), "1-2-3-4-5-6",
                formatarChaveSorteio("14-11-2013"), "11-24-35-44-55-66",
                formatarChaveSorteio("24-11-2013"), "1-2-3-4-5-6",
                formatarChaveSorteio("26-12-2013"), "1-2-3-4-5-6"
        );
    }

    public static String formatarChaveSorteio(String dataSorteio) {
        return String.format("resultado:%s:megasena", dataSorteio);
    }
}
