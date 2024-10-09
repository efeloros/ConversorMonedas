package csibyte.pruevas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConversor {
    private static final String API_KEY = "a36bf6b8afeb9518732c4e1d"; // Reemplaza con tu clave
    private static final String BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static void main(String[] args) {
        String fromCurrency = "USD";
        String toCurrency = "EUR";
        double amount = 100;

        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
        System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
    }

    public static double convertCurrency(String from, String to, double amount) {
        try {
            String urlString = BASE_URL + from; // URL para obtener tasas de cambio
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            conn.disconnect();

            // Aquí debes parsear la respuesta JSON
            // Ejemplo de respuesta JSON: {"rates": {"EUR": 0.85, ...}, ...}
            String jsonResponse = response.toString();
            double rate = parseRate(jsonResponse, to); // Implementa esta función

            return amount * rate;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static double parseRate(String jsonResponse, String currency) {
        // Implementa la lógica para extraer la tasa de cambio de la respuesta JSON
        // Puedes usar una biblioteca como Gson o Jackson para facilitar el parsing
        // Por simplicidad, aquí se debe implementar la extracción de la tasa
        return 0.85; // Ejemplo fijo; reemplaza esto con la tasa real extraída
    }
}
