package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    
    private static final String URL = "jdbc:mysql://localhost:3306/barberia";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para registrar una persona en la base de datos
    public static void registrarPersona(boolean esBarbero, String nombre, String cpfBarbero, String tel, String anivCliente) {
        String sql = "INSERT INTO Persona (barbero, cpfBarbero, nombre, tel, anivCliente) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, esBarbero);
            pstmt.setString(3, cpfBarbero);
            pstmt.setString(4, nombre);
            pstmt.setString(5, tel);
            pstmt.setString(6, anivCliente);
            pstmt.executeUpdate();
            System.out.println("Persona registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar la persona: " + e.getMessage());
        }
    }

    // Método para registrar un producto en la base de datos
    public static void registrarProducto(String descripcionProducto, boolean prodControlado, int cantProdxId, double precioVenta, String fechaVencimiento) {
        String sql = "INSERT INTO Producto (descripcionProducto, prodControlado, cantProdxId, precioVenta, fechaVencimiento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(2, descripcionProducto);
            pstmt.setBoolean(3, prodControlado);
            pstmt.setInt(4, cantProdxId);
            pstmt.setDouble(5, precioVenta);
            pstmt.setString(6, fechaVencimiento);
            pstmt.executeUpdate();
            System.out.println("Producto registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar el producto: " + e.getMessage());
        }
    }

    // Método para registrar un servicio en la base de datos
    public static void registrarServicio(String descripServicio, int personaId, String fechaHoraCita, String fechaHoraPago, double costoTotalServicio, double costoComision, double montoVenta, double totalVentaDiaria) {
        String sql = "INSERT INTO Servicio (descripServicio, personaId, fechaHoraCita, fechaHoraPago, costoTotalServicio, costoComision, montoVenta, totalVentaDiaria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(2, descripServicio);
            pstmt.setInt(3, personaId);
            pstmt.setString(4, fechaHoraCita);
            pstmt.setString(5, fechaHoraPago);
            pstmt.setDouble(6, costoTotalServicio);
            pstmt.setDouble(7, costoComision);
            pstmt.setDouble(8, montoVenta);
            pstmt.setDouble(9, totalVentaDiaria);
            pstmt.executeUpdate();
            System.out.println("Servicio registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar el servicio: " + e.getMessage());
        }
    }
}

