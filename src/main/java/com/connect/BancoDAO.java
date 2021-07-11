package com.connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO {

    public List<Banco> list() {
        List<Banco> bancos = new ArrayList<>();

        try(Connection conn = ConnectionFac.getConnection()) {

            String sql = "SELECT * FROM banco";

            PreparedStatement smt = conn.prepareStatement(sql);

            ResultSet rs = smt.executeQuery();

            while(rs.next()) {
                int numero = rs.getInt("numero");
                String nome = rs.getString("nome");
                Boolean ativo = rs.getBoolean("ativo");
                Date data_criacao = rs.getDate("data_criacao");

                bancos.add(new Banco(
                    numero,
                    nome,
                    ativo,
                    data_criacao
                ));
            }

        } catch(SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados!");
            e.printStackTrace();
        }

        return bancos;
    }

    public Banco getByNumero(int numero) {
        Banco banco = new Banco();

        try(Connection conn = ConnectionFac.getConnection()) {

            String sql = "SELECT numero, nome, ativo, data_criacao FROM banco WHERE numero = ?";

            PreparedStatement smt = conn.prepareStatement(sql);
            smt.setInt(1, numero);

            ResultSet rs = smt.executeQuery();

            if(rs.next()) {
                banco.setNumero(rs.getInt("numero"));
                banco.setNome(rs.getString("nome"));
                banco.setAtivo(rs.getBoolean("ativo"));
                banco.setData_criacao(rs.getDate("data_criacao"));
            }

        } catch(SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados!");
            e.printStackTrace();
        }

        if(banco.getNome() == null) {
            throw new Error("Numero inválido");
        }

        return banco;
    }

    public void create(Banco banco) {

        String sql = "INSERT INTO banco (numero, nome) VALUES (?::INTEGER, ?)";

        try(Connection conn = ConnectionFac.getConnection()) {

            PreparedStatement smt = conn.prepareStatement(sql);
            smt.setInt(1, banco.getNumero());
            smt.setString(2, banco.getNome());

            int rowsAffected = smt.executeUpdate();

            System.out.println("Sucesso! adicionado " + rowsAffected + " linha");
        } catch(SQLException e) {
            System.out.println("Falhou!");
            e.printStackTrace();
        }
    }

    public void delete(int numero) {

        String sql = "DELETE FROM banco WHERE numero = ?";

        try(Connection conn = ConnectionFac.getConnection()) {

            PreparedStatement smt = conn.prepareStatement(sql);
            smt.setInt(1, numero);

            int rowsAffected = smt.executeUpdate();

            System.out.println("Deletado com sucesso " + rowsAffected + " linhas afetadas");

        } catch(SQLException e) {
            System.out.println("Erro ao deletar");;
            e.printStackTrace();
        }

    }

    public void update(Banco banco) {

        String sql = "UPDATE banco SET nome = ? WHERE numero = ?";

        try(Connection conn = ConnectionFac.getConnection()) {

            PreparedStatement smt = conn.prepareStatement(sql);
            smt.setString(1, banco.getNome());
            smt.setInt(2, banco.getNumero());

            int rowsAffected = smt.executeUpdate();

            System.out.println("Sucesso " + rowsAffected + " linhas modificadas");

        } catch(SQLException e) {
            System.out.println("Erro ao alterar dados!");
            e.printStackTrace();
        }
    }
}
