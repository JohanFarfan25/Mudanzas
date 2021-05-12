/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.facade;

import com.confimudanzas.entity.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan.farfan
 */
@Local
public interface ProductoFacadeLocal {

    void create(Producto productos);

    void edit(Producto productos);

    void remove(Producto productos);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();
    
    public int contarPorCategoria(int fk_categoria);
    
    public List<Producto> listaPorCategoria(int fk_categoria);
    
}
