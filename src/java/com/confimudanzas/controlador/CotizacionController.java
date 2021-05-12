/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.controlador;

import com.confimudanzas.facade.QuotesFacadeLocal;
import com.confimudanzas.entity.Quotes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author johan.farfan
 */
@Named(value = "cotizacionController")
@SessionScoped
public class CotizacionController implements Serializable {

    @EJB
    private QuotesFacadeLocal ejbFacade;
    private List<Quotes> items = null;
    private Quotes selected;

    @PostConstruct
    public void inicial() {

        items = ejbFacade.findAll();
        selected = new Quotes();

    }

    public CotizacionController() {

    }

    public int catidadCotizacionesSinGestionar() {
        return ejbFacade.count();
    }

    public void leer(Quotes Seleccion) {

        selected = Seleccion;
    }

    public void crearCotizacion() {
        String mensajeSw = "";
        try {

            selected.setEstado(new Integer("0"));
            selected.setFechaSolicitud(new Date());
            ejbFacade.create(selected);
            mensajeSw = "swal('¡Cotización enviada!' , ' Pronto nos comunicaremos contigo ', 'success')";
        } catch (Exception e) {

            mensajeSw = "swal('La cotización' , ' No se pudo ser  enviar  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
        items = ejbFacade.findAll();
        selected = new Quotes();
    }

    public void modificarCotizacion() {
        String mensajeSw = "";
        try {

            ejbFacade.edit(selected);
            mensajeSw = "swal('¡Cotización editada!' , ' Con exito', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('La cotización' , ' No se pudo ser  editar  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
        items = ejbFacade.findAll();
        selected = new Quotes();
    }

    public void gestionarCotizacion() {
        String mensajeSw = "";
        try {
            selected.setEstado(new Integer("1"));
            ejbFacade.edit(selected);
            mensajeSw = "swal('¡Cotización Gestionada!' , ' Con exito', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('La cotización' , ' No se pudo ser  gestionar  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
        items = ejbFacade.findAll();
        selected = new Quotes();
    }

    public void eliminarCotizacion() {
        String mensajeSw = "";
        try {

            ejbFacade.remove(selected);
            mensajeSw = "swal('¡Cotización Eliminada!' , ' Con exito', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('La cotización' , ' No se pudo ser  eliminar  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
        items = ejbFacade.findAll();
    }

    public List<Quotes> getItems() {
        return items;
    }

    public void setItems(List<Quotes> items) {
        this.items = items;
    }

    public Quotes getSelected() {
        return selected;
    }

    public void setSelected(Quotes selected) {
        this.selected = selected;
    }

}
