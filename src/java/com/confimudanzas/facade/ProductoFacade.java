/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.facade;

import com.confimudanzas.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author johan.farfan
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "ConfiMudanzasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
     public int contarPorCategoria(int fk_categoria){
        try {
            Query qt = em.createNativeQuery("SELECT count(*) FROM productos WHERE fk_categoria = ?");
            qt.setParameter(1, fk_categoria);
            return ((Number)qt.getSingleResult()).intValue();
        } catch (Exception e) {
            System.out.println("com.confimudanzas.facade.ProductoFacade.contarPorCategoria() " + e.getMessage());
            return 0;
        }
    }
    
    
    @Override
    public List<Producto> listaPorCategoria (int fk_categoria){
        try {
            Query qt = em.createQuery("SELECT p FROM Producto p WHERE p.fkCategoria.idcategorias = :fk_categoria");
            qt.setParameter("fk_categoria", fk_categoria);
            return qt.getResultList();
        } catch (Exception e) {
            System.out.println("com.confimudanzas.facade.listaPorCategoria() " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
}
