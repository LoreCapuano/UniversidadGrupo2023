
package universidadgrupo2023;

import java.time.LocalDate;
import universidadgrupo2023.accesoADatos.AlumnoData;
import universidadgrupo2023.accesoADatos.Conexion;
import universidadgrupo2023.accesoADatos.DataMateria;

import universidadgrupo2023.accesoADatos.inscripData;

import universidadgrupo2023.entidades.Alumno;
import universidadgrupo2023.entidades.Inscripcion;
import universidadgrupo2023.entidades.Materia;


public class UniversidadGrupo2023 {

    
    public static void main(String[] args) {
       //Conexion.getConexion();
        //guardarAlumno
//        Alumno jose=new Alumno (23222112,"Jose", "Gonza", LocalDate.of(1977,5, 1),true);
//        AlumnoData alu=new AlumnoData();
//        alu.guardarAlumno(jose);
        
//        Alumno juan=new Alumno (33222112,"Juan", "Gonzalez", LocalDate.of(1989,6, 1),true);
//        AlumnoData al=new AlumnoData();
//        al.guardarAlumno(juan);
//        
//        Alumno jorge=new Alumno (43222112,"Jorge", "Go", LocalDate.of(2000,8, 11),true);
//        AlumnoData a=new AlumnoData();
//        a.guardarAlumno(jorge);
//        
        //modificarAlumno
////        Alumno jose=new Alumno (7,23222112,"Jose Maria", "Gonzalez", LocalDate.of(1977,5, 1),true);
//        AlumnoData alu=new AlumnoData();
//        alu.modificarAlumno(jose);
                
        //eliminarAlumno
//        Alumno jose=new Alumno ();
//        AlumnoData alu=new AlumnoData();
//        alu.eliminarAlumno(6);
        
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
        Alumno alumnoEncontrado=alu.buscarAlumnoPorDni(34658899);
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
        //*****************************************
//        MATERIADATA-MATERIADATA-MATERIADATA
//        Conexion.getConexion();
//        guardarMateria
//        Materia materia=new Materia ("laboratorio-1",1 ,true);
//        MateriaData mate=new MateriaData();
//        mate.guardarMateria(materia);
//        Materia materi=new Materia ("conatduria-1",1 ,true);
//        MateriaData mati=new MateriaData();
//        mati.guardarMateria(materi);
//        
//        Materia materi=new Materia ("lengua", 2,true);
//        MateriaData mates=new MateriaData();
//        mates.guardarMateria(materi);
        
//        modificarMaterA
//        Materia materia=new Materia (9,"Matematica1",3,true);
//        MateriaData mat=new MateriaData();
//        mat.modificarMateria(materia);

//eliminarMateria
//        Materia materia =new Materia ();
//        MateriaData mat=new MateriaData();
//        mat.eliminarMateria(9);
   
    //buscarMateriaId
//        MateriaData materia= new MateriaData();
//        Materia materiaencontrada= materia.buscarMateria(10);
//        
//        System.out.println("NOMBRE: "+ materiaencontrada.getNombre());
//        System.out.println("AÑO: "+materiaencontrada.getAño());
//        System.out.println("ESTADO: "+materiaencontrada.isEstado());


        //listarmaterias
//        

            
//    }
//   *******************************************
//INSCRIPCIONDATA-INSCRIPCIONDATA-
//    Conexion.getConexion();
//   AlumnoData ad= new AlumnoData();
//   DataMateria md = new DataMateria();
//   Inscripcion insc = new Inscripcion(8,ad.buscarAlumnoPorId(1),md.buscarMateria(10));
//   
//   inscripData nueva= new inscripData();
//   nueva.guardarInscripciones(insc);

}
}