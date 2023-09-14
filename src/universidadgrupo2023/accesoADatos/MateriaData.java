package universidadgrupo2023.accesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo2023.accesoADatos.Conexion;
import universidadgrupo2023.entidades.Materia;

public class MateriaData {

    private Connection con = null;

    public MateriaData() {

        con = Conexion.getConexion();

    }

    //manejo en CRUD = CREATE, READ, UPDATE, DELETE
    // CREATE
    public void guardaralumno(Materia materia) {

        String slq = "INSERT INTO materia (nombre, año, estado) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(slq, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia Guardado");

            } else {
                JOptionPane.showMessageDialog(null, "error, no se pudo Guardar");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }

    }
    //UPDATE

    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre=?, año=?, estado=? WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, true);
            ps.setInt(4, materia.getIdMateria());
            int filas = ps.executeUpdate();

            if (filas == 1) {
                JOptionPane.showMessageDialog(null, "Materia se ha modificado en el ID");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar el ID de la Materia");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo encontrar la tabla Materia");

        }

    }

    //DELETE
    public void eliminarMateria(int id) {
        String sql = "DELETE FROM materia WHERE idMateria=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No existe una Materia con ese Id");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }

    }

    //READ
    public Materia buscarMateria(int id) {

        String slq = "SELECT idMateria, nombre, anio FROM materia WHERE idMateria = ? AND estado = 1";
        Materia materia = null;

        try {
            PreparedStatement ps = con.prepareStatement(slq);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe la matgeria");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }

        return materia;

    }
//Listar Maerias

    public List<Materia> ListarMaterias() {

        String slq = "SELECT idMateria, nombre, año FROM materia WHERE estado = 1";

        ArrayList<Materia> Materias = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(slq);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);
                Materias.add(materia);

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materias");
        }

        return Materias;
    }

}
