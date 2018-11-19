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
import model.Partida;

/**
 *
 * @author Jr
 */
public class PartidaDao extends Partida{
    
    // Método para cadastrar Partida 
    public void create(Partida partida) {
        String sql = "INSERT INTO partidas(" 
                + "cd_partida_id, cd_usuario_id, "
                + "dt_partida, de_resultado, versao) VALUES(" 
                + "?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.setInt(1, partida.getCdPartidaId());
            stmt.setInt(2, partida.getCdUsuarioId());
            stmt.setString(3, partida.getDtPartida());
            stmt.setString(4, partida.getDeResultado());
            stmt.setInt(5, partida.getVersao());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Método para fazer consulta de  Partida
    public List<Partida> read(Integer cdUsuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Partida> partidas = new ArrayList<>();

        try {
            String sql = cdUsuario == null ? 
                    "SELECT * FROM jdv_Partidas " : 
                    "SELECT * FROM jdv_Partidas WHERE cd_usuario_id = " + cdUsuario.toString();
                    
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Partida partida = new Partida();

                partida.setCdPartidaId(rs.getInt("cd_partida_id"));
                partida.setCdUsuarioId(rs.getInt("cd_usuario_id"));
                java.util.Date aData = rs.getDate("dt_partida");
                LocalDateTime dataRecup = aData == null ? null : LocalDateTime.parse(new SimpleDateFormat("yyyy-MM-dd").format(aData));
                partida.setDeResultado(rs.getString("de_resultado"));
                partida.setVersao(rs.getInt("versao"));
                
                partidas.add(partida);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return partidas;
    }

    // Método para alterar informações sobre Partida
    public void update(Partida partida) {
        
        String sql = "UPDATE jdv_Partidas "
                + "SET cd_usuario_id = ?, dt_partida = ?, "
                + "de_resultado = ?, "
                + "versao = ? WHERE cd_partida_id = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, partida.getCdUsuarioId());
            stmt.setString(2, partida.getDtPartida());
            stmt.setString(3, partida.getDeResultado());
            stmt.setInt(4, partida.getVersao());
            stmt.setInt(9, partida.getCdPartidaId());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Método para remover um Partida
    public void delete(Partida partida) {
        String sql = "DELETE FROM jdv_Partidas WHERE cd_partida_id = ?";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, partida.getCdPartidaId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
