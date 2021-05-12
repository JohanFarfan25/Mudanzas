/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.facade;

import com.confimudanzas.entity.Quotes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johan.farfan
 */
@Stateless
public class QuotesFacade extends AbstractFacade<Quotes> implements QuotesFacadeLocal {

    @PersistenceContext(unitName = "ConfiMudanzasPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuotesFacade() {
        super(Quotes.class);
    }
    
}
