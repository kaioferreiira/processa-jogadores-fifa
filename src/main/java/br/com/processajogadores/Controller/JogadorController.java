package br.com.processajogadores.Controller;

import br.com.processajogadores.Domain.Jogador;
import br.com.processajogadores.Service.JogadorService;
import com.sun.imageio.plugins.common.I18N;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorController {


    @Autowired
    private JogadorService jogadorService;

    //encontra todos os jogadores
    @GetMapping
    public ResponseEntity<List<Jogador>> findALl(){
        List<Jogador> jogadorList = new ArrayList<>();
        jogadorList = jogadorService.findAll();
        return ResponseEntity.ok(jogadorList);
    }

    //Criar endpoints
    //// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
    @GetMapping(value = "/nacionalidades")
    public ResponseEntity<Long> nacionalidadesDiferentes(){
        Long quantidadeNacionalidade = jogadorService.nacionalidadeDiferentes();
        return ResponseEntity.ok(quantidadeNacionalidade);
    }

    // Quantos clubes (coluna `club`) diferentes existem no arquivo?
    // Obs: Existem jogadores sem clube.
    @GetMapping(value = "clubesdiferentes")
    public ResponseEntity<Long> clubesDiferentes(){
        Long clubesDiferentes =  jogadorService.clubesDiferentes();
        return ResponseEntity.ok(clubesDiferentes);
    }

    // Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
    @GetMapping(value = "vinteprimeirosjogadores")
    public ResponseEntity< List<String> > vintePrimeirosJogadores(){
        List<String> nomes2OJogadores = jogadorService.vintePrimeirosJogadores();
        return ResponseEntity.ok(nomes2OJogadores);
    }

    // Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
    // (utilize as colunas `full_name` e `eur_release_clause`)
    @GetMapping(value = "dezmaioresclausulasrecisao")
    public ResponseEntity<List<String>> dezmaioresclausulasrecisao(){
        List<String> dezmaioresclausulasrecisao = jogadorService.dezmaioresclausulasrecisao();
        return ResponseEntity.ok(dezmaioresclausulasrecisao);
    }



    // Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
    // (utilize as colunas `full_name` e `birth_date`)

    // Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
    // (utilize a coluna `age`)


}
