package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

public class Capitulo3Hashes {

    public static void main(String[] args) {
        String ganhadores = "22";
        String dataSorteio = "09-11-2013";
        String numeros = "8, 18, 28, 42, 56, 58";
        String chave = String.format("resultado:%s:megasena", dataSorteio);


        Jedis jedis = new Jedis("localhost");
        Long resultado1 = jedis.hset(chave, "ganhadores", ganhadores);
        Long resultado2 = jedis.hset(chave, "numeros", numeros);

        String mensagem = String.format("Resultado 1 = %d, Resultado 2 = %d", resultado1, resultado2);
        System.out.println(mensagem);

        //exemplo de uso do comando hget
        String chaveConsulta = "resultado:09-11-2013:megasena";
        String consultaGanhadores = jedis.hget(chaveConsulta, "ganhadores");
        String consultaNumeros = jedis.hget(chaveConsulta, "numeros");

        String resultadoConsulta = String.format("Ganhadores = %s, Números: [%s]",
                consultaGanhadores,
                consultaNumeros);
        System.out.println(resultadoConsulta);

//        Long exclusaoGanhadores = jedis.hdel(chave, "ganhadores");
//        System.out.println(exclusaoGanhadores);

        System.out.println(jedis.hexists(chave, "numeros"));
        System.out.println(jedis.hlen(chave));
    }
}
