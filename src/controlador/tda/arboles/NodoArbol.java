/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.tda.arboles;

/**
 *
 * @author kali
 */
public class NodoArbol {
    private NodoArbol padre;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    private Integer valor;

    public NodoArbol(Integer valor) {
        this.valor = valor;
        padre = null;
        izquierda = null;
        derecha = null;
    }
    

    /**
     * @return the padre
     */
    public NodoArbol getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    /**
     * @return the izquierda
     */
    public NodoArbol getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public NodoArbol getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the valor
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        return "(" + valor + ")";
    }
}
