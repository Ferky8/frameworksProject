package pr.justeat.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pr.justeat.dao.dto.Cliente;

public class ClienteDAO {
	
	private SqlSessionFactory sqlSessionFactory;
    
	private SqlSessionFactory getSqlSessionFactory()
	{
		if (sqlSessionFactory == null){
			try {				
				String resource = "confi/mybatis-config.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	
	public Cliente getCliente(int dni)
	{			
		Cliente cl = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			cl = session.selectOne("getCliente", dni);
		}finally{
			session.close();
		}
		return cl;
	}
	
	public List<Cliente> getClientes() throws Exception
	{
		List<Cliente> clientes = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			clientes = session.selectList("getClientes");
		}finally{
			session.close();
		}
		return clientes;
	}
	
	public void updateCliente(Cliente cl)
	{
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			session.update("updateCliente", cl);
			session.commit();
		}catch(SqlSessionException e){
			session.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
}
