package pr.justeat.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pr.justeat.dao.dto.Elemento;

import java.io.Reader;
import java.util.List;

public class ElementoDAO {

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

	public Elemento getElementoPorId(int id)
	{			
		Elemento ele = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			ele = session.selectOne("getElementoPorId", id);
		}finally{
			session.close();
		}
		return ele;
	}
	
	public List<Elemento> getElementosByPedido(int pedido) throws Exception
	{
		List<Elemento> elementos = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			elementos = session.selectList("getElementosByPedido", pedido);
		}finally{
			session.close();
		}
		return elementos;
	}
}