package com.example.ventas_nueva.Dao;

import com.example.ventas_nueva.app.MyApplication;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ClienteDAO extends RealmObject {
    @PrimaryKey
    private int id;
    @Required
    private String nombre;
    @Required
    private String apellidos;
    @Required
    private  String listaprecio;
    private double saldo;
    private int tipopago = 0;
    private int plazo = 0;
    @Required
    private String diasvisita;
    @Required
    private String ordenvisita;
    @Required
    private String iva;
    @Required
    private String status;
    @Required
    private String vendedor;
    private int ivaFronterizo;
    //Fecha de entrega
    @Required
    private Date fechaEntrega = null;
    private int entregaModificable;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getListaprecio() {
        return listaprecio;
    }

    public void setListaprecio(String listaprecio) {
        this.listaprecio = listaprecio;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTipopago() {
        return tipopago;
    }

    public void setTipopago(int tipopago) {
        this.tipopago = tipopago;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getDiasvisita() {
        return diasvisita;
    }

    public void setDiasvisita(String diasvisita) {
        this.diasvisita = diasvisita;
    }

    public String getOrdenvisita() {
        return ordenvisita;
    }

    public void setOrdenvisita(String ordenvisita) {
        this.ordenvisita = ordenvisita;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getIvaFronterizo() {
        return ivaFronterizo;
    }

    public void setIvaFronterizo(int ivaFronterizo) {
        this.ivaFronterizo = ivaFronterizo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getEntregaModificable() {
        return entregaModificable;
    }

    public void setEntregaModificable(int entregaModificable) {
        this.entregaModificable = entregaModificable;
    }

    public Date getFechaEntregaFinal() {
        return fechaEntregaFinal;
    }

    public void setFechaEntregaFinal(Date fechaEntregaFinal) {
        this.fechaEntregaFinal = fechaEntregaFinal;
    }

    @Required
    private Date fechaEntregaFinal = null;

    public ClienteDAO() {
    }

    public void setId(int id){
        this.id = MyApplication.ClienteId.incrementAndGet();
        this.id=0;
    }
    public int getId(){
        return id;
    }
}
