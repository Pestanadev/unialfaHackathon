package unialfa.hackathon.model;

import java.util.Date;

/*
  Classe que representa um Evento.
  Contém informações como código, nome, valor, imagem, endereço, descrição,
  palestrante, organização, patrocinador, modalidade e data do evento.
 */
public class Evento {

    // Atributos (campos)
    private Long cod;
    private String nome;
    private String valor;
    private String urlImg;
    private String endereco;
    private String descricao;
    private String palestrante;
    private String organizacao;
    private String patrocinador;
    private String modalidade;
    private Date data;

    /*
     Construtor da classe Evento.
     Inicializa todos os atributos do evento.
     */
    public Evento(Long cod, String nome, String valor, String urlImg, String endereco,
                  String descricao, String palestrante, String organizacao,
                  String patrocinador, String modalidade, Date data) {
        this.cod = cod;
        this.nome = nome;
        this.valor = valor;
        this.urlImg = urlImg;
        this.endereco = endereco;
        this.descricao = descricao;
        this.palestrante = palestrante;
        this.organizacao = organizacao;
        this.patrocinador = patrocinador;
        this.modalidade = modalidade;
        this.data = data;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /*
      Retorna uma representação em String do objeto Evento
     */
    @Override
    public String toString() {
        return "Evento{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                ", valor='" + valor + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", endereco='" + endereco + '\'' +
                ", descricao='" + descricao + '\'' +
                ", palestrante='" + palestrante + '\'' +
                ", organizacao='" + organizacao + '\'' +
                ", patrocinador='" + patrocinador + '\'' +
                ", modalidade='" + modalidade + '\'' +
                ", data=" + data + '}';
    }

}
