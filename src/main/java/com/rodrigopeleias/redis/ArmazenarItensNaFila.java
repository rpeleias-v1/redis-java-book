package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

public class ArmazenarItensNaFila {

    public static void main(String[] args) {
        ArmazenarItensNaFila fila = new ArmazenarItensNaFila();
        fila.agendarAutorizacaoDeUsuario(
                "Daenerys Targaryen", "daenerys@targaryen.com"
        );
        fila.agendarAutorizacaoDeUsuario(
                "Jon Snow", "jon@snow.com"
        );
        fila.agendarAutorizacaoDeUsuario(
                "Tyrion Lannister", "tyrion@lannister.com"
        );
    }

    public void agendarAutorizacaoDeUsuario(String nome, String email) {
        String chave = "fila:confirmar-usuario";
        String mensagem = String.format(
                "{\"nome\": \"%s\", \"email\": \"%s\"}", nome, email
        );

        Jedis jedis = new Jedis("localhost");
        Long resultado = jedis.rpush(chave, mensagem);
        System.out.println(
                String.format("A fila %s contém %d tarefa(s).", chave, resultado)
        );
    }
}
