package sempadrao.prototype;

public class IngressoLento {
    private String nomePartida;
    private String local;
    private String nomeTorcedor;
    private String assento;

    // O PROBLEMA: Toda a vez que dermos um "new", o sistema vai travar por 2 segundos.
    public IngressoLento(String nomePartida, String local, String nomeTorcedor, String assento) {
        // Simulando lentidão de conexão com Banco de Dados / API
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.nomePartida = nomePartida;
        this.local = local;
        this.nomeTorcedor = nomeTorcedor;
        this.assento = assento;
    }

    public String getResumo() {
        return "Ingresso de " + nomeTorcedor + " - Assento " + assento + " para " + nomePartida;
    }
}