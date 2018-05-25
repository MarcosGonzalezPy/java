package json;

import java.math.BigDecimal;

public class Detalle {
	private String agrupacion;
	private String producto;
	private BigDecimal cantidad;
	private BigDecimal montoUnitario;
	private BigDecimal montoNeto;
	private BigDecimal montoIva;
	private BigDecimal montoTotal;	
	
	public String getAgrupacion() {
		return agrupacion;
	}
	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getMontoUnitario() {
		return montoUnitario;
	}
	public void setMontoUnitario(BigDecimal montoUnitario) {
		this.montoUnitario = montoUnitario;
	}
	public BigDecimal getMontoNeto() {
		return montoNeto;
	}
	public void setMontoNeto(BigDecimal montoNeto) {
		this.montoNeto = montoNeto;
	}
	public BigDecimal getMontoIva() {
		return montoIva;
	}
	public void setMontoIva(BigDecimal montoIva) {
		this.montoIva = montoIva;
	}
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	

}
