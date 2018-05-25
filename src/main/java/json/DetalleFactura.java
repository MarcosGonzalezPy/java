package json;

import java.util.List;

public class DetalleFactura {
	private String numeroCuenta;
	private Long suscripcionId;
	private String numeroLinea;
	private List<AgrupacionDetalle> agrupacionDetalle;
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
		public List<AgrupacionDetalle> getAgrupacionDetalle() {
		return agrupacionDetalle;
	}
	public void setAgrupacionDetalle(List<AgrupacionDetalle> agrupacionDetalle) {
		this.agrupacionDetalle = agrupacionDetalle;
	}
	public Long getSuscripcionId() {
		return suscripcionId;
	}
	public void setSuscripcionId(Long suscripcionId) {
		this.suscripcionId = suscripcionId;
	}
	public String getNumeroLinea() {
		return numeroLinea;
	}
	public void setNumeroLinea(String numeroLinea) {
		this.numeroLinea = numeroLinea;
	} 

	

}
