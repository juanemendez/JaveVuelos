package co.edu.javeriana.vuelos.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VueloEspecificoCharter extends VueloEspecifico {

	private String nombreComprador;
	
	public VueloEspecificoCharter(LocalDate fecha,String tipoAvion,int capacidad,VueloPlaneado vueloPlaneado,long tarifa,String nombreComprador){
		super(fecha,tipoAvion,capacidad,vueloPlaneado,tarifa);
		this.nombreComprador = nombreComprador;
		for(Silla s: this.getListaSillas()){
			s.setComprada(true);
		}
		this.cuposLibres = 0;
	}
	
	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String fechaAux = fecha.format(formatter);
		return String.format("%25d %-20s %-20s %-20d %-20d %-20d %-20s", codigo,fechaAux,tipoAvion,capacidad,cuposLibres,tarifa,nombreComprador);

	}

	@Override
	public long calcularValorPasaje() {
		// TODO Auto-generated method stub
		long valor = 0;
		valor = tarifa * (this.getListaSillas().size());
		return valor;
	}
	
}
