/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_prog_ii;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Illgner
 */
public class Conexao {
    private static final String URL_BANCO = "jdbc:postgresql://localhost:5432/trab_prog_ii";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "estacio@123";// Mesma senha dos comput da estacio
    private static String status = "Não conectado ...";
    public static Connection criarConexao() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (conexao != null)
            status = "Conectado";
        else
            status = "Não conectado";
        return conexao;
    }
     public String getStatus() {
        return status;
    }
}
