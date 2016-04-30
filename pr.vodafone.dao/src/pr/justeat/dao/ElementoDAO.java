package pr.justeat.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
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
				String resource = "conf/mybatis-config.xml";
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
/*		
	public List<Elemento> getElementos() throws Exception
	{
		List<Elemento> elementos = null;
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			elementos = session.selectList("getCategorias");
		}finally{
			session.close();
		}
		return elementos;
	}

	public void insertCategoria(Elemento ele) 
	{
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			session.insert("insertCategoria", ele);
			session.commit();
		}catch(SqlSessionException e){
			session.rollback();
			throw e;
		}finally{
			session.close();
		}
	}*/
/*
	public void updateCategoria(Categoria cat)
	{
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			session.update("updateCategoria", cat);
			session.commit();
		}catch(SqlSessionException e){
			session.rollback();
			throw e;
		}finally{
			session.close();
		}
	}

	public void deleteCategoria(int cod)
	{
		SqlSession session = getSqlSessionFactory().openSession();
		try{
			session.delete("deleteCategoria", cod);
			session.commit();
		}catch(SqlSessionException e){
			session.rollback();
			throw e;
		}finally{
			session.close();
		}
	}*/
}