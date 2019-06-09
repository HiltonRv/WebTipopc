package service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisUtil;
import mybatis.mapper.TipopcMapper;
import semana.bean.TipopcBean;

public class TipopcService implements TipopcMapper{

	@Override
	public List<TipopcBean> listar() {
		List<TipopcBean> lst=new ArrayList<TipopcBean>();
		try {
			SqlSession s= MyBatisUtil.getSqlSessionFactory().openSession();
			TipopcMapper cm=s.getMapper(TipopcMapper.class);
			lst=cm.listar();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public int registrar(TipopcBean c) {
		int rs=0;
		try {
			SqlSession s= MyBatisUtil.getSqlSessionFactory().openSession();
			TipopcMapper cm=s.getMapper(TipopcMapper.class);
			rs=cm.registrar(c);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int actualizar(TipopcBean c) {
		int rs=0;
		try {
			SqlSession s= MyBatisUtil.getSqlSessionFactory().openSession();
			TipopcMapper cm=s.getMapper(TipopcMapper.class);
			rs=cm.actualizar(c);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int eliminar(int id) {
		int rs=0;
		try {
			SqlSession s= MyBatisUtil.getSqlSessionFactory().openSession();
			TipopcMapper cm=s.getMapper(TipopcMapper.class);
			rs=cm.eliminar(id);
			s.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public TipopcBean buscar(int id) {
		TipopcBean c=null;
		try {
			SqlSession s= MyBatisUtil.getSqlSessionFactory().openSession();
			TipopcMapper cm=s.getMapper(TipopcMapper.class);
			c=cm.buscar(id);
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
