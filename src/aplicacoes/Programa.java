package aplicacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.DomainException;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner tc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numero = tc.nextInt();
			System.out.print("Data de CheckIn (DD/MM/AAAA): ");
			Date checkIn = sdf.parse(tc.next());
			System.out.print("Data de CheckIn (DD/MM/AAAA): ");
			Date checkOut = sdf.parse(tc.next());
			
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: "+reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Data de CheckIn (DD/MM/AAAA): ");
			checkIn = sdf.parse(tc.next());
			System.out.print("Data de CheckIn (DD/MM/AAAA): ");
			checkOut = sdf.parse(tc.next());
			reserva.atualizaData(checkIn, checkOut);
			System.out.println("Reserva: "+reserva);
		}
		catch(ParseException e) {
			System.out.println("Data no formato inválido.");
		}
		
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Erro inesperado.");
		}

		tc.close();
	}

}
