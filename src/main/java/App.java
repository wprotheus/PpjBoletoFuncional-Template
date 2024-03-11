import com.wprotheus.retornoboleto.BancoBrasil;
import com.wprotheus.retornoboleto.Bradesco;
import com.wprotheus.retornoboleto.processadorBoleto;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        var processarBoletosBB = new processadorBoleto(BancoBrasil::criarBoleto);
        URI caminhoArquivoBB = Objects.requireNonNull(App.class.getResource("banco-brasil-1.csv")).toURI();
        processarBoletosBB.processar(caminhoArquivoBB);
//        var processarBoletosBradesco = new processadorBoleto(Bradesco::criarBoleto);
//        URI caminhoArquivoBradesco = Objects.requireNonNull(App.class.getResource("bradesco-1.csv")).toURI();
//        processarBoletosBradesco.processar(caminhoArquivoBradesco);
    }
}