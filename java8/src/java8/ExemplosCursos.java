package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemplosCursos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getNome()));

		Stream<String> nomes = cursos.stream().map(Curso::getNome);

		System.out.println("-------");

		nomes.forEach(n -> System.out.println(n));

		System.out.println("-------");

		cursos.stream().filter(c -> c.getAlunos() > 50).map(c -> c.getAlunos()).forEach(System.out::println);

		System.out.println("-------");

		Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() > 100).findAny();

		// Se não existir o curso lança o que foi passado
		Curso curso = optionalCurso.orElse(null);
		System.out.println(curso.getNome() + " " + curso.getAlunos());

		// Se existir o curso faz o que foi pedido, caso contrário não faz nada.
		optionalCurso.ifPresent(c -> c.getNome());

		// Pode ser usado no stream diretamente:
		System.out.println("-------");

		cursos.stream().filter(c -> c.getAlunos() > 100).findAny()
				.ifPresent(c -> System.out.println(c.getNome() + " " + c.getAlunos()));

		// collect para pegar e mudar o objeto original ou atribuir em uma nova lista:
		System.out.println("-------");
		cursos = cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toList());
		cursos.forEach(c -> System.out.println(c.getNome()));

		// Pode-se usar map para atribuir uma chave e valor:
		System.out.println("-------");

		Map<String, Integer> map = cursos.stream().filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));

		System.out.println(map);

		// Como o que é retornado é um map, o mesmo possui ações diretas, ou seja, não
		// preciso gravar em um map, mas até mesmo iterar diretamente nele
		System.out.println("-------");

		cursos.stream().filter(c -> c.getAlunos() > 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println("O curso " + nome + " tem " + alunos + " alunos."));

		System.out.println("-------");

		// Exercícios:
		// Como podemos fazer pra pegar o primeiro elemento desse Stream filtrado?
		System.out.println("Exercício 1: ");
		cursos.stream().filter(c -> c.getAlunos() > 50).findFirst().ifPresent(c -> System.out.println(c.getNome()));

		System.out.println("-------");

		// Exercícios:
		// Como podemos fazer pra pegar o primeiro elemento desse Stream filtrado?
		System.out.println("Exercício 2: ");
		cursos.stream().mapToInt(c -> c.getAlunos()).average().ifPresent(media -> System.out.println(media));
		
		System.out.println("-------");

		// Exercícios:
		// Como podemos fazer pra pegar o primeiro elemento desse Stream filtrado?
		System.out.println("Exercício 3: ");
		
		List<Curso> listaFiltradaCursos = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.collect(Collectors.toList());
		
	}

}

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}
