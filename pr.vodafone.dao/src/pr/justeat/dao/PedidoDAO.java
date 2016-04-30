package pr.justeat.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pr.justeat.dao.dto.ClienteEstado;
import pr.justeat.dao.dto.Pedido;

public class PedidoDAO {
	
	private SqlSessionFactory sqlSessionFactory;
    
	private SqlSessionFactory getSqlSessionFactory()
	{
		if (sqlSessionFactory == null){
			try {				
				String resource = "conf/mybatis-config.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	
	public Pedido getPedido(int id)
	{			
		Pedido ped = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			ped = session.selectOne("getPedido", id);
		}finally{
			session.close();
		}
		return ped;
	}
	
	public List<Pedido> getPedidos() throws Exception
	{
		List<Pedido> pedidos = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			pedidos = session.selectList("getPedidos");
		}finally{
			session.close();
		}
		return pedidos;
	}
	
	public List<Pedido> getPedidosByEstado(boolean entregado) throws Exception
	{
		List<Pedido> pedidos = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			pedidos = session.selectList("getPedidosByEstado", entregado);
		}finally{
			session.close();
		}
		return pedidos;
	}
	
	public List<Pedido> getPedidosByCliente(String dni) throws Exception
	{
		List<Pedido> pedidos = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			pedidos = session.selectList("getPedidosByCliente", dni);
		}finally{
			session.close();
		}
		return pedidos;
	}
	
	public List<Pedido> getPedidosByClienteAndEstado(String dni, boolean entregado) throws Exception
	{
		List<Pedido> pedidos = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			ClienteEstado ce = new ClienteEstado(dni, entregado);
			pedidos = session.selectList("getPedidosByClienteAndEstado", ce);
		}finally{
			session.close();
		}
		return pedidos;
	}
	
	public void updatePedido(Pedido ped)
	{
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			session.update("updatePedido", ped);
			session.commit();
		}catch(SqlSessionException e){
			session.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
}
