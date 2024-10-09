package csibyte.modelo;

public class Coversion implements Comparable<Coversion>{
    String monedaEntrada;
    String monedaSalida;
    double conversion;
    double resultadoConversion;

    public Coversion(String monedaEntrada, String monedaSalida, double conversion, double resultadoConversion) {
        this.monedaEntrada = monedaEntrada;
        this.monedaSalida = monedaSalida;
        this.conversion = conversion;
        this.resultadoConversion = resultadoConversion;
    }

    public String getMonedaEntrada() {
        return monedaEntrada;
    }

    public String getMonedaSalida() {
        return monedaSalida;
    }

    public double getConversion() {
        return conversion;
    }

    public double getResultadoConversion() {
        return resultadoConversion;
    }

    @Override
    public int compareTo(Coversion o) {
        return 0;
    }
}
