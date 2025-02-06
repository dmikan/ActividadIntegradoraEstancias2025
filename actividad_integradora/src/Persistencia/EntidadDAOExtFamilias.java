package Persistencia;

import java.util.ArrayList;
import java.util.List;

import Entidades.Familias;

public class EntidadDAOExtFamilias extends DAO {
    public void guardarFamilia(Familias familia) throws Exception{
        if (familia == null) {
            throw new Exception("La familia no puede ser nulo");
        }
        String sql = "INSERT INTO familias (nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) VALUES ("
                + familia.getNombre() + ", "
                + familia.getEdad_minima()+ ", "
                + familia.getEdad_maxima()+ ", "
                + familia.getNum_hijos() + ", "
                + familia.getEmail() + ", "
                + familia.getId_casa_familia() + ");";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Familias> listarTodasLasFamilias() throws Exception {
        String sql = "SELECT * FROM familias;";
        consultarDataBase(sql);
        List<Familias> familias = new ArrayList<>();
        while (resultSet.next()) {
            Familias familia = new Familias();
            familia.setId(resultSet.getInt(1));
            familia.setNombre(resultSet.getString(2));
            familia.setEdad_minima(resultSet.getInt(3));
            familia.setEdad_maxima(resultSet.getInt(4));
            familia.setNum_hijos(resultSet.getInt(5));
            familia.setEmail(resultSet.getString(6));
            familia.setId_casa_familia(resultSet.getInt(7));
            familias.add(familia);
        }
        return familias;
    }

    public Familias buscarFamiliaPorId(int idFamilia) throws Exception {
        Familias familia = null;
        String sql = "SELECT * FROM familias WHERE id_familia = " + idFamilia + ";";
        consultarDataBase(sql);

        if (resultSet.next()) {
            familia = new Familias();
            familia.setId(resultSet.getInt(1));
            familia.setNombre(resultSet.getString(2));
            familia.setEdad_minima(resultSet.getInt(3));
            familia.setEdad_maxima(resultSet.getInt(4));
            familia.setNum_hijos(resultSet.getInt(5));
            familia.setEmail(resultSet.getString(6));
            familia.setId_casa_familia(resultSet.getInt(7));
        }
        desconectarDataBase();
        return familia;
    }

    public void eliminarFamiliaPorId(int idFamilia) throws Exception {
        String sql = "DELETE FROM familias WHERE id_familia = " + idFamilia + ";";
        insertarModificarEliminarDataBase(sql);
    }
}
