package aplicacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner tc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numero = tc.nextInt();
		System.out.print("Data de CheckIn (DD/MM/AAAA): ");
		Date checkIn = sdf.parse(tc.next());
		System.out.print("Data de CheckIn (DD/MM/AAAA): ");
		Date checkOut = sdf.parse(tc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a datad de CheckOut precis ser posterior ao CheckIn.");
		}
		else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: "+reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Data de CheckIn (DD/MM/AAAA): ");
			checkIn = sdf.parse(tc.next());
			System.out.print("Data de CheckIn (DD/MM/AAAA): ");
			checkOut = sdf.parse(tc.next());
			
			String erro = reserva.atualizaData(checkIn, checkOut);
			if(erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}else {
				System.out.println("Reserva: "+reserva);
			}
		}
		
		tc.close();
	}

}
