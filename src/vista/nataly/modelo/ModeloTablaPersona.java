/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.nataly.modelo;

import controlador.tda.grafos.GrafoEND;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author sebastian
 */
public class ModeloTablaPersona extends AbstractTableModel {

    private GrafoEND<Persona> grafo;

    public GrafoEND<Persona> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoEND<Persona> grafo) {
        this.grafo = grafo;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return grafo.numVertices();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombres";
            case 2:
                return "Tipo";
            case 3:
                return "Ubicacion";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        try {
            Persona p = grafo.obtenerEtiqueta(arg0 + 1);
            switch (arg1) {
                case 0:
                    return (arg0+1);
                case 1:
                    return p.getNombres();
                case 2:
                    return p.getTipoPersona().toString();
                case 3:
                    return (p.getUbicacion() == null) ? "NO TIENE" : p.getUbicacion().toString();
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Error en listado");
            return null;
        }
    }

}
