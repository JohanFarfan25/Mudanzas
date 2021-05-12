/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.facade;

import com.confimudanzas.entity.Categoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan.farfan
 */
@Local
public interface CategoriaFacadeLocal {

    void create(Categoria categorias);

    void edit(Categoria categorias);

    void remove(Categoria categorias);

    Categoria find(Object id);

    List<Categoria> findAll();

    List<Categoria> findRange(int[] range);

    int count();
    
}
