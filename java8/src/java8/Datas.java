package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        
        LocalDate olimpiadasTokyo = LocalDate.of(2021, Month.JULY, 23);
        
        int anos = olimpiadasTokyo.getYear() - hoje.getYear();
        System.out.println(anos);
        
        Period periodo = Period.between(hoje, olimpiadasTokyo);
        System.out.println(periodo);
        
        Period periodoEntre = Period.between(hoje, olimpiadasTokyo);
        System.out.println(periodoEntre.getYears());
        System.out.println(periodoEntre.getMonths());
        System.out.println(periodoEntre.getDays());
        
        System.out.println(hoje.minusYears(1));
        System.out.println(hoje.minusMonths(4));
        System.out.println(hoje.minusDays(2));

        System.out.println(hoje.plusYears(1));
        System.out.println(hoje.plusMonths(4));
        System.out.println(hoje.plusDays(2));
        
        LocalDate proximasOlimpiadas = olimpiadasTokyo.plusYears(4);
        System.out.println(proximasOlimpiadas);
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = proximasOlimpiadas.format(formatador);
        System.out.println(valorFormatado);
        
        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHoras));
        
        YearMonth anoEMes = YearMonth.of(2021, Month.JULY);
        System.out.println(anoEMes);
        
        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println(intervalo);
        
        LocalDate pontoFuturo2099 = LocalDate.of(2099, Month.JANUARY, 1);
        System.out.println(pontoFuturo2099.format(formatador));
        
        
        Period periodo2099 = Period.between(hoje, pontoFuturo2099);
        System.out.println(periodo2099);
        
        System.out.println(hoje.format(formatador));
	}

}
