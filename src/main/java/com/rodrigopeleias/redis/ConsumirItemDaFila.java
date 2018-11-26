package com.rodrigopeleias.redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ConsumirItemDaFila {

    class Mensagem {
        private String nome;
        private String mensagem;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }

    public void enviarEmailAtivacaoUsuario() {
        int timeout = 2;
        String chave = "fila:confirmar-usuario";

        Jedis jedis = new Jedis("localhost");
        List<String> mensagens = jedis.blpop(timeout, chave);

        if (mensagens == null) {
            String json = mensagens.get(1);
            Mensagem mensagem = new Gson().fromJson(json, Mensagem.class);
            System.out.println(
                    String.format(
                            "Enviando e-mail para %s (%s)",
                            mensagem.getMensagem(),
                            mensagem.getNome()
                    )
            );
        }
    }

    public static void main(String[] args) {
        ConsumirItemDaFila fila = new ConsumirItemDaFila();

        while (true) {
            fila.enviarEmailAtivacaoUsuario();
        }
    }
}
