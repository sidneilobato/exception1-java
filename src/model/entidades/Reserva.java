package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut){
		Date agora = new Date();
		if((checkIn.before(agora))||(checkOut.before(agora))) {
			throw new DomainException ("As datas de reserva precisam ser datas futuras.");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException ("a data de CheckOut precisa ser posterior ao CheckIn.");
		}
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
	
	public void atualizaData(Date checkIn, Date checkOut){
		Date agora = new Date();
		if((checkIn.before(agora))||(checkOut.before(agora))) {
			throw new DomainException ("As datas de reserva precisam ser datas futuras.");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException ("a data de CheckOut precisa ser posterior ao CheckIn.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
