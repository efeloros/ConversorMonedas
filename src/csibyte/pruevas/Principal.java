package csibyte.pruevas;

import csibyte.modelo.Conversor;
import csibyte.modelo.DatosConvertir;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String monedaBase="";
        String monedaSalida="";
        double cantidad=1;
        Conversor moneda = new Conversor();
        Scanner eleccion = new Scanner(System.in);

        System.out.println("**********************************************\nBienvenidos al Conversor de monedas del mundo \n**********************************************");
        String menu = """
                
                Elije la Moneda.
                
                1. USD - Dolares Estadounidenses.
                2. COP - Peso Colombiano.
                3. EUR - Euros.
                4. CAD - Dólar Canadiense.
                5. GBP - Libra Esterlina Británica.
                6. JPY - Yen Japonés.
                7. CNY - Yuan Chino.
                Si no Esta en la lista, digite el codigo de la la moneda.
                Digite Salir para Terminar. 
                *********************************************************
                """;

        while (true){
            System.out.println(menu);
            var opcion= eleccion.nextLine();
            if (opcion.equalsIgnoreCase("salir")){
                break;
            }
            try {
                var menuInical = opcion;
                monedaBase=menuInical;
                System.out.println(menu);
                var menuSalida =eleccion.nextLine();
                monedaSalida=menuSalida;
                System.out.println("Digite la Cantidad a Covertir");
                var cantidadMoneda = eleccion.nextLine();
                cantidad= Double.parseDouble(cantidadMoneda);
                DatosConvertir datosMoneda = moneda.apiConversor(monedaBase, monedaSalida, cantidad);
                String resultado = String.format("%,.2f", datosMoneda.conversion_result());
                System.out.println("El valor de: "+cantidad +" "+datosMoneda.base_code()+ " es igual a "+resultado+" "+ datosMoneda.target_code());
                /* preguntar si desea continuar*/
                System.out.println("\n****************************\nSi desea continuar convirtiendo monedas escribe el codigo, sino escribe salir\n******************************************");
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Hasta pronto has salido de la aplicacion...");
    }
}
