
package universidadgrupo2023;

import java.time.LocalDate;
import universidadgrupo2023.accesoADatos.AlumnoData;
import universidadgrupo2023.accesoADatos.Conexion;
import universidadgrupo2023.entidades.Alumno;


public class UniversidadGrupo2023 {

    
    public static void main(String[] args) {
        //Conexion.getConexion();
        //guardarAlumno
//        Alumno jose=new Alumno (23222112,"Jose", "Gonzalez", LocalDate.of(1977,5, 1),true);
//        AlumnoData alu=new AlumnoData();
//        alu.guardarAlumno(jose);
        
        //modificarAlumno
////        Alumno jose=new Alumno (7,23222112,"Jose Maria", "Gonzalez", LocalDate.of(1977,5, 1),true);
//        AlumnoData alu=new AlumnoData();
//        alu.modificarAlumno(jose);
                
        //eliminarAlumno
//        Alumno jose=new Alumno (6,23222111,"Jose Maria", "Gonzalez", LocalDate.of(1977,5, 1),true);
//        AlumnoData alu=new AlumnoData();
//        alu.eliminarAlumno(7);
        
        //buscarAlumnoPorId
//        AlumnoData alu=new AlumnoData();
//        Alumno alumnoEncontrado=alu.buscarAlumnoPorId(6);
//        System.out.println("DNI: "+alumnoEncontrado.getDni());
//        System.out.println("NOMBRE: "+alumnoEncontrado.getNombre());
//        System.out.println("APELLIDO: "+alumnoEncontrado.getApellido());
//        System.out.println("FECHA DE NACIMIENTO: "+alumnoEncontrado.getFechaNacimiento());
//        
        //buscarAlumnoPorDni
        AlumnoData alu=new AlumnoData();
        Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(23222111);
        System.out.println("DNI: "+alumnoEncontrado.getDni());
        System.out.println("NOMBRE: "+alumnoEncontrado.getNombre());
        System.out.println("APELLIDO: "+alumnoEncontrado.getApellido());
        System.out.println("FECHA DE NACIMIENTO: "+alumnoEncontrado.getFechaNacimiento());
        
        //listarAlumnos
//        AlumnoData alu=new AlumnoData();
//        for (Alumno alumno:alu.listarAlumnos()) {
//            System.out.println("DNI "+alumno.getDni());
//            System.out.println("NOMBRE: "+alumno.getNombre());
//            System.out.println("APELLIDO: "+alumno.getApellido());
//            System.out.println("FECHA DE NACIMIENTO: "+alumno.getFechaNacimiento());
//            
//        }
        
    }
    
}
