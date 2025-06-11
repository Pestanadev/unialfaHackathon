package uniAlfa.hackathon.model;

import java.util.Date;

public class Evento {

    private Long ra;
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

    public Evento(Long ra, String nome, String valor, String urlImg, String endereco,
                  String descricao, String palestrante, String organizacao,
                  String patrocinador, String modalidade, Date data) {
        this.ra = ra;
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

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
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

    @Override
    public String toString() {
        return "Evento{" +
                "ra=" + ra +
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
