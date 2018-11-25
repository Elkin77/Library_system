/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.dao;

import com.helloworld.apispring.model.entity.Ranking_fifa;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BOG-A209-E-015
 */
@Repository
@Transactional(readOnly = true)
public class Ranking_repositorio {

    @Autowired

    private SessionFactory sesionFactory;

    public SessionFactory getSesionFactory() {
        return sesionFactory;
    }

    public void setSesionFactory(SessionFactory sesionFactory) {
        this.sesionFactory = sesionFactory;
    }

    public Ranking_repositorio() {
    }

    public List<Ranking_fifa> getEquipo() {
        Criteria cr = getSesionFactory().getCurrentSession().createCriteria(Ranking_fifa.class);
        cr.add(Restrictions.eq("Confederation", "CONMEBOL"));
        cr.add(Restrictions.between("Fecha", 2017,2018));

        return cr.list();

    }
    
     public List<Ranking_fifa> getEquipoByConfe(String confe) {
        Criteria cr = getSesionFactory().getCurrentSession().createCriteria(Ranking_fifa.class);
        cr.add(Restrictions.eq("Confederation", confe));

        return cr.list();

    }
     
     public long  crearRanking(Ranking_fifa ranking) {
        Serializable save = getSesionFactory().getCurrentSession().save(ranking);
        return ranking.getRankID();
    }

}
