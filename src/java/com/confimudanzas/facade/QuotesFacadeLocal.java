/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.facade;

import com.confimudanzas.entity.Quotes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan.farfan
 */
@Local
public interface QuotesFacadeLocal {

    void create(Quotes quotes);

    void edit(Quotes quotes);

    void remove(Quotes quotes);

    Quotes find(Object id);

    List<Quotes> findAll();

    List<Quotes> findRange(int[] range);

    int count();
    
}
