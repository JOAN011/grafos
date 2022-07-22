/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.jarras;

import controlador.tda.arboles.NodoArbol;
import controlador.tda.lista.ListaEnlazada;

/**
 *
 * @author kali
 */
public class ArbolJarras {
    //0 0   4 3
    //4 3   2 3
    NodoJarras estado_inicial;
    NodoJarras estado_final;
    ListaEnlazada<NodoJarras> nodos;
    ListaEnlazada<NodoJarras> lista_nodos;

    public ArbolJarras() {
    }
    
    public ArbolJarras(NodoJarras ei, NodoJarras ef) {
        this.estado_inicial = ei;
        this.estado_final = ef;
        nodos = new ListaEnlazada<>();
        lista_nodos = new ListaEnlazada<>();
    }
    
    public NodoJarras busqueda_anchura() throws Exception{
        if(estado_inicial != null && estado_final !=null){
            if(NodoJarras.comparar(estado_inicial, estado_final)){
                nodos = new ListaEnlazada<>();
                nodos.insertarCabecera(estado_final);
                return estado_final;
            } else {
                nodos = new ListaEnlazada<>();
                lista_nodos = new ListaEnlazada<>();
                lista_nodos.insertar(estado_inicial, Reglas.posicion(lista_nodos));
                while (lista_nodos.getSize() > 0) {                    
                    //programar la busqueda en anchura
                }
            }
        }
        return null;
    }
}
