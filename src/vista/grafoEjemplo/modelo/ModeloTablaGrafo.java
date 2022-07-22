/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.grafoEjemplo.modelo;

import controlador.tda.grafos.Grafo;
import controlador.tda.grafos.GrafoD;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sebastian
 */
public class ModeloTablaGrafo extends AbstractTableModel {

    private Grafo grafoD;
    private String[] columnas;

    //   1    2   3   4   5
    //1
    //2
    //3
    //4
    //5
    private String[] generarColumnas() {
        columnas = new String[grafoD.numVertices() + 1];
        columnas[0] = "/";
        for (int i = 1; i < columnas.length; i++) {
            columnas[i] = String.valueOf(i);
        }
        return columnas;
    }

    public Grafo getGrafo() {
        return grafoD;
    }

    public void setGrafo(Grafo grafoD) {
        this.grafoD = grafoD;
        generarColumnas();
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }

    @Override
    public int getRowCount() {
        return grafoD.numVertices();
    }

    @Override
    public int getColumnCount() {
        return grafoD.numVertices() + 1;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {//arg0 --> fila   arg1 --> columna
        if (arg1 == 0) {
            return columnas[arg0 + 1];
        } else {
            try {
                Object[] aux = grafoD.existeArista((arg0 + 1), arg1);
                if (((Boolean) aux[0])) {
                    return aux[1];
                } else {
                    return "-----";
                }
            } catch (Exception e) {
                System.out.println("Error en tabla "+e);
                return "";
            }
        }
    }

}
