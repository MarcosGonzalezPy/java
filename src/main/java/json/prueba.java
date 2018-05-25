package json;

import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class prueba {
	
	static Connection con;	
	
	 
	public static void obtenerConexion(){
		try {
			Class.forName("org.postgresql.Driver"); 
			con = DriverManager.getConnection("jdbc:postgresql://10.150.44.61:5433/crmdev", "bill_user", "cambiar123");
		}catch(Exception e){
			System.out.println(" "+e);
		}				
	}


	public static void cargarTabla(){
		
		obtenerConexion();		
		try{
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String sql = "Insert into bill.fact_parametros_simulacion values('CUENTA', '1', null)";
			stmt.executeUpdate(sql);
			con.commit();
			sql = "INSERT INTO bill.fact_pasos_facturacion VALUES('FACTR', 1, 'Pre-Facturacion y Mascara', 'A', 1, 1, 1, 'S')";
			stmt.executeUpdate(sql);
			stmt.close();
			System.out.println("Transaction succeeded");
		}catch (SQLException se) {
			se.printStackTrace();
			try{
				con.rollback();	
				System.out.println("Transaction failed");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws JSONException, SQLException, IOException{
		pruebaJson();
			
	}
	
	public static void pruebaJson() throws java.sql.SQLException, JSONException, IOException {
		List<Factura> listaFactura = new ArrayList<Factura>();
		Date fecha = new Date();
		System.out.println("inicio "+fecha);
		try  {
			obtenerConexion();
			int cont = 0;
			//int cant_factura = 0;
			/*Map<String, String> agrupacionFactura = new HashMap<>();
			PreparedStatement p = con.prepareStatement(
					"select p.producto_id::varchar, pr.codigo_precio, d.descripcion_valor descripcion"
					+" from crm.prod_productos p, crm.prod_productos_caracteristicas pc, crm.prod_productos_caracteristicas_valores pcv, crm.enco_espec_productos_precios epp, crm.prec_precios pr, "
					+" crm.enco_dominios d "
					+" where p.producto_id = pc.producto_id "
					+" and pc.producto_caracteristica_id = pcv.producto_caracteristica_id "
					+" and pc.nombre = 'GRUPO_FACTURA' "
					+" and p.especificacion_id = epp.especificacion_id "
					+" and epp.codigo_precio = pr.codigo_precio "
					+" and pr.clase_precio = 'PRECIO' "
					+" and pr.tipo_precio = 'RECURRENTE' "
					+" and d.codigo_dominio = 'AGRUPACION_ITEMS_FACTURA' "
					+" and pcv.valor = d.valor_dominio " 
					+" and d.estado_dominio = 'ACTIVO' "
					+" union "
					+" select '' producto_id, a.codigo_precio,  d.descripcion_valor descripcion "
					+" from crm.prec_precios a, crm.enco_dominios d where d.codigo_dominio = 'AGRUPACION_ITEMS_FACTURA' "
					+" and a.agrupacion_factura = d.valor_dominio and d.estado_dominio = 'ACTIVO'"
					);
			
			ResultSet r = p.executeQuery();
			while (r.next()) {
				agrupacionFactura.put(r.getString(1)+r.getString(2), r.getString(3));				
			}*/
			
			PreparedStatement pst = con
					.prepareStatement("select a.numero_cuenta, a.razon_social, a.direccion, to_char(a.fecha_factura, 'DD/MM/YYYY') fecha_factura, to_char(a.fecha_vencimiento, 'DD/MM/YYYY') fecha_vencimiento, coalesce(b.producto_id::varchar,'') producto_id, b.glosa, b.cantidad, b.monto_neto, b.monto_iva, b.monto_con_impuesto, "
									+ "count(0) over (partition by a.factura_id) total_registro_factura, " 
									+ "(select count(distinct c.suscripcion_id) from bill.fact_detalle_facturas_ciclo c where a.factura_id = c.factura_id) cantidad_suscripcion_factura, "
									+ "c.descripcion agrupacion_factura, b.suscripcion_id, b.numero_linea "
									+ "from bill.fact_cabecera_facturas_ciclo a, bill.fact_detalle_facturas_ciclo b, "
									+ "(select p.producto_id::varchar, pr.codigo_precio, d.descripcion_valor descripcion "
									+ "from crm.prod_productos p, crm.prod_productos_caracteristicas pc, crm.prod_productos_caracteristicas_valores pcv, " 
									+ "crm.enco_espec_productos_precios epp, crm.prec_precios pr,crm.enco_dominios d "
									+ "where p.producto_id = pc.producto_id "
									+ "and pc.producto_caracteristica_id = pcv.producto_caracteristica_id "
									+ "and pc.nombre = 'GRUPO_FACTURA' "
									+ "and p.especificacion_id = epp.especificacion_id "
									+ "and epp.codigo_precio = pr.codigo_precio "
									+ "and pr.clase_precio = 'PRECIO' "
									+ "and pr.tipo_precio = 'RECURRENTE' "
									+ "and d.codigo_dominio = 'AGRUPACION_ITEMS_FACTURA' "
									+ "and pcv.valor = d.valor_dominio  "
									+ "and d.estado_dominio = 'ACTIVO' "
									+ "union "
									+ "select '' producto_id, a.codigo_precio,  d.descripcion_valor descripcion "
									+ "from crm.prec_precios a, crm.enco_dominios d where d.codigo_dominio = 'AGRUPACION_ITEMS_FACTURA' "
									+ "and a.agrupacion_factura = d.valor_dominio and d.estado_dominio = 'ACTIVO') c "  
									+ "where a.factura_id = b.factura_id "
									+ "and coalesce(b.producto_id::varchar, '') = c.producto_id "
									+ "and b.codigo_precio = c.codigo_precio "
									//+ "and a.cuenta_facturacion_id in (8721389,8095165,5690033,6880943)"
									+ "order by a.factura_id, b.suscripcion_id, c.descripcion, b.item_factura_id");
			ResultSet rs = pst.executeQuery();
			
			String numeroCuenta = null;
			String numeroCuentaAnterior = ".";			
			Long   suscripcionId = null;
			Long   suscripcionIdAnterior = new Long(0);
			String agrupacion = null;
			String agrupacionAnterior = ".";
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Factura factura = null;
			DetalleFactura detalleFactura = null;
			List<DetalleFactura> listaDetalleFactura = new ArrayList<DetalleFactura>();
			AgrupacionDetalle agrupacionFactura = null;
			List<AgrupacionDetalle> listaAgrupacionDetalle = new ArrayList<AgrupacionDetalle>();
			Detalle detalle = null;
			List<Detalle> listaDetalle = new ArrayList<Detalle>();			
			
			FileWriter file = new FileWriter("C:\\prueba-json\\test.txt");
			int cant = 0;
			
			while (rs.next()) {
				
				cont = cont + 1;				
				numeroCuenta=rs.getString(1);
				suscripcionId=rs.getLong(15);
				agrupacion=rs.getString(14);
				detalle = new Detalle();
								
				if (!numeroCuentaAnterior.equals(numeroCuenta)){					
					if (!listaDetalle.isEmpty()){
						agrupacionFactura.setDetalle(listaDetalle);
						listaAgrupacionDetalle.add(agrupacionFactura);	
						listaDetalle = new ArrayList<Detalle>();
						detalleFactura.setAgrupacionDetalle(listaAgrupacionDetalle);
						listaDetalleFactura.add(detalleFactura);		
						listaAgrupacionDetalle = new ArrayList<AgrupacionDetalle>();
					}
												
					if (!listaDetalleFactura.isEmpty()){
						factura.setDetalleFactura(listaDetalleFactura);
						listaFactura.add(factura);	
						listaDetalle = new ArrayList<Detalle>();	
						listaDetalleFactura = new ArrayList<DetalleFactura>();		
						detalleFactura = new DetalleFactura();
					}
					factura = new Factura();					
					factura.setNumeroCuenta(rs.getString(1));
					factura.setNombre(rs.getString(2));
					factura.setDireccion(rs.getString(3));
					factura.setFechaFactura(rs.getString(4));
					factura.setFechaVencimiento(rs.getString(5));
					cant = cant + 1;
					
					//if (cant%1000==0){
					if (!listaFactura.isEmpty()){
						try {							
							//System.out.println(cant+" "+listaFactura.size());
							String prettyJsonString = gson.toJson(listaFactura);
							file.write(prettyJsonString);
							listaFactura = new ArrayList<Factura>();
						} catch (Exception e) {
							System.out.println("Error al escribir." + e.getMessage());
						}
						file.flush();
					}
														
					numeroCuentaAnterior=numeroCuenta;
				}
				
				if(suscripcionIdAnterior.compareTo(suscripcionId)!=0){
					if (!listaAgrupacionDetalle.isEmpty()){
						if (!listaDetalle.isEmpty()){
							agrupacionFactura.setDetalle(listaDetalle);
							listaAgrupacionDetalle.add(agrupacionFactura);	
							listaDetalle = new ArrayList<Detalle>();
							detalleFactura.setAgrupacionDetalle(listaAgrupacionDetalle);
							//listaDetalleFactura.add(detalleFactura);		
							listaAgrupacionDetalle = new ArrayList<AgrupacionDetalle>();
						}
						
						detalleFactura.setAgrupacionDetalle(listaAgrupacionDetalle);
						listaDetalleFactura.add(detalleFactura);		
						listaAgrupacionDetalle = new ArrayList<AgrupacionDetalle>();						
					}
					detalleFactura = new DetalleFactura();
					//detalleFactura.setNumeroCuenta(numeroCuenta);
					detalleFactura.setSuscripcionId(suscripcionId);
					detalleFactura.setNumeroLinea(rs.getString(16));
					suscripcionIdAnterior = suscripcionId;
					
				}
				
				if (!agrupacionAnterior.equals(agrupacion)){
					if (!listaDetalle.isEmpty()){
						agrupacionFactura.setDetalle(listaDetalle);
						listaAgrupacionDetalle.add(agrupacionFactura);	
						listaDetalle = new ArrayList<Detalle>();
					}					
					agrupacionFactura = new AgrupacionDetalle();
					agrupacionFactura.setAgrupacion(agrupacion);
					//agrupacionFactura.setPeriodo("14/02-13/03");
					agrupacionAnterior = agrupacion;
					
				}
				
				detalle.setProducto(rs.getString(7));
				detalle.setCantidad(rs.getBigDecimal(8).setScale(0, RoundingMode.CEILING));
				detalle.setMontoNeto(rs.getBigDecimal(9).setScale(0, RoundingMode.CEILING));
				detalle.setMontoIva(rs.getBigDecimal(10).setScale(0, RoundingMode.CEILING));
				detalle.setMontoTotal(rs.getBigDecimal(11).setScale(0, RoundingMode.CEILING));				
				
				//System.out.println("Procesado " + cont);
				
				listaDetalle.add(detalle);
				
				
			}
			
			if (!listaDetalle.isEmpty()){
				agrupacionFactura.setDetalle(listaDetalle);
				listaAgrupacionDetalle.add(agrupacionFactura);	
				//listaDetalle.clear();
			}			
			if (!listaAgrupacionDetalle.isEmpty()){
				detalleFactura.setAgrupacionDetalle(listaAgrupacionDetalle);
				listaDetalleFactura.add(detalleFactura);
				//listaAgrupacionDetalle.clear();
			}
			
			if (!listaDetalleFactura.isEmpty()){
				factura.setDetalleFactura(listaDetalleFactura);
				listaFactura.add(factura);											
			}

			
			try {
				//ystem.out.println(listaFactura.size());
				String prettyJsonString = gson.toJson(listaFactura);
				file.write(prettyJsonString);
			} catch (Exception e) {
				System.out.println("Error al escribir." + e.getMessage());
			}
			file.flush();
			file.close();
			fecha = new Date();
			System.out.println("Fin "+fecha);
		} catch (Exception e) {
			System.out.println("Error. " + e.getMessage());
		}
	}
	
/*	public void bacth(){
		obtenerConexion();	
		
		SqlSession s = f.openSession(ExecutorType.BATCH, false);
		
		FactPasosFacturacion paso = new FactPasosFacturacion();
		paso.setCodigoOperacion("PRUEBA");
		paso.setDescripcion("DESC");
		paso.setEstadoEjecucion("E");
		paso.setEsSimulacion("N");
		paso.setInstancia((short) 1);
		paso.setNumeroEjecucion(1);
		paso.setPaso((short)1);
		paso.setSubPaso((short)1);
		
		insertarInBatch(paso, s);
		
		//s.fl
	}
	
	private void insertarInBatch(FactPasosFacturacion t, SqlSession s) {
		FactPasosFacturacionMapper m = s.getMapper(FactPasosFacturacionMapper.class);
		m.insert(t);
	}*/
	
	public static void comparar(){
		
	}
}
