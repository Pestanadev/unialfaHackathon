package unialfa.hackathon.model;
import java.util.Date;

/**
 * Classe que representa um Evento.
 * Contém informações como código, nome, valor, imagem, endereço, descrição,
 * palestrante, organização, patrocinador, modalidade e data do evento.
 */
public class Evento {

    // Código identificador do evento
    private Long cod;
    // Nome do evento
    private String nome;
    // Valor do evento (pode ser gratuito ou pago)
    private String valor;
    // URL da imagem do evento
    private String urlImg;
    // Endereço onde o evento será realizado
    private String endereco;
    // Descrição detalhada do evento
    private String descricao;
    // Nome do palestrante do evento
    private String palestrante;
    // Organização responsável pelo evento
    private String organizacao;
    // Patrocinador do evento
    private String patrocinador;
    // Modalidade do evento (ex: presencial, online)
    private String modalidade;
    // Data de realização do evento
    private Date data;

    /**
     * Construtor da classe Evento.
     * Inicializa todos os atributos do evento.
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

    // Getter e Setter para modalidade
    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    // Getter e Setter para código (cod)
    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para valor
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    // Getter e Setter para urlImg
    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    // Getter e Setter para endereco
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter e Setter para descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter e Setter para palestrante
    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    // Getter e Setter para organizacao
    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    // Getter e Setter para patrocinador
    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    // Getter e Setter para data
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
      Retorna uma representação em String do objeto Evento.
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
