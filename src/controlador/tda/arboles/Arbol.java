/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.tda.arboles;

import controlador.tda.lista.ListaEnlazada;
import controlador.tda.lista.exception.PosicionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kali
 */
public class Arbol {

    private NodoArbol raiz;
    private Integer size;
    private Integer altura;
    private ListaEnlazada<ListaEnlazada<NodoArbol>> niveles;
    private ListaEnlazada<NodoArbol> orden;

    public Arbol() {
        raiz = null;
        altura = 0;
        size = 0;
        niveles = new ListaEnlazada<>();
        orden = new ListaEnlazada<>();
    }

    public Boolean insertar(Integer valor) {
        if (raiz == null) {
            raiz = new NodoArbol(valor);
            size++;
            this.altura = calcularAltura(raiz);
            niveles = new ListaEnlazada<>();
            for (int i = 0; i <= this.altura; i++) {
                try {
                    niveles.insertarCabecera(new ListaEnlazada<>());
                } catch (Exception ex) {
                    System.out.println("ERROR " + ex);
                }
            }
            calcularNivel(raiz, 0);
            try {
                niveles.eliminarDato(niveles.getSize() - 1);
            } catch (PosicionException ex) {
                System.out.println("ERROR EN BORRADO" + ex);
            }
            return true;
        } else {
            NodoArbol nuevo = new NodoArbol(valor);
            NodoArbol actual = raiz;
            NodoArbol padre;
            while (true) {
                padre = actual;
                if (valor.intValue() == actual.getValor().intValue()) {
                    return false;
                } else if (valor.intValue() < actual.getValor().intValue()) {
                    actual = actual.getIzquierda();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setIzquierda(nuevo);
                        size++;
                        this.altura = calcularAltura(raiz);
                        niveles = new ListaEnlazada<>();
                        for (int i = 0; i <= this.altura; i++) {
                            try {
                                niveles.insertarCabecera(new ListaEnlazada<>());
                            } catch (Exception ex) {
                                System.out.println("ERROR " + ex);
                            }
                        }
                        calcularNivel(raiz, 0);
                        try {
                            niveles.eliminarDato(niveles.getSize() - 1);
                        } catch (PosicionException ex) {
                            System.out.println("ERROR EN BORRADO" + ex);
                        }
                        return true;
                    }

                } else {
                    actual = actual.getDerecha();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setDerecha(nuevo);
                        size++;
                        this.altura = calcularAltura(raiz);
                        niveles = new ListaEnlazada<>();
                        for (int i = 0; i <= this.altura; i++) {
                            try {
                                niveles.insertarCabecera(new ListaEnlazada<>());
                            } catch (Exception ex) {
                                System.out.println("ERROR " + ex);
                            }
                        }
                        calcularNivel(raiz, 0);
                        try {
                            niveles.eliminarDato(niveles.getSize() - 1);
                        } catch (PosicionException ex) {
                            System.out.println("ERROR EN BORRADO" + ex);
                        }
                        return true;
                    }
                }
            }
        }
        //return false;
    }

    public void calcularNivel(NodoArbol arbol, Integer nivel) {
        try {
            if (arbol != null) {
                int pos = (niveles.obtenerDato(nivel).getSize() > 0) ? niveles.obtenerDato(nivel).getSize() - 1 : 0;
                niveles.obtenerDato(nivel).insertar(arbol, pos);
                nivel++;
                calcularNivel(arbol.getIzquierda(), nivel);
                calcularNivel(arbol.getDerecha(), nivel);
            } else if (nivel != getAltura()) {
                int pos = (niveles.obtenerDato(nivel).getSize() > 0) ? niveles.obtenerDato(nivel).getSize() - 1 : 0;
                niveles.obtenerDato(nivel).insertar(null, pos);
                nivel++;
                calcularNivel(null, nivel);
                calcularNivel(null, nivel);
            }
        } catch (Exception e) {
            System.out.println("Error en niveles " + e);
            //e.printStackTrace();
        }
    }

    public Integer calcularAltura(NodoArbol arbol) {
        if (arbol == null) {
            return 0;
        } else {
            Integer izquierda = calcularAltura(arbol.getIzquierda());
            Integer derecha = calcularAltura(arbol.getDerecha());
            if (izquierda > derecha) {
                return (izquierda + 1);
            } else {
                return (derecha + 1);
            }
        }
    }

    /**
     * @return the raiz
     */
    public NodoArbol getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the altura
     */
    public Integer getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    /**
     * @return the niveles
     */
    public ListaEnlazada<ListaEnlazada<NodoArbol>> getNiveles() {
        return niveles;
    }

    /**
     * @param niveles the niveles to set
     */
    public void setNiveles(ListaEnlazada<ListaEnlazada<NodoArbol>> niveles) {
        this.niveles = niveles;
    }

    /**
     * @return the orden
     */
    public ListaEnlazada<NodoArbol> getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(ListaEnlazada<NodoArbol> orden) {
        this.orden = orden;
    }

    public static void main(String[] args) {

        Arbol a = new Arbol();
        a.insertar(56);
        a.insertar(96);
        a.insertar(36);
        a.insertar(16);
        a.insertar(37);
        System.out.println("Nro de nodos " + a.getSize());
        System.out.println("altura " + a.getAltura());
        System.out.println("Niveles " + a.getNiveles().getSize());
        System.out.println("IMprimir niveles");
        try {
            //ListaEnlazada<NodoArbol> lista = a.getNiveles().obtenerDato(a.getNiveles().getSize() - 1);
            a.getNiveles().imprimir();
            Integer posicion = 100;
            for (int i = 0; i <= a.getNiveles().getSize(); i++) {
                ListaEnlazada aux = a.getNiveles().obtenerDato(i);
                Integer posA = posicion / aux.getSize();
                String cadena = a.posiciones(posA);
                System.out.println("");
                Integer espacios = posA;
                for (int j = 0; j < 10; j++) {
                    if (aux.obtenerDato(j) != null) {
                        System.out.println(cadena + aux.obtenerDato(j) + "\t");
                        espacios += posA;
                        //cadena = a.posiciones(espacios);
                    } else {
                        System.out.println(cadena);
                    }

                }
                //a.getNiveles().obtenerDato(i).imprimir();
//                ListaEnlazada<NodoArbol> aux = a.getNiveles().obtenerDato(i);
//                for (int j = 0; j < aux.getSize(); j++) {
//                    if (aux.obtenerDato(j) != null) {
//                        System.out.println(aux.obtenerDato(j) + "\t");
//                    } else {
//                        System.out.println("\t");
//                    }
//                }
//                System.out.println("");
                //aux.imprimir();
                //System.out.println("" + a.getNiveles().obtenerDato(i).getSize() + "--");
                //System.out.println(" " + lista.obtenerDato(i));
                //a.getNiveles().obtenerDato(i).imprimir();
            }
            //a.preOrder().imprimir();
        } catch (PosicionException ex) {
            Logger.getLogger(Arbol.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("PRE ORDER");
        a.preOrder().imprimir();
        System.out.println("POS ORDER");
        a.posOrder().imprimir();
        System.out.println("IN ORDER");
        a.inOrder().imprimir();
    }

    public String posiciones(Integer aux) {
        StringBuilder cadena = new StringBuilder();
        return null;
    }
    
    private void preOrder(NodoArbol arbol) throws PosicionException{
        if (arbol != null) {
            int pos = (orden.getSize() > 0) ? orden.getSize() - 1 : 0;
            orden.insertar(arbol, pos);
            preOrder(arbol.getIzquierda());
            preOrder(arbol.getDerecha());
        }
    }
    
    public ListaEnlazada<NodoArbol> preOrder(){
        orden = new ListaEnlazada<>();
        try {
            preOrder(raiz);
        } catch (PosicionException ex) {
            System.out.println("ERROR" + ex);
        }
        return orden;
    }
    
    private void posOrder(NodoArbol arbol) throws PosicionException{
        if (arbol != null) {        
            posOrder(arbol.getIzquierda());
            posOrder(arbol.getDerecha());
            int pos = (orden.getSize() > 0) ? orden.getSize() - 1 : 0;
            orden.insertar(arbol, pos);
        }
    }
    
    public ListaEnlazada<NodoArbol> posOrder(){
        orden = new ListaEnlazada<>();
        try {
            posOrder(raiz);
        } catch (PosicionException ex) {
            System.out.println("ERROR" + ex);
        }
        return orden;
    }
    
    private void inOrder(NodoArbol arbol) throws PosicionException{
        if (arbol != null) {        
            inOrder(arbol.getIzquierda());
            int pos = (orden.getSize() > 0) ? orden.getSize() - 1 : 0;
            orden.insertar(arbol, pos);
            inOrder(arbol.getDerecha());

        }
    }
    
    public ListaEnlazada<NodoArbol> inOrder(){
        orden = new ListaEnlazada<>();
        try {
            inOrder(raiz);
        } catch (PosicionException ex) {
            System.out.println("ERROR" + ex);
        }
        return orden;
    }
}
