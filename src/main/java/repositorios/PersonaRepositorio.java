package repositorios;

import Entidades.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import metodos.DBHelper;

public class PersonaRepositorio {
    
    private Connection connection;

    public PersonaRepositorio() {
        try {
            // Establecer la conexión a la base de datos
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/barbafeita", "root", "");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    private int generatedPersonaId;
    public void registrarPersona(Persona persona) {
        String sql = "INSERT INTO persona (barbero, cpfBarbero, nombre, tel, anivCliente) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, persona.isBarbero());
            pstmt.setString(2, persona.getCpfBarbero());
            pstmt.setString(3, persona.getNombre());
            pstmt.setString(4, persona.getTel());
            pstmt.setObject(5, persona.getAnivCliente());
            pstmt.executeUpdate();
            
            //Obtener el personaId
            try(ResultSet rs = pstmt.getGeneratedKeys()){
                if(rs.next()){
                    int getGeneratedPersonaId = rs.getInt(1);
                    persona.setPersonaId(getGeneratedPersonaId);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar la persona: " + e.getMessage());
        }
    }

    public List<Persona> obtenerTodasLasPersonas() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM persona";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                boolean barbero = rs.getBoolean("barbero");
                int personaId = rs.getInt("personaId");
                String cpfBarbero = rs.getString("cpfBarbero");
                String nombre = rs.getString("nombre");
                String tel = rs.getString("tel");
                LocalDate anivCliente = rs.getObject("anivCliente", LocalDate.class);
                Persona persona = new Persona(barbero, personaId, cpfBarbero, nombre, tel, anivCliente);
                personas.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las personas: " + e.getMessage());
        }
        return personas;
    }
    public Persona encontrarPersonaxId(int personaId) {
        String sql = "SELECT * FROM persona WHERE personaId = ?";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, personaId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    boolean barbero = rs.getBoolean("barbero");
                    String cpfBarbero = rs.getString("cpfBarbero");
                    String nombre = rs.getString("nombre");
                    String tel = rs.getString("tel");
                    LocalDate anivCliente = rs.getDate("anivCliente").toLocalDate();
                    return new Persona(barbero, personaId, cpfBarbero, nombre, tel, anivCliente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la persona: " + e.getMessage());
        }
        return null;
    }

public void actualizarPersona(Persona persona) {
        String sql = "UPDATE persona SET barbero = ?, cpfBarbero = ?, nombre = ?, tel = ?, anivCliente = ? WHERE personaId = ?";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setBoolean(1, persona.isBarbero());
            pstmt.setString(2, persona.getCpfBarbero());
            pstmt.setString(3, persona.getNombre());
            pstmt.setString(4, persona.getTel());
            pstmt.setDate(5, java.sql.Date.valueOf(persona.getAnivCliente()));
            pstmt.setInt(6, persona.getPersonaId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la persona: " + e.getMessage());
        }
    }

 public void eliminarPersona(int personaId) {
        String sql = "DELETE FROM persona WHERE personaId = ?";
        try (Connection conn = DBHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, personaId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la persona: " + e.getMessage());
        }
    }
 
}


