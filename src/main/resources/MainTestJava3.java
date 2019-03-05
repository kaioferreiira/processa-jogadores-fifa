package challenge;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MainTestJava3 {

	static List<Jogadores> listJogadores;
	static Long nacionalidade = 0l;

	public static void main(String[] args) throws IOException {

//		resolved
		q1();

		//resolved
//		q2();

		//resolved
		//q3();

		//Resolved
//		 q4().forEach(System.out::println);

		//resolved
		//q5().forEach(System.out::println);

		//resolved
		//q6().forEach(System.out::println);

	}

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	static public int q1() {

		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(buscaInformacoesArquivo().spliterator(), false);
		listJogadores = csvRecordStream
				.skip(1)
				.map(linhaJogador ->  new Jogadores( linhaJogador.toMap()))
				.collect(Collectors.toList());

		Long nacionalidade = listJogadores
										.stream()
										.map(j -> j.getNationality())
										.distinct()
										.count();

		System.out.println("nacionalidades diferente: " + nacionalidade);
		return nacionalidade.intValue();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	static public int q2() {
		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(buscaInformacoesArquivo().spliterator(), false);

		listJogadores = csvRecordStream
				.skip(1)
				.map(csvRecord ->  new Jogadores(csvRecord.toMap()))
				.collect(Collectors.toList());

		Long nacioladidade = listJogadores
							.stream()
							.filter(j -> !"".equals(j.getClub()))
							.map(j -> j.getClub()).distinct()
							.count();

		System.out.println("clubes diferentes: " + nacioladidade);
		return nacioladidade.intValue();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	static public List<String> q3() {
		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(buscaInformacoesArquivo().spliterator(), false);
		List<String> jogadores = csvRecordStream
				.skip(1)
				.limit(20l)
				.map(csvRecord ->  new Jogadores(csvRecord.toMap())).map(j2 -> j2.getFullName())
//				.map(s -> s.split(" ")[0])
				.collect(Collectors.toList());

		jogadores.forEach(System.out::println);

		 return jogadores;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	static public List<String> q4() {
		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(buscaInformacoesArquivo().spliterator(), false);
		listJogadores = csvRecordStream
				.skip(1)
				.map(csvRecord ->  new Jogadores(csvRecord.toMap())).collect(Collectors.toList());

		final Stream<Jogadores> listaTopJogadoresClause = listJogadores.stream()
																		.sorted(Comparator.comparing(Jogadores::getEur_release_clause)
																		.reversed())
																		.limit(10);



		List<String> listaTopJogadores =listaTopJogadoresClause.map(j ->j.getFullName()).collect(Collectors.toList());

		return listaTopJogadores;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	static public List<String> q5() {
		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(buscaInformacoesArquivo().spliterator(), false);

		return csvRecordStream
				.skip(1)
				.map(csvRecord -> new Jogadores(csvRecord.toMap()))
				.sorted(Comparator.comparing(Jogadores::getBirth_date))
				.limit(10)
				.map(j -> j.getFullName())
				.collect(Collectors.toList());
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	static public Map<Integer, Integer> q6() {

		Stream<CSVRecord> csvRecordStream = StreamSupport.stream(buscaInformacoesArquivo().spliterator(), false);

		listJogadores = csvRecordStream
				.skip(1)
				.map(csvRecord ->  new Jogadores(csvRecord.toMap()))
				.collect(Collectors.toList());

		return listJogadores.stream().collect(Collectors.groupingBy(j -> j.getAge(), Collectors.reducing(0, e -> 1, (e, i) ->  e + i)));
	}

	static public CSVParser buscaInformacoesArquivo(){

		String documentsPath = "/home/kaio/codenation/java-3/src/main/resources";
		Path documentsDirectory  = Paths.get(documentsPath);
		String fileName = "FileCsv/data.csv";
		Path csvPath  = documentsDirectory.resolve(fileName);
		CSVParser csvParser = null;
		try {
			csvParser = CSVParser.parse(csvPath, Charset.defaultCharset(),
					CSVFormat.DEFAULT.withHeader("id","nome","full name","club","club_logo","special","age","league",
							"birth_date",
							"height_cm",
							"weight_kg",
							"body_type",
							"real_face",
							"flag",
							"nationality",
							"photo",
							"eur_value",
							"eur_wage",
							"eur_release_clause"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csvParser ;
	 }
}
