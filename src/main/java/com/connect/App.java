package com.connect;

import java.util.List;

public final class App {

    public static void main(String[] args) {
        BancoDAO bancosDados = new BancoDAO();

        List<Banco> bancos = bancosDados.list();

        bancos.stream().forEach(System.out::println);

        // bancosDados.create(new Banco(333, "Banco Teste"));

        // Banco updateBanco = bancosDados.getByNumero(333);
        // updateBanco.setNome("Banco Teste Brasil");
        // bancosDados.update(updateBanco);

        // bancosDados.delete(333);

        // System.out.println(bancosDados.getByNumero(333));
    }
}
