/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_prog_ii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author illgner
 */
public class EnderecoDAO {
    Connection conexao = Conexao.criarConexao();
    public int salvarEndereco(Endereco endereco) throws SQLException{
       String sql = "Insert "
                  + "Into"
                  + "tb_endereco (logradouro, complemento, bairro, numero, cep)"
                  + "Values (?, ?, ? ,? ,?)";
       try{
           PreparedStatement pgdcnx = conexao.prepareStatement(sql);//pgdcnx=pegando conexao
           pgdcnx .setString(1 , endereco.getLogradouro());
           pgdcnx .setString(2 , endereco.getComplemento());
           pgdcnx .setString(3 , endereco.getBairro());
           pgdcnx .setString(4 , endereco.getNumero());
           pgdcnx .setString(5 , endereco.getCep());
           
           return pgdcnx.executeUpdate();
       
       }catch(SQLException ex){
          ex.printStackTrace();
          return -1;
       }
    }

    Iterable<Endereco> listarEnderecos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editarEndereco(Endereco endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void rmvEndereco(Endereco endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
