import org.example.Alumno;
import org.example.Inscripcion;
import org.example.Materia;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidacionTest {
    private Materia analisisMatI,mateDiscreta, arquitectura, pdp, ssoo, algebra, algoritmos, analisisMatII;

    @Before
    public void setup() {
        algoritmos = new Materia("Algoritmos");
        arquitectura = new Materia("Arquitectura");
        mateDiscreta = new Materia("MatematicaDiscreta");
        analisisMatI = new Materia("AnalisisMatematicoI");
        analisisMatII = new Materia("AnalisisMatematicoII");
        algebra = new Materia("Algebra");
        pdp = new Materia("ParadigmasDeProgramacion");
        ssoo = new Materia("SistemasOperativos");
        analisisMatII.getCorrelativas().add(analisisMatI);
        analisisMatII.getCorrelativas().add(algebra);
        pdp.getCorrelativas().add(algoritmos);
        pdp.getCorrelativas().add(mateDiscreta);
        ssoo.getCorrelativas().add(algoritmos);
        ssoo.getCorrelativas().add(arquitectura);

    }
    @Test
    public void cumpleCorrelativa1(){
        Alumno alumno = createAlumno("Davina", mateDiscreta, analisisMatI);
        Inscripcion Inscripcion = createInscripcion(alumno,analisisMatII );
        Assert.assertFalse(Inscripcion.aprobada());
    }
    @Test
    public void cumpleCorrelativas2(){
        Alumno alumno = createAlumno("Masumi", algebra,analisisMatI,algoritmos,mateDiscreta);
        Inscripcion Inscripcion = createInscripcion(alumno, analisisMatII,pdp);
        Assert.assertEquals(true, Inscripcion.aprobada());
    }
    @Test
    public void cumpleCorrelativas3(){

        Alumno alumno = createAlumno("Candy",algoritmos, mateDiscreta,analisisMatI);
        Inscripcion Inscripcion = createInscripcion(alumno, analisisMatII,pdp);
        Assert.assertFalse(Inscripcion.aprobada());
    }

    private Alumno createAlumno(String nombre, Materia ...materiasAp){
        Alumno alumno = new Alumno(nombre);
        for(Materia materia : materiasAp){
            alumno.getMateriasAprobadas().add(materia);
        }
        return alumno;
    }
    private Inscripcion createInscripcion(Alumno alumno, Materia ...materias){
        Inscripcion Inscripcion = new Inscripcion(alumno);
        for(Materia materia : materias){
            Inscripcion.getMaterias().add(materia);

        }
        return Inscripcion;
    }
}
