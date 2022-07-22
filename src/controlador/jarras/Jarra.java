/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.jarras;

/**
 *
 * @author kali
 */
public class Jarra {
    private Integer capacidad;
    private Integer capacidad_actual;

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the capacidad_actual
     */
    public Integer getCapacidad_actual() {
        return capacidad_actual;
    }

    /**
     * @param capacidad_actual the capacidad_actual to set
     */
    public void setCapacidad_actual(Integer capacidad_actual) {
        this.capacidad_actual = capacidad_actual;
    }

    @Override
    public String toString() {
        return "Jarr{" + "capacidad=" + capacidad + ", capacidad_actual=" + capacidad_actual + '}';
    }
    
    
}
