/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo2023.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadgrupo2023.entidades.Alumno;
import universidadgrupo2023.entidades.Inscripcion;
import universidadgrupo2023.entidades.Materia;

/**
 *
 * @author matias
 */
public class InscripcionData {

    private Connection con = null;
    private MateriaData matdata = new MateriaData();
    private AlumnoData aludata = new AlumnoData();

    public InscripcionData() {
        con = Conexion.getConexion();

    }

    public void guardarInscripciones(Inscripcion insc) {
        try {
            String sql = "INSERT INTO `inscripcion`( nota, idAlumno, idMateria) "
                    + "VALUES (?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "la inscrpcion se efuectuo correctamente");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla inscripciones" + ex.getMessage());
        }

    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList();
        String sql = "SELECT * FROM Inscripcion";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripto = new Inscripcion();
                inscripto.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno nombre = aludata.buscarAlumnoPorId(rs.getInt("idAlumno"));
//               Materia nombremat ;
                inscripto.setAlumno(nombre);
//                inscripto.setMateria(nombremat);

                inscripto.setNota(rs.getDouble("nota"));
                inscripciones.add(inscripto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al cargar lista de inscripciones " + ex.getMessage());
        }

        return inscripciones;
    }
//   

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        ArrayList<Inscripcion> porAlumno = new ArrayList();
        String slq = "SELECT*  Inscripcion WHERE idAlumno= ? ";
        try {
            PreparedStatement ps = con.prepareStatement(slq);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion tabla = new Inscripcion();
                tabla.setIdInscripcion(rs.getInt("idInscrpcion"));
                Alumno nombre = aludata.buscarAlumnoPorId(rs.getInt("idAlumno"));
                tabla.setAlumno(nombre);

                tabla.setNota(rs.getDouble("nota"));
                porAlumno.add(tabla);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al cargar tabal de inscripcion");
        }

        return porAlumno;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> Materias = new ArrayList<Materia>();
        try {
            String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, maateria"
                    + "WHERE inscripcion.idMateria = materia.idMateria"
                    + "AND inscripcion.idAlumno = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                Materias.add(materia);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al obtener inscripciones " + ex.getMessage());
        }
        return Materias;
    }
//   

    public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        ArrayList<Materia> materia = new ArrayList();
        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria not in"
                + ("SELECT idMateria FROM idInscripcion WHERE idAlumno = ?;");

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia material = new Materia();
                material.setIdMateria(rs.getInt("idMateria"));
                material.setNombre(rs.getString("nombre"));
                material.setAnio(rs.getInt("año"));
                materia.add(material);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al obtener materias NO cursadas ");

        }
        return materia;
   
    }
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELET Inscrpcion WHERE idAlumno = ? AND idMateria = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int fila =ps.executeUpdate();
            if (fila>0){
                JOptionPane.showMessageDialog(null, "inscripcion borrada correctamente");
                
            }
        } catch (SQLException ex) {
            
        }
       
    }
   public void actualizarNota(int idAlumno, int idMateria, double nota){
       String sql = "UPDATE inscripcion SET nota WHERE idAlumno = ? AND idMateria= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            ps.setDouble(1, nota);
            int fila =ps.executeUpdate();
            if (fila>0){
                JOptionPane.showMessageDialog(null, "nota actualizada correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al actualizar nota");
        }
       
   }

        public List<Alumno> obtenerAlumnosMateria(int idMateria) {
        ArrayList<Alumno> alumnos = new ArrayList();
        String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado"
                + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno nuevo = new Alumno();
                nuevo.setIdAlumno(rs.getInt("idAlumno"));
                nuevo.setApellido(rs.getString("apellido"));
                nuevo.setNombre(rs.getString("nombre"));
                nuevo.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                nuevo.setEstado(rs.getBoolean("estado"));                
                alumnos.add(nuevo);
                
            }
        ps.close();;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en base de datos ");
        }
        return alumnos;
    }
}



