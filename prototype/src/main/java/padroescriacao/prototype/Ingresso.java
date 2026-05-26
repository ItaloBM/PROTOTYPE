package padroescriacao.prototype;

// 1. Implementar a interface Cloneable nativa do Java
public class Ingresso implements Cloneable {

    // Atributos base (que se repetem para todos)
    private String nomePartida;
    private String local;

    // Atributos variáveis (específicos de cada clone)
    private String nomeTorcedor;
    private String assento;

    // A carga pesada só acontece UMA VEZ ao criar o protótipo!
    public Ingresso(String nomePartida, String local) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.nomePartida = nomePartida;
        this.local = local;
    }

    public void setNomeTorcedor(String nomeTorcedor) { this.nomeTorcedor = nomeTorcedor; }
    public void setAssento(String assento) { this.assento = assento; }

    public String getNomeTorcedor() { return nomeTorcedor; }
    public String getAssento() { return assento; }
    public String getNomePartida() { return nomePartida; }

    // 2. O Método Mágico: Retorna uma cópia exata de si mesmo (sem passar pelo construtor de novo!)
    @Override
    public Ingresso clone() {
        try {
            return (Ingresso) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}