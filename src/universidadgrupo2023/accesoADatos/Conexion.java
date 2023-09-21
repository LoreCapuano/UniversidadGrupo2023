
package universidadgrupo2023.accesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB= "universidadulp.sql";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;

    private Conexion() {
    }
    public static Connection getConexion (){
        if(connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO, PASSWORD);
<<<<<<< Updated upstream

//                JOptionPane.showMessageDialog(null,"Conectado");

                //JOptionPane.showMessageDialog(null,"Conectado");

=======
                JOptionPane.showMessageDialog(null,"Conectado");
>>>>>>> Stashed changes
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar el driver"+ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos"+ex.getMessage());
            }
                    
        }
           return connection;
    }
    
}
