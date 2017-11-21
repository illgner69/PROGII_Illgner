/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_prog_ii;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Illgner
 */
public class PerfilDAO {
    Connection conexao = Conexao.criarConexao();
    private List<Perfil> listaRetorn;
    
    public int salvarPerfil(Perfil perfil) throws SQLException{
     String sql = "Insert"
               + "Into"
               + "td_perfil(nome, descricao)"
               + "Values (? , ?)";
    try{
        PreparedStatement pprdInst = conexao.prepareStatement(sql);
        pprdInst.setString(1 , perfil.getNome());
        pprdInst.setString(2 , perfil.getDescricao());
    
         return pprdInst.executeUpdate();
    
       }catch(SQLException ex){
         ex.printStackTrace();
         return -1;
         }           
    }
    public List<Perfil> listarPerfil(){
    List<Perfil> listaRetorno = new ArrayList<Perfil>();
    String sql = "Select * From tb_perfil";
    try{
         PreparedStatement instrucaoDaSelecao = conexao.prepareStatement(sql);
         ResultSet resultado = instrucaoDaSelecao.executeQuery();
         while(resultado.next()){
              Perfil perfil = new Perfil();
              perfil.setNome(resultado.getString("nome"));
              perfil.setDescricao(resultado.getString("descricao"));
              listaRetorno.add(perfil);
         }
    
       }catch(SQLException ex){
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
      }
      return listaRetorno;
    }   

    Iterable<Perfil> listarPerfilUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editarPerfil(Perfil perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void rmvPerfil(Perfil perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
