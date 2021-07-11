package com.connect;

import java.sql.Date;

public class Banco {
    private int numero;
    private String nome;
    private Boolean ativo;
    private Date data_criacao;

    public Banco(int numero, String nome, Boolean ativo, Date data_criacao) {
        this.numero = numero;
        this.nome = nome;
        this.ativo = ativo;
        this.data_criacao = data_criacao;
    }

    public Banco(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public Banco() { }

    /**
     * @return int return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
    * @param numero the numero to set
    */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
    * @return String return the nome
    */
    public String getNome() {
        return nome;
    }

    /**
    * @param nome the nome to set
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    * @return Boolean return the ativo
    */
    public Boolean isAtivo() {
        return ativo;
    }

    /**
    * @param ativo the ativo to set
    */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
    * @return Date return the data_criacao
    */
    public Date getData_criacao() {
        return data_criacao;
    }

    /**
    * @param data_criacao the data_criacao to set
    */
    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banco: { \n");
        sb.append("  numero: ").append(this.getNumero()).append("\n");
        sb.append("  nome: ").append(this.getNome()).append("\n");
        sb.append("  ativo: ").append(this.isAtivo()).append("\n");
        sb.append("  data_criacao: ").append(this.getData_criacao()).append("\n");
        sb.append("} \n");

        return sb.toString();
    }

}
