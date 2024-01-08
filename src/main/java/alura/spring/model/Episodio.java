package alura.spring.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private Integer temporada;
    private String nome;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLançamento;

    public Episodio(Integer numeroTemp, DadosEposidio dadosEP) {
        this.temporada = numeroTemp;
        this.nome = dadosEP.Titulo();
        this.numeroEpisodio = dadosEP.numero();
        try{
            this.avaliacao = Double.valueOf(dadosEP.avaliacao());
        }catch(NumberFormatException e){
            this.avaliacao = 0.0;
        }
        try{
            this.dataLançamento = LocalDate.parse(dadosEP.dataDeLancamento());
        }catch(DateTimeParseException e){
            this.dataLançamento = null;
        }
        //parso espera que esta em ISO local date
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Integer getTemporada() {
        return temporada;
    }
    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }
    public LocalDate getDataLançamento() {
        return dataLançamento;
    }
    public void setDataLançamento(LocalDate dataLançamento) {
        this.dataLançamento = dataLançamento;
    }
    
    @Override
    public String toString(){
        return "temporada= " + temporada +
                ", titulo= '" + nome + '\'' +
                ", numero de episodios= " + numeroEpisodio +
                ", avaliação= " + avaliacao +
                ", data de Lançamento= " + dataLançamento;
    }
}
