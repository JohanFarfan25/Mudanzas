/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johan.farfan
 */
@Entity
@Table(name = "quotes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quotes.findAll", query = "SELECT q FROM Quotes q"),
    @NamedQuery(name = "Quotes.findById", query = "SELECT q FROM Quotes q WHERE q.id = :id"),
    @NamedQuery(name = "Quotes.findByNombre", query = "SELECT q FROM Quotes q WHERE q.nombre = :nombre"),
    @NamedQuery(name = "Quotes.findByCorreo", query = "SELECT q FROM Quotes q WHERE q.correo = :correo"),
    @NamedQuery(name = "Quotes.findByNumeroTelefono", query = "SELECT q FROM Quotes q WHERE q.numeroTelefono = :numeroTelefono"),
    @NamedQuery(name = "Quotes.findByOrigen", query = "SELECT q FROM Quotes q WHERE q.origen = :origen"),
    @NamedQuery(name = "Quotes.findByDireccionOrigen", query = "SELECT q FROM Quotes q WHERE q.direccionOrigen = :direccionOrigen"),
    @NamedQuery(name = "Quotes.findByDestino", query = "SELECT q FROM Quotes q WHERE q.destino = :destino"),
    @NamedQuery(name = "Quotes.findByDireccionDestino", query = "SELECT q FROM Quotes q WHERE q.direccionDestino = :direccionDestino"),
    @NamedQuery(name = "Quotes.findByTipoMudanza", query = "SELECT q FROM Quotes q WHERE q.tipoMudanza = :tipoMudanza"),
    @NamedQuery(name = "Quotes.findByHorario", query = "SELECT q FROM Quotes q WHERE q.horario = :horario"),
    @NamedQuery(name = "Quotes.findByFechaMudanza", query = "SELECT q FROM Quotes q WHERE q.fechaMudanza = :fechaMudanza"),
    @NamedQuery(name = "Quotes.findByFechaSolicitud", query = "SELECT q FROM Quotes q WHERE q.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Quotes.findByEstado", query = "SELECT q FROM Quotes q WHERE q.estado = :estado")})
public class Quotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    @Column(name = "numero_telefono")
    private BigInteger numeroTelefono;
    @Size(max = 45)
    @Column(name = "origen")
    private String origen;
    @Size(max = 45)
    @Column(name = "direccion_origen")
    private String direccionOrigen;
    @Size(max = 45)
    @Column(name = "destino")
    private String destino;
    @Size(max = 45)
    @Column(name = "direccion_destino")
    private String direccionDestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_mudanza")
    private String tipoMudanza;
    @Size(max = 20)
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fecha_mudanza")
    private String fechaMudanza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Column(name = "Estado")
    private Integer estado;

    public Quotes() {
    }

    public Quotes(Integer id) {
        this.id = id;
    }

    public Quotes(Integer id, String nombre, String tipoMudanza, String fechaMudanza, Date fechaSolicitud) {
        this.id = id;
        this.nombre = nombre;
        this.tipoMudanza = tipoMudanza;
        this.fechaMudanza = fechaMudanza;
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public BigInteger getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(BigInteger numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getTipoMudanza() {
        return tipoMudanza;
    }

    public void setTipoMudanza(String tipoMudanza) {
        this.tipoMudanza = tipoMudanza;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFechaMudanza() {
        return fechaMudanza;
    }

    public void setFechaMudanza(String fechaMudanza) {
        this.fechaMudanza = fechaMudanza;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quotes)) {
            return false;
        }
        Quotes other = (Quotes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.confimudanzas.entity.Quotes[ id=" + id + " ]";
    }
    
}
