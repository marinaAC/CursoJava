package ar.com.eduit.curso.java.entities;

import java.util.ArrayList;
import java.util.List;

public class ClienteEmpresa {
    private int nro;
    private String razonSocial;
    private String direccion;
    private List<Cuenta> cuentas;
    public ClienteEmpresa(int nro, String razonSocial, String direccion) {
        this.nro=nro;
        this.razonSocial=razonSocial;
        this.direccion=direccion;
        this.cuentas=new ArrayList();
    }
    @Override
    public String toString() {
        return "ClienteEmpresa{" + "nro=" + nro + ", razonSocial=" + razonSocial + ", direccion=" + direccion + '}';
    }
    public int getNro() {
        return nro;
    }
    public void setNro(int nro) {
        this.nro = nro;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
