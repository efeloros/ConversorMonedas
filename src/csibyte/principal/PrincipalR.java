package csibyte.principal;

import csibyte.modelo.Conversor;
import csibyte.modelo.Coversion;
import csibyte.modelo.DatosConvertir;
import csibyte.modelo.ListaConversion;

import java.util.Collections;
import java.util.Scanner;

public class PrincipalR {
    public static void main(String[] args) {
        String monedaBase="";
        String monedaSalida="";
        double cantidad=1;
        var opcion="";
        String salir="";
        ListaConversion registros=new ListaConversion();
        Conversor moneda = new Conversor();
        Scanner eleccion = new Scanner(System.in);
        Scanner decision = new Scanner(System.in);

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
                Salir Digite salir para Terminar. 
                *********************************************************
                """;

        while (!salir.equalsIgnoreCase("salir")){

            try {
                System.out.println(menu);
                var menuInical = eleccion.nextLine();
                if (menuInical.equalsIgnoreCase("salir")){
                    break;
                }
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

                Coversion conversion=new Coversion(datosMoneda.base_code(), datosMoneda.target_code(),cantidad, datosMoneda.conversion_result());
                boolean registroConversion= registros.lanzarRegistro(conversion);

                if (registroConversion){
                    System.out.println("Se ha agregado su registro correctamente");
                }

            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            /* preguntar si desea continuar*/
            System.out.println("\n****************************\nSi desea continuar convirtiendo monedas, escribe si, sino escribe salir para Terminar\n******************************************");
            var decisionContinua = decision.nextLine();
            if (decisionContinua.equalsIgnoreCase("salir")) {
                break;
            }

        }
        System.out.println("Hasta pronto has salido de la aplicacion...");
        System.out.println("Esta es la lista de conversion de monedas que hizo:\n*************************************");
        Collections.sort(registros.getListaDeConversiones());
        for (Coversion conversion : registros.getListaDeConversiones()){
            System.out.println(conversion.getConversion() + " " + conversion.getMonedaEntrada() + " -----> " + conversion.getResultadoConversion() + " " + conversion.getMonedaSalida());
        }
        decision.close();
        eleccion.close();
    }
}
