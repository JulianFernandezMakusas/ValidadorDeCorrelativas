package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Inscripcion {

    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public boolean aprobada () {
        return materias.stream().allMatch(materia -> alumno.cumpleCorrelativas(materia));
    }

}
