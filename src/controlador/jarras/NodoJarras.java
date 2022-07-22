/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.jarras;

import controlador.tda.lista.ListaEnlazada;

/**
 *
 * @author kali
 */
public class NodoJarras {
    private Jarra jarraG;
    private Jarra jarraP;
    private NodoJarras padre; //posicion inicial 0,0
    private ListaEnlazada<NodoJarras> sucesores;

    public NodoJarras() {
        jarraG = new Jarra();
        jarraP = new Jarra();
        jarraG.setCapacidad(4);
        jarraP.setCapacidad(3);
        jarraG.setCapacidad_actual(0);
        jarraP.setCapacidad_actual(0);
    }
    
    public NodoJarras(Integer jg, Integer jp) {
        this();
        jarraG.setCapacidad_actual(jg);
        jarraP.setCapacidad_actual(jp);
    }
    
    
    public static Boolean comparar(NodoJarras i, NodoJarras f){
        if (i != null && f != null) {
            if (i.getJarraG().getCapacidad_actual().intValue() == f.getJarraG().getCapacidad_actual().intValue() && i.getJarraP().getCapacidad_actual().intValue() == f.getJarraP().getCapacidad_actual().intValue()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "NodoJarras{" + "jarraG=" + jarraG + ", jarraP=" + jarraP + ", padre=" + padre + ", sucesores=" + sucesores + '}';
    }

    /**
     * @return the jarraG
     */
    public Jarra getJarraG() {
        return jarraG;
    }

    /**
     * @param jarraG the jarraG to set
     */
    public void setJarraG(Jarra jarraG) {
        this.jarraG = jarraG;
    }

    /**
     * @return the jarraP
     */
    public Jarra getJarraP() {
        return jarraP;
    }

    /**
     * @param jarraP the jarraP to set
     */
    public void setJarraP(Jarra jarraP) {
        this.jarraP = jarraP;
    }

    /**
     * @return the padre
     */
    public NodoJarras getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoJarras padre) {
        this.padre = padre;
    }

    /**
     * @return the sucesores
     */
    public ListaEnlazada<NodoJarras> getSucesores() {
        return sucesores;
    }

    /**
     * @param sucesores the sucesores to set
     */
    public void setSucesores(ListaEnlazada<NodoJarras> sucesores) {
        this.sucesores = sucesores;
    }
        
}
