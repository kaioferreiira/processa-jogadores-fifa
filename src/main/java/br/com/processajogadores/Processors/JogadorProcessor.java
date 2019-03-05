package br.com.processajogadores.Processors;

import br.com.processajogadores.Domain.Jogador;
import br.com.processajogadores.ProcessaJogadoresFifaApplication;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class JogadorProcessor {

    public List<Jogador> lerArquivo() {
        List<Jogador> listJogadores = new ArrayList<>();

        ClassLoader classLoader = new ProcessaJogadoresFifaApplication().getClass().getClassLoader();

        CSVFormat format = CSVFormat.DEFAULT.withHeader().withDelimiter(',');

        try (CSVParser parser = new CSVParser(new FileReader(classLoader.getResource("FileCsv/data.csv").getFile()), format)) {
            for (CSVRecord record : parser) {
                Jogador jogador = montarJogador(record);
                listJogadores.add(jogador);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listJogadores;
    }

    private Jogador montarJogador(CSVRecord record) {
        return Jogador.builder()
                .id(Long.valueOf(record.get(0)))
                .nome(record.get(1))
                .fullName(record.get(2))
                .club(record.get(3))
                  .clubLogo(record.get(4))
                  .special(Integer.valueOf(record.get(5)))
                  .age(Integer.valueOf(record.get(6)))
                  .league(record.get(7))
//                  .birthDate(record.get(8)))
                  .heightCm(Double.valueOf(record.get(9)))
                  .weightKg(Double.valueOf(record.get(10)))
                  .bodytype(record.get(11))
                  .realFace(Boolean.valueOf(record.get(12)))
                  .flag(record.get(13))
                  .nationality(record.get(14))
                  .photo(record.get(15))
                  .eurvalue(Double.valueOf(record.get(16)))
                  .eurWage(Double.valueOf(record.get(17)))
                  .eurReleaseClause(record.get(18))
                  .overall(Integer.valueOf(record.get(19)))
                  .build();
    }
}