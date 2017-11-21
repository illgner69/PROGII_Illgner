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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author illgner
 */
public class UsuarioDAO {
    Connection conexao = Conexao.criarConexao();
    private List<Usuario> listaRetorn;
    public int salvandoUsuario(Usuario usuario){
    String sql = "Insert"
               + "Into"
               + "td_usuario"
               + "Values (? , ?)";
        try {
            PreparedStatement preparacaoDaInstrucao = conexao.prepareStatement(sql);
            preparacaoDaInstrucao.setString(1, usuario.getNome());
            preparacaoDaInstrucao.setString(2, usuario.getSobrenome());
            return preparacaoDaInstrucao.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    //Listar
    public List<Usuario> listandoUsuario() throws SQLException{
    String sql = "Select * From td_usuario";
    try{
        PreparedStatement instrucaoSelecao = conexao.prepareStatement(sql);
        ResultSet resultado = instrucaoSelecao.executeQuery();
        while(resultado.next()){
        Usuario usuario = new Usuario();
        usuario.setId_Usuario(resultado.getInt("id_usuario"));
        usuario.setNome(resultado.getString("nome"));
        usuario.setSobrenome(resultado.getString("sobrenome"));
        listaRetorn.add(usuario);
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return listaRetorn;
    }
    //remover 
    public void removerUsuario(Usuario usuario){
    String sql = "Delete From td_usuario Where id_usuario = ?";
    try{
        PreparedStatement conecta = conexao.prepareStatement(sql);   
        conecta.setInt(1 , usuario.getId_Usuario());
        conecta.executeUpdate();
        JOptionPane.showMessageDialog(null, "Usuario REMOVIDO COM SUCESSO");
        conecta.close();
    
       }catch(SQLException ex){
          ex.printStackTrace();
        }
   }
    //Atualizar
    public void atualizarUsuario(Usuario usuario) throws SQLException{
    String sql = "Update td_usuario SET nome = ?, sobrenome = ? Where id_usuario ";
    try{
        PreparedStatement conecta = conexao.prepareStatement(sql);
        conecta.setString(1 , usuario.getNome());
        conecta.setString(2 , usuario.getNome());
        conecta.setString(3 , usuario.getNome());
        conecta.setInt(4 , usuario.getId_Usuario());
        conecta.executeUpdate();
        JOptionPane.showMessageDialog(null, "Usuario ALTERADO COM SUCESSO");
        conecta.close();
        
    }catch(SQLException ex){
      ex.printStackTrace();
     }
    }

    void editarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Iterable<Usuario> listandoUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Iterable<Usuario> listarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void salvarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void rmvUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
    

