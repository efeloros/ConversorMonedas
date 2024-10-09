package csibyte.modelo;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private String keyApi = "a36bf6b8afeb9518732c4e1d/";
    private String urlApi ="https://v6.exchangerate-api.com/v6/";

    public DatosConvertir apiConversor(String base, String salida, double cantidad){
        URI direccion = URI.create(urlApi + keyApi +"pair/"+ base+"/" +salida+"/"+cantidad);

        HttpClient client =HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DatosConvertir.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo convertir");
        }

    }
}
