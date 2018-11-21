/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Login;
import com.helloworld.apispring.model.entity.Reserva;
import com.helloworld.apispring.model.entity.Usuario;
import com.helloworld.apispring.model.entity.Viaje;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioRepositorio {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory()
    {
         return sessionFactory;
    }
    
    public void getSessionFactory (SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    
    public List<Usuario> obtenerAllUsuarios()
    {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuario.class);
        return criteria.list(); 
    }
    
    public Usuario obtenerUsuarioByUsuario(String usuario)
    {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return (Usuario) criteria.list().get(0); 
    }
    
    @Transactional
    public long crearUsuario(Usuario usuario) {
        Serializable save = getSessionFactory().getCurrentSession().save(usuario);
        return usuario.getIdUsuario();
    }
    
    public Login login(String usuario, String password){
        Login login;
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Usuario.class); 
        criteria.add(Restrictions.eq("usuario", usuario));
        
        List<Usuario> lstUsuario = criteria.list();
        
        if(!lstUsuario.isEmpty()){
            criteria.add(Restrictions.eq("password", password));
            
            lstUsuario = criteria.list();
            
            if(!lstUsuario.isEmpty()){
                login = new Login(
                        true,
                        "",
                        lstUsuario.get(0).getUsuario(),
                        lstUsuario.get(0).getTipoUsuario()
                );
            }else{
                login = new Login(
                        false,
                        "ERROR, Contraseña incorrecta",
                        "",
                        ""
                );
            }
        }else{
            login = new Login(
                        false,
                        "ERROR, Usuario y Contraseña incorrectas",
                        "",
                        ""
                );
        }
        
        return login;
    }
    
}
