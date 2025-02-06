package Persistencia;

import Entidades.Estancias;

import java.util.ArrayList;
import java.util.List;

public class EntidadDAOExtEstancias extends DAO{
    
    public void guardarEstancia(Estancias estancia) throws Exception{
        if (estancia == null) {
            throw new Exception("La estancia no puede ser nula");
        }
        String sql = "INSERT INTO estancias (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) VALUES ("
                + estancia.getId_cliente() + ", "
                + estancia.getId_casa() + ", "
                + estancia.getNombre_huesped() + ", "
                + estancia.getFecha_desde() + ", "
                + estancia.getFecha_hasta() + ");";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Estancias> listarTodasLasEstancias() throws Exception {
        String sql = "SELECT * FROM estancias;";
        consultarDataBase(sql);
        List<Estancias> estancias = new ArrayList<>();
        while (resultSet.next()) {
            Estancias estancia = new Estancias();
            estancia.setId_estancia(resultSet.getInt(1));
            estancia.setId_cliente(resultSet.getInt(2));
            estancia.setId_casa(resultSet.getInt(3));
            estancia.setNombre_huesped(resultSet.getString(4));
            estancia.setFecha_desde(resultSet.getDate(5));
            estancia.setFecha_hasta(resultSet.getDate(6));
            estancias.add(estancia);
        }
        return estancias;
    }

    public Estancias buscarestanciaPorId(int idEstancia) throws Exception {
        Estancias estancia = null;
        String sql = "SELECT * FROM estancias WHERE id_estancia = " + idEstancia + ";";
        consultarDataBase(sql);

        if (resultSet.next()) {
            estancia = new Estancias();
            estancia.setId_estancia(resultSet.getInt(1));
            estancia.setId_cliente(resultSet.getInt(2));
            estancia.setId_casa(resultSet.getInt(3));
            estancia.setNombre_huesped(resultSet.getString(4));
            estancia.setFecha_desde(resultSet.getDate(5));
            estancia.setFecha_hasta(resultSet.getDate(6));
        }
        desconectarDataBase();
        return estancia;
    }

    public void eliminarestanciaPorId(int idEstancia) throws Exception {
        String sql = "DELETE FROM estancias WHERE id_estancia = " + idEstancia + ";";
        insertarModificarEliminarDataBase(sql);
    }
}
