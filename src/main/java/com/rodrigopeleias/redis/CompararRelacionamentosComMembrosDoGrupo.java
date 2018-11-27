package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class CompararRelacionamentosComMembrosDoGrupo {

    public void verAmigosDoGrupo(String pessoa, String grupo) {
        String chavePessoa = String.format(
                "pessoas:%s:relacionamentos", pessoa
        );

        String chaveGrupo = String.format(
                "grupos:%s:membros", grupo
        );

        Jedis jedis = new Jedis("localhost");
        Set<String> pessoas = jedis.sinter(chavePessoa, chaveGrupo);

        System.out.println(
                String.format(
                        "%s são amigos de %s e fazem também parte do grupo que gosta de %s",
                        pessoas.toString(),
                        pessoa,
                        grupo
                )
        );
    }

    public static void main(String[] args) {
        CompararRelacionamentosComMembrosDoGrupo resultado = new CompararRelacionamentosComMembrosDoGrupo();

        resultado.verAmigosDoGrupo("rafael", "cachorro");
        resultado.verAmigosDoGrupo("rodrigo", "video-game");
        resultado.verAmigosDoGrupo("andressa", "novela");
    }
}
