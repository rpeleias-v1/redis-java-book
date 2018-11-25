package com.rodrigopeleias.redis;

import redis.clients.jedis.Jedis;

public class Capitulo1 {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String resultado = jedis.echo("Olá, Rodrigo e Denise!");
        System.out.println(resultado);

        
        // primeiro set e get
        String usuarioLogado = jedis.set("ultimo_usuario_logado", "Rodrigo Peleias");
        System.out.println(usuarioLogado);

        usuarioLogado = jedis.get("ultimo_usuario_logado");
        System.out.println(usuarioLogado);

        Long resultadoDel = jedis.del("ultimo_usuario_logado");
        System.out.println(resultadoDel);
    }
}
