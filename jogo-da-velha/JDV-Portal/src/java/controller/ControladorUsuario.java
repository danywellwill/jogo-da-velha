/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Jr
 */
public class ControladorUsuario extends Usuario{
    public List<Usuario> read(Integer id){
        UsuarioDao dao = new UsuarioDao();
        
        return dao.read(id);
    }
}
