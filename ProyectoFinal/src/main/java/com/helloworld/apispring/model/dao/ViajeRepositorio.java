/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Reserva;
import com.helloworld.apispring.model.entity.Usuario;
import com.helloworld.apispring.model.entity.Viaje;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ViajeRepositorio {
    
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
    
    public List<Viaje> obtenerAllViajes()
    {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viaje.class); 
        return criteria.list(); 
    }
    
    public List<Viaje> obtenerViajeByIdViaje(int idViaje){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viaje.class);
        
        criteria.add(Restrictions.eq("idViaje", idViaje));
        return criteria.list();
    }
    
    public List<Viaje> obtenerUltimos10Viajes(){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viaje.class);
        criteria.addOrder(Order.desc("fecha"));
        if(criteria.list().size() >= 10){
            return criteria.list().subList(0, 9);
        }else{
            return criteria.list();
        }
    }
    
    public List<Viaje> obtenerViajesByFechaOrigenAndDestino(Date fecha, String origen, String destino){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viaje.class);
        criteria.add(Restrictions.eq("fecha", fecha));
        criteria.add(Restrictions.eq("origen", origen));
        criteria.add(Restrictions.eq("destino", destino));
        
        return criteria.list(); 
   }
    
    @Transactional
    public long actualizarEstadoViajeByIdViaje(int idViaje, String estado) {
        List<Viaje> viaje = obtenerViajeByIdViaje(idViaje);
        try{
            viaje.get(0).setEstado(estado);
            Serializable save = getSessionFactory().getCurrentSession().save(viaje.get(0));
            return viaje.get(0).getIdViaje();
        }
        catch(Exception e){
            return 0;  
        }
    }
     public long  crearViaje(Viaje viaje) {
        Serializable save = getSessionFactory().getCurrentSession().save(viaje);
        return viaje.getIdViaje();
    }
     
     public List<Viaje> obtenerDetallesViaje(Date fecha, String origen, String destino, String hora, Double precio, Integer numeroCupos){
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Viaje.class);
        criteria.add(Restrictions.eq("fecha", fecha));
        criteria.add(Restrictions.eq("origen", origen));
        criteria.add(Restrictions.eq("destino", destino));
        criteria.add(Restrictions.eq("hora", hora));
        criteria.add(Restrictions.eq("precio", precio));
        criteria.add(Restrictions.eq("numeroCupos", numeroCupos));
        return criteria.list(); 
   }
}