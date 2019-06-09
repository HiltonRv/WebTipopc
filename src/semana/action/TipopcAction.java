package semana.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import semana.bean.TipopcBean;
import service.TipopcService;

public class TipopcAction {
	
	private List<TipopcBean> lstTipopc;
	private TipopcBean Tipopc;
	private String resultado;
	private int edit;
		
	
	public int getEdit() {
		return edit;
	}

	public TipopcBean getTipopc() {
		return Tipopc;
	}

	public void setTipopc(TipopcBean Tipopc) {
		this.Tipopc = Tipopc;
	}

	public List<TipopcBean> getLstTipopc() {
		return lstTipopc;
	}

	public String getResultado() {
		return resultado;
	}

	@Action(value="mantenimientoTipopc",results= {
			@Result(name="ok",location="/mantenimientoTipopc.jsp"),
			@Result(name="error",location="/error.jsp")
	})
	public String mantenimientoTipopc() {
		try {
			lstTipopc=(new TipopcService()).listar();
			return "ok";
		} catch (Exception e) {
			resultado="Error: "+e.getMessage();
			return "error";
		}
		
	}

	@Action(value="editarTipopc",results= {
			@Result(name="ok",location="/mantenimientoTipopc.jsp"),
			@Result(name="error",location="/error.jsp")
	})
	public String editarTipopc() {
		try {
			System.out.println(Tipopc.getId());
			Tipopc=(new TipopcService()).buscar(Tipopc.getId());
			lstTipopc=(new TipopcService()).listar();
		
			edit=1;
			
			return "ok";
		} catch (Exception e) {
			resultado="Error: "+e.getMessage();
			return "error";
		}
		
	}
	
	@Action(value="registrarTipopc",results= {
			@Result(name="ok",location="/mantenimientoTipopc.jsp"),
			@Result(name="error",location="/error.jsp")
	})
	public String registrarTipopc() {
		try {
			(new TipopcService()).registrar(Tipopc);
			lstTipopc=(new TipopcService()).listar();
			Tipopc=new TipopcBean();
			return "ok";
		} catch (Exception e) {
			resultado="Error: "+e.getMessage();
			return "error";
		}
	}
	
	@Action(value="actualizarTipopc",results= {
			@Result(name="ok",location="/mantenimientoTipopc.jsp"),
			@Result(name="error",location="/error.jsp")
	})
	public String actualizarTipopc() {
		try {
			(new TipopcService()).actualizar(Tipopc);
			lstTipopc=(new TipopcService()).listar();
			Tipopc=new TipopcBean();
			return "ok";
		} catch (Exception e) {
			resultado="Error: "+e.getMessage();
			return "error";
		}
	}
	
	@Action(value="eliminarTipopc",results= {
			@Result(name="ok",location="/mantenimientoTipopc.jsp"),
			@Result(name="error",location="/error.jsp")
	})
	public String eliminarTipopc() {
		try {
			(new TipopcService()).eliminar(Tipopc.getId());
			lstTipopc=(new TipopcService()).listar();
			Tipopc=new TipopcBean();
			return "ok";
		} catch (Exception e) {
			resultado="Error: "+e.getMessage();
			return "error";
		}
	}
	
	
	
}
