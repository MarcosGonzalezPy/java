package json;

import java.util.List;

public class AgrupacionDetalle {
	
	private String agrupacion;
	private String periodo;
	private List<Detalle> detalle;
	public String getAgrupacion() {
		return agrupacion;
	}
	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}
	public List<Detalle> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}	
	
	

}
