package sempadrao.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SistemaBilheteriaTest {

    @Test
    void deveDemorarParaEmitirIngressosSemPadrao() {
        long tempoInicial = System.currentTimeMillis();

        // Para vender apenas 3 ingressos, o sistema faz o processamento pesado 3 vezes!
        IngressoLento i1 = new IngressoLento("Flamengo x Vasco", "Maracanã", "João", "A1");
        IngressoLento i2 = new IngressoLento("Flamengo x Vasco", "Maracanã", "Maria", "A2");
        IngressoLento i3 = new IngressoLento("Flamengo x Vasco", "Maracanã", "Carlos", "A3");

        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = (tempoFinal - tempoInicial) / 1000;

        // Comprova que o teste demorou cerca de 6 segundos (2s para cada ingresso)
        assertTrue(tempoTotal >= 6);
    }
}