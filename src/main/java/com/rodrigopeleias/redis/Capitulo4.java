package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class Capitulo4 {

    public static void main(String[] args) {
        String codigoUsuario = "1962";
        String nomeUsuario = "Rodrigo Peleias";
        String email = "rodrigo.peleias@gmail.com";

        String chave = "sessao:usuario:" + codigoUsuario;

        HashMap<String, String> campos = new HashMap<String, String>() {{
            put("codigo", codigoUsuario);
            put("nome", nomeUsuario);
            put("email", email);
        }};

        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.hmset(chave, campos));

        int trintaMinutosEmSegundos = 1800;
        System.out.println(jedis.expire(chave, trintaMinutosEmSegundos));

    }
}
