/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author Jr
 */
public class UsuarioDao extends Usuario{
    
    // Método para cadastrar Usuario 
    public void create(Usuario usuario) {
        String sql = "INSERT INTO jdv_Usuarios(" 
                + "cd_usuario_id, de_usuario, "
                + "de_sexo, dt_nasc, de_login, de_senha_acesso, "
                + "dt_criacao, dt_alteracao, versao) VALUES(" 
                + "?,?,?,?,?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, usuario.getCdUsuariId());
            stmt.setString(2, usuario.getDeUsuario());
            stmt.setString(3, usuario.getDeSexo());
            stmt.setString(4, usuario.getDtNascimento());
            stmt.setString(5, usuario.getDeLogin());
            stmt.setString(6, usuario.getDeSenhaAcesso());
            stmt.setString(7, usuario.getDtCriacao());
            stmt.setString(8, usuario.getDtAlteracao());
            stmt.setInt(9, usuario.getVersao());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Método para fazer consulta de Usuario
    public List<Usuario> read(Integer cdUsuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = cdUsuario == null ? 
                    "SELECT * FROM jdv_Usuarios " : 
                    "SELECT * FROM jdv_Usuarios WHERE cd_usuario_id = " + cdUsuario.toString();
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setCdUsuariId(rs.getInt("cd_usuario_id"));
                usuario.setDeUsuario(rs.getString("de_usuario"));
                usuario.setDeSexo(rs.getString("de_sexo"));
                java.util.Date aData = rs.getDate("dt_nasc");
                LocalDateTime dataRecup = aData == null ? null : LocalDateTime.parse(new SimpleDateFormat("yyyy-MM-dd").format(aData));
                usuario.setDeLogin(rs.getString("de_login"));
                usuario.setDeSenhaAcesso(rs.getString("de_senha_acesso"));
                aData = rs.getDate("dt_criacao");
                dataRecup = aData == null ? null : LocalDateTime.parse(new SimpleDateFormat("yyyy-MM-dd").format(aData));
                aData = rs.getDate("dt_alteracao");
                dataRecup = aData == null ? null : LocalDateTime.parse(new SimpleDateFormat("yyyy-MM-dd").format(aData));
                usuario.setVersao(rs.getInt("versao"));
                
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuarios;
    }

    // Método para alterar informações sobre Usuario
    public void update(Usuario usuario) {
        String sql = "UPDATE jdv_Usuarios "
                + "SET de_usuario = ?, de_sexo = ?, "
                + "dt_nasc = ?, de_login = ?, de_senha_acesso = ?, dt_criacao = ?, dt_alteracao = ?, "
                + "versao = ? WHERE cd_usuario_id = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, usuario.getDeUsuario());
            stmt.setString(2, usuario.getDeSexo());
            stmt.setString(3, usuario.getDtNascimento());
            stmt.setString(4, usuario.getDeLogin());
            stmt.setString(5, usuario.getDeSenhaAcesso());
            stmt.setString(6, usuario.getDtCriacao());
            stmt.setString(7, usuario.getDtAlteracao());
            usuario.setVersao(usuario.getVersao() + 1);
            stmt.setInt(8, usuario.getVersao());
            stmt.setInt(9, usuario.getCdUsuariId());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Método para remover um Usuario
    public void delete(Usuario usuario) {
        String sql = "DELETE FROM jdv_Usuarios WHERE cd_usuario_id = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuario.getCdUsuariId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
