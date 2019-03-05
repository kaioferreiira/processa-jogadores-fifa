package br.com.processajogadores.Domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String fullName;
    private String club;
    private String clubLogo;
    private Integer special;
    private Integer age;
    private String league;
    private Date birthDate;
    private Double heightCm;
    private Double weightKg;
    private String bodytype;
    private Boolean realFace;
    private String flag;
    private String nationality;
    private String photo;
    private Double eurvalue;
    private Double eurWage;
    private String eurReleaseClause;
    private Integer overall;

    public Jogador(String fullName, String eurReleaseClause) {
        this.fullName = fullName;
        this.eurReleaseClause = eurReleaseClause;
    }
}
