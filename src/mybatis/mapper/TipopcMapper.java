package mybatis.mapper;

import java.util.List;

import semana.bean.TipopcBean;

public interface TipopcMapper {
	public List<TipopcBean> listar();
	public int registrar(TipopcBean c);
	public int actualizar(TipopcBean c);
	public int eliminar(int id);
	public TipopcBean buscar(int id);

}
