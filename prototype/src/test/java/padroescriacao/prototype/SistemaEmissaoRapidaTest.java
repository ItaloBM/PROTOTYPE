package padroescriacao.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaEmissaoRapidaTest {

    @Test
    void deveEmitirMilharesDeIngressosInstantanemante() {
        long tempoInicial = System.currentTimeMillis();

        // 1. O sistema "paga o preço" de ir ao banco de dados apenas UMA vez para criar o modelo
        Ingresso ingressoModelo = new Ingresso("Flamengo x Palmeiras", "Maracanã");

        // 2. Agora vendemos ingressos CLONANDO o modelo! Não há mais o 'sleep' de 2 segundos.
        Ingresso i1 = ingressoModelo.clone();
        i1.setNomeTorcedor("Zico");
        i1.setAssento("Setor Norte - 100");

        Ingresso i2 = ingressoModelo.clone();
        i2.setNomeTorcedor("Júnior");
        i2.setAssento("Setor Norte - 101");

        long tempoFinal = System.currentTimeMillis();
        long tempoTotalSegundos = (tempoFinal - tempoInicial) / 1000;

        // Comprova que, mesmo criando 3 instâncias (1 original + 2 clones),
        // o tempo total foi de apenas ~2 segundos (o tempo de fazer o modelo base)!
        assertTrue(tempoTotalSegundos < 3);

        // Verifica se os clones guardaram os dados em comum, mas mudaram os individuais
        assertEquals("Flamengo x Palmeiras", i1.getNomePartida());
        assertEquals("Zico", i1.getNomeTorcedor());

        assertEquals("Flamengo x Palmeiras", i2.getNomePartida());
        assertEquals("Júnior", i2.getNomeTorcedor());
    }
}