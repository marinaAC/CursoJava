package ar.com.eduit.curso.java.entities;


public class Direccion {
    private String calle;
    private String nro;
    private String piso;
    private String depto;

    public Direccion(String calle, String nro, String piso, String depto) {
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.depto = depto;
    }

    public Direccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", nro=" + nro + ", piso=" + piso + ", depto=" + depto + '}';
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }
    
    
}
