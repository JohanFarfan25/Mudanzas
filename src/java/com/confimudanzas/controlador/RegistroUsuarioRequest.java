/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.controlador;

import com.confimudanzas.entity.Usuario;
import com.confimudanzas.facade.UsuarioFacadeLocal;
import com.confimudanzas.utilidades.Email;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author johan.farfan
 */
@Named(value = "registroUsuarioRequest")
@RequestScoped
public class RegistroUsuarioRequest {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    private Usuario usReg = new Usuario();
    private String correoRecuperar = "";

    private String Para;
    private String Sujeto = "";
    private String Mensaje = "";

    /**
     * Creates a new instance of RegistroUsuarioRequest
     */
    public RegistroUsuarioRequest() {
    }

    public void crearUsuario() {
        String mensajeSw = "";
        try {
            usReg.setFechaRegistro(new Date());
            usuarioFacadeLocal.create(usReg);
            mensajeSw = "swal('Usuario registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('El usuario' , ' Ya se encuentra registrado  ', 'error')";
        }
        usReg = new Usuario();
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void recuperarClave() {
        Usuario usuRecuperar = new Usuario();
        String mensajeSw = "";
        try {
            usuRecuperar = usuarioFacadeLocal.recuperarClave(correoRecuperar);
            if (usuRecuperar.getNombres() == null) {
                mensajeSw = "swal('El correo' , ' No se encuentra registrado  ', 'error')";
            } else {

                Email.sendClaves(usuRecuperar.getCorreo(),
                        usuRecuperar.getNombres() + " " + usuRecuperar.getApellidos(),
                        usuRecuperar.getCorreo(),
                        usuRecuperar.getClave());

                mensajeSw = "swal('La clave es enviada' , ' A su correo electronico  ', 'success')";
            }
        } catch (Exception e) {
            mensajeSw = "swal('El correo' , ' No se encuentra registrado  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }

    public void correoCotizacion() {
        String mensajeSw = "";
        try {
            Email.send(Para, Sujeto, Mensaje);
            mensajeSw = "swal('Cotización enviada' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('La  Cotización' , ' No pudo ser enviada  ', 'error')";
        }
        PrimeFaces.current().executeScript(mensajeSw);
    }
    

    public Usuario getUsReg() {
        return usReg;
    }

    public void setUsReg(Usuario usReg) {
        this.usReg = usReg;
    }

    public String getCorreoRecuperar() {
        return correoRecuperar;
    }

    public void setCorreoRecuperar(String correoRecuperar) {
        this.correoRecuperar = correoRecuperar;
    }

    public String getPara() {
        return Para;
    }

    public void setPara(String Para) {
        this.Para = Para;
    }

    public String getSujeto() {
        return Sujeto;
    }

    public void setSujeto(String Sujeto) {
        this.Sujeto = Sujeto;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

}
