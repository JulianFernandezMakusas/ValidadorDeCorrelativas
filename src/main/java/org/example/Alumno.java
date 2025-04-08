package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Alumno {

    private String nombre;
    private String apellido;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public boolean cumpleCorrelativas(Materia materia) {
        return materiasAprobadas.containsAll(materia.getCorrelativas());
    }

}
