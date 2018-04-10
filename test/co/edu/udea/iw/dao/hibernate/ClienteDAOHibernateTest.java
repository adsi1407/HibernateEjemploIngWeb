package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

public class ClienteDAOHibernateTest {

	@Test
	public void insertar() {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("elver");
		
		ClienteDAO dao = null;
		Cliente cliente = new Cliente();
		cliente.setCedula("1234567890");
		cliente.setNombres("Cliente1");
		cliente.setApellidos("Apellido1");
		cliente.setCorreoElectronico("andres.santacoloma@udea.edu.co");
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		
		try {
			dao = new ClienteDAOHibernate();
			dao.insertar(cliente);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@Test
	public void testObtener() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteDAO dao = null;
		
		try{
			dao = new ClienteDAOHibernate();
			
			clientes = dao.obtener();
			
			for(Cliente cliente: clientes){
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
				System.out.println("Login: " + cliente.getCedula());
				System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			}
			
			assertTrue(clientes.size()>0);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
