package br.main.banco.itens;

import java.text.SimpleDateFormat;
import java.util.*;

public class teste {
	
	public static void main(String args[]) {
		 
		
		
		GregorianCalendar gc=new GregorianCalendar();
		 Date data = new Date();
		 GregorianCalendar data2 = new GregorianCalendar(2025, 8, 13);
		
		 
		 System.out.println(gc.get(gc.HOUR_OF_DAY)+":"+gc.get(gc.MINUTE));
		 
		 
		 SimpleDateFormat A = new SimpleDateFormat("dd/MM/yy");
		 
		 
		 System.out.println(A.format(data));
		 
		 long millis1 = gc.getTimeInMillis();
		 long millis2 = data2.getTimeInMillis();
		 
		 long difmil = millis1 - millis2;
		 
		 long diffDias = difmil / (1000 * 60 * 60 * 24);

	     System.out.println("Diferença em dias: " + diffDias);
		 
		 System.out.println(gc.compareTo(data2));
		 
		 System.out.println("Data Salva:"+data2.get(data2.DATE)+"/"+data2.get(data2.MONTH)+"/"+data2.get(data2.YEAR));
		 data2.add(data2.MONTH, 2);
		 System.out.println("Data modificada:"+ data2.get(data2.DATE)+"/"+data2.get(data2.MONTH)+"/"+data2.get(data2.YEAR));
	}
	
}
