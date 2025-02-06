package Persistencia;
import java.util.ArrayList;
import java.util.List;

import Entidades.Clientes;

public class EntidadDAOExtClientes extends DAO {
    public void guardarCliente(Clientes cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }
        String sql = "INSERT INTO clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) VALUES ("
                + cliente.getNombre() + ", "
                + cliente.getCalle() + ", "
                + cliente.getNumero() + ", "
                + cliente.getCodigoPostal() + ", "
                + cliente.getCiudad() + ", "
                + cliente.getPais() + ", "
                + cliente.getEmail() + ");";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Clientes> listarTodosLosClientes() throws Exception {
        String sql = "SELECT * FROM clientes;";
        consultarDataBase(sql);
        List<Clientes> clientes = new ArrayList<>();
        while (resultSet.next()) {
            Clientes cliente = new Clientes();
            cliente.setId(resultSet.getInt(1));
            cliente.setNombre(resultSet.getString(2));
            cliente.setCalle(resultSet.getString(3));
            cliente.setNumero(resultSet.getInt(4));
            cliente.setCodigoPostal(resultSet.getString(5));
            cliente.setCiudad(resultSet.getString(6));
            cliente.setPais(resultSet.getString(7));
            cliente.setEmail(resultSet.getString(8));
            clientes.add(cliente);
        }
        return clientes;
    }

    public Clientes buscarCleintePorId(int idCliente) throws Exception {
        Clientes cliente = null;
        String sql = "SELECT * FROM clientes WHERE id_cliente = " + idCliente + ";";
        consultarDataBase(sql);

        if (resultSet.next()) {
            cliente = new Clientes();
            cliente.setId(resultSet.getInt(1));
            cliente.setNombre(resultSet.getString(2));
            cliente.setCalle(resultSet.getString(3));
            cliente.setNumero(resultSet.getInt(4));
            cliente.setCodigoPostal(resultSet.getString(5));
            cliente.setCiudad(resultSet.getString(6));
            cliente.setPais(resultSet.getString(7));
            cliente.setEmail(resultSet.getString(8));
        }
        desconectarDataBase();
        return cliente;
    }

    public void eliminarClientePorId(int idCliente) throws Exception {
        String sql = "DELETE FROM clientes WHERE id_cliente = " + idCliente + ";";
        insertarModificarEliminarDataBase(sql);
    }
}