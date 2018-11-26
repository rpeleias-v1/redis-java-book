package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class Capitulo5 {

    public static void main(String[] args) {
        String chave = "ultimas_paginas_visitadas";
        String[] paginasVisitadas = {
                "/inicio",
                "/contato",
                "/sobre-mim",
                "/todos-os-posts",
                "/armazenando-dados-no-redis"
        };

        Jedis jedis = new Jedis("localhost");
        Long resultado = jedis.lpush(chave, paginasVisitadas);
        System.out.println(
                String.format("A lista %s contém %d elementos", chave, resultado)
        );

        //obter as 3 últimas páginas visitadas
        List<String> paginas = jedis.lrange(chave, 0, 2);
        paginas.forEach(System.out::println);

        //limitação de listas
        String resultadoLTrim = jedis.ltrim(chave, 0, 2);
        System.out.println(String.format("Resultado: %s", resultadoLTrim));
    }
}
