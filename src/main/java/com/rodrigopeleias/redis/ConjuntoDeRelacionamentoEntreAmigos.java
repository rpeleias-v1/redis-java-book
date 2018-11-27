package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

import java.util.Arrays;

public class ConjuntoDeRelacionamentoEntreAmigos {


    public static void main(String[] args) {
        ConjuntoDeRelacionamentoEntreAmigos relacionamentos = new ConjuntoDeRelacionamentoEntreAmigos();

        relacionamentos.adicionaMembrosAoGrupo(
                "video-game",
                new String[]{"rafael", "gustavo", "carlos", "rodrigo"}
        );

        relacionamentos.adicionaMembrosAoGrupo("judo", new String[]{"rafael"});

        relacionamentos.adicionaMembrosAoGrupo(
                "kung-fu",
                new String[]{"andressa"}
        );
        relacionamentos.adicionaMembrosAoGrupo(
                "violao",
                new String[]{"gustavo"}
        );
        relacionamentos.adicionaMembrosAoGrupo(
                "ciclismo",
                new String[]{"cristiane"}
        );
        relacionamentos.adicionaMembrosAoGrupo(
                "cachorro",
                new String[]{"cristiane", "rodrigo",

                        "tereza"}

        );
        relacionamentos.adicionaMembrosAoGrupo(
                "moto",
                new String[]{"carlos"}
        );
        relacionamentos.adicionaMembrosAoGrupo(
                "carro",
                new String[]{"carlos", "rodrigo"}
        );
        relacionamentos.adicionaMembrosAoGrupo(
                "livro",
                new String[]{"gustavo", "rodrigo"}
        );
        relacionamentos.adicionaMembrosAoGrupo(
                "novela",
                new String[]{"andressa", "cristiane", "tereza"}

        );
    }

    public void adicionaMembrosAoGrupo(String grupo, String[] membros) {
        String chave = String.format("grupos:%s:membros", grupo);
        Jedis jedis = new Jedis("localhost");
        long resultado = jedis.sadd(chave, membros);

        System.out.println(
                String.format("Grupo (%s) tem %d membros %s",
                        grupo,
                        resultado,
                        Arrays.toString(membros))
        );
    }
}
