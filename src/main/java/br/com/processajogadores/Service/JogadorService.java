package br.com.processajogadores.Service;

import br.com.processajogadores.Domain.Jogador;
import br.com.processajogadores.Processors.JogadorProcessor;
import br.com.processajogadores.Repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JogadorService {

    @Autowired
    private JogadorProcessor jogadorProcessor;

    @Autowired
    private JogadorRepository jogadorRepository;

    List<Jogador> listJogadores;

    public void processarFileJogador(){
        List<Jogador> listJogadores = jogadorProcessor.lerArquivo();
        jogadorRepository.saveAll(listJogadores);
    }

    public List<Jogador> findAll(){
        return listJogadores = jogadorRepository.findAll();
    }


    //nacionalidade diferentes no arquivo
    public Long nacionalidadeDiferentes(){
        listJogadores = jogadorRepository.findAll();

        Long  qtdNacionalidades = listJogadores.stream().map(jogador -> jogador.getNationality()).distinct().count();
        System.out.println("nacionalidades diferente: " + qtdNacionalidades);
        return qtdNacionalidades;
    }

    // Quantos clubes (coluna `club`) diferentes existem no arquivo?
    // Obs: Existem jogadores sem clube

    public Long clubesDiferentes(){
        listJogadores = jogadorRepository.findAll();

        Long clubesDiferentes =   listJogadores
                .stream()
                .filter(j -> !"".equals(j.getClub()))
                .map(j -> j.getClub()).distinct()
                .count();
        return clubesDiferentes;
    }

    // Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
    public List<String> vintePrimeirosJogadores(){
        listJogadores = jogadorRepository.findAll();
        List<String> total = listJogadores.stream().map(jogador -> jogador.getNome()).limit(10).collect(Collectors.toList());
        return total;
    }

    public List<String> dezmaioresclausulasrecisao(){
        listJogadores = jogadorRepository.findAll();

        return listJogadores.stream().limit(10).sorted(Comparator.comparing(Jogador::getEurReleaseClause).reversed()).map(jogador -> jogador.getFullName()).collect(Collectors.toList());
    }





}
