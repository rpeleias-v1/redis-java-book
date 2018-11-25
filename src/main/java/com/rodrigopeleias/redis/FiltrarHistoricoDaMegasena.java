package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class FiltrarHistoricoDaMegasena {

    public Set<String> filtrarResultados(int mes, int ano) {
        String chave = "resultado:*-%02d-%04d:megasena";
        Jedis jedis = new Jedis("localhost");

        return jedis.keys(String.format(chave, mes, ano));
    }

    public List<String> retornarTodasChaves(String pattern) {
        Jedis jedis = new Jedis("localhost");
        Set<String> keys = jedis.keys(pattern);
        return jedis.mget(keys.stream().toArray(String[]::new));
    }

    public Long getTamanhoChave(String chave) {
        Jedis jedis = new Jedis("localhost");
        return jedis.strlen(chave);
    }

    public String getRange(String chave) {
        Jedis jedis = new Jedis("localhost");
        return jedis.getrange(chave, 0 , 1);
    }

    public static void main(String[] args) {
        int mes = 11;
        int ano = 2013;
        FiltrarHistoricoDaMegasena filtro = new FiltrarHistoricoDaMegasena();
        Set<String> chaves = filtro.filtrarResultados(mes, ano);
        chaves.forEach(System.out::println);

        System.out.println(filtro.retornarTodasChaves("*"));
        System.out.println(filtro.getTamanhoChave("resultado:megasena"));
        System.out.println(filtro.getRange("resultado:megasena"));
    }
}
