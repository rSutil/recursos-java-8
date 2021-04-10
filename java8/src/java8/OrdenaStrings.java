package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

//		palavras.sort((s1, s2) -> {
//					if (s1.length() < s2.length())
//						return -1;
//					if (s1.length() > s2.length())
//						return 1;
//					return 0;
//				});
		
//		palavras.sort((s1, s2) -> {
//			return Integer.compare(s1.length(), s2.length());
//		});

		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		
		palavras.forEach(p -> System.out.println(p));

	}

}

//class ComparadorDeStringPorTamanho implements Comparator<String> {
//
//	public int compare(String s1, String s2) {
//		if (s1.length() < s2.length())
//			return -1;
//		if (s1.length() > s2.length())
//			return 1;
//		return 0;
//	}
//
//}
