/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.confimudanzas.controlador;

import com.confimudanzas.entity.Categoria;
import com.confimudanzas.entity.Producto;
import com.confimudanzas.facade.CategoriaFacadeLocal;
import com.confimudanzas.facade.ProductoFacadeLocal;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.PrimeFaces;

/**
 *
 * @author johan.farfan
 */
@Named(value = "productosView")
@ViewScoped
public class ProductosView implements Serializable{

    
    @EJB
    ProductoFacadeLocal productoFacadeLocal;
    @EJB
    CategoriaFacadeLocal categoriaFacadeLocal;

    private Categoria objCategoria = new Categoria();
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();

    private Producto objProductoNew = new Producto();
    private List<Producto> listaProductos = null;
    private int id_cat_selec = 0;
    private Part archivoImagen;
    private Part archivoExcel;
    private String nombreArchivo;
    
    @PostConstruct
    public void cargaCategorias() {
        try {
            objCategoria = categoriaFacadeLocal.find(1);
            listaCategorias.addAll(categoriaFacadeLocal.findAll());            
            listaProductos = productoFacadeLocal.findAll();            
            
        } catch (Exception e) {
            System.out.println("com.confimudanzas.controlador.ProductosView.cargaCategorias() " + e.getMessage());
        }
    }
    
    
    /**
     * Creates a new instance of ProductosView
     */
    public ProductosView() {
    }
    
     public int contarPorCategoria() {
        return productoFacadeLocal.contarPorCategoria(objCategoria.getIdcategorias());
    }

    public List<Producto> listarPorCategoria() {
        return productoFacadeLocal.listaPorCategoria(objCategoria.getIdcategorias());
    }
    
    
    public void leerProducto(Producto pt) {

        objProductoNew = pt;
    }

    public void subeImagen() {
        String mensajeSw = "";
        if (archivoImagen != null) {
            if (archivoImagen.getSize() < 4000000) {
                if ("image/png".equals(archivoImagen.getContentType())) {
                    File carpeta = new File("C:/confimudanzas/Productos/Categorias");
                    if (!carpeta.exists()) {
                        carpeta.mkdirs();
                    }
                    try (InputStream is = archivoImagen.getInputStream()) {
                        SimpleDateFormat ffecha = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                        Calendar hoy = Calendar.getInstance();
                        String renombraArchivo = ffecha.format(hoy.getTime()) + ".";
                        renombraArchivo += FilenameUtils.getExtension(archivoImagen.getSubmittedFileName());
                        Files.copy(is, (new File(carpeta, renombraArchivo)).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        nombreArchivo = renombraArchivo;
                    } catch (Exception e) {
                    }

                } else {
                    mensajeSw = "swal('El archivo' , ' no es una imagen ', 'error')";
                }
            } else {
                mensajeSw = "swal('La imagen' , ' es muy grande  ', 'error')";
            }
        } else {
            mensajeSw = "swal('No se subio' , ' Una imagen  ', 'error')";
        }

      PrimeFaces.current().executeScript(mensajeSw);
    }
  

    public void crearProducto() {
        String mensajeSw = "";
        try {
            Categoria obt = categoriaFacadeLocal.find(id_cat_selec);
            objProductoNew.setFkCategoria(obt);
            objProductoNew.setImagenRuta(nombreArchivo);
            productoFacadeLocal.create(objProductoNew);
       
            mensajeSw = "swal('Producto registrado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas ingresando ' un nuevo producto  ', 'error')";
        }
        objProductoNew = new Producto();
       listaProductos = productoFacadeLocal.findAll();
       PrimeFaces.current().executeScript(mensajeSw);
    }
    
    public void eliminarProducto() {
        String mensajeSw = "";
        try {            
            productoFacadeLocal.remove(objProductoNew);
            mensajeSw = "swal('Producto eliminado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas eliminando ' el producto  ', 'error')";
        }
        
        objProductoNew = new Producto();
       listaProductos = productoFacadeLocal.findAll();
       PrimeFaces.current().executeScript(mensajeSw);
       
    }
    
    public void editarProducto() {
        String mensajeSw = "";
        try {
            Categoria obt = categoriaFacadeLocal.find(id_cat_selec);
            objProductoNew.setFkCategoria(obt);
            objProductoNew.setImagenRuta(nombreArchivo);
            productoFacadeLocal.edit(objProductoNew);
       
            mensajeSw = "swal('Producto editado' , ' con exito ', 'success')";
        } catch (Exception e) {
            mensajeSw = "swal('Problemas editando ' el produvto  ', 'error')";
        }
        objProductoNew = new Producto();
       listaProductos = productoFacadeLocal.findAll();
       PrimeFaces.current().executeScript(mensajeSw);
    }

    public int catidadProductos() {
        return productoFacadeLocal.count();
    }

    public void selecionCategoria(int idCategoria) {
        objCategoria = categoriaFacadeLocal.find(idCategoria);
    }

    public void setObjCategoria(Categoria objCategoria) {
        this.objCategoria = objCategoria;
    }

    public Categoria getObjCategoria() {
        return objCategoria;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public Producto getObjProductoNew() {
        return objProductoNew;
    }

    public void setObjProductoNew(Producto objProductoNew) {
        this.objProductoNew = objProductoNew;
    }

    public int getId_cat_selec() {
        return id_cat_selec;
    }

    public void setId_cat_selec(int id_cat_selec) {
        this.id_cat_selec = id_cat_selec;
    }

    public Part getArchivoImagen() {
        return archivoImagen;
    }

    public void setArchivoImagen(Part archivoImagen) {
        this.archivoImagen = archivoImagen;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Part getArchivoExcel() {
        return archivoExcel;
    }

    public void setArchivoExcel(Part archivoExcel) {
        this.archivoExcel = archivoExcel;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    
}
