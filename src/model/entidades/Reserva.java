package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String atualizaData(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if((checkIn.before(agora))||(checkOut.before(agora))) {
			return "As datas de reserva precisam ser datas futuras.";
		}
		if(!checkOut.after(checkIn)) {
			return "a data de CheckOut precis ser posterior ao CheckIn.";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+ ", ChechIn: "
			+ sdf.format(checkIn)
			+ ", CheckOut: "
			+ sdf.format(checkOut)
			+ ", "
			+ duracao()
			+ " Noites.";
	}
}
