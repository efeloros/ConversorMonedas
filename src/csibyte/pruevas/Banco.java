package csibyte.pruevas;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        String nombre="Tonny Start";
        String tipoCuenta="correiente";
        double saldo=1800;
        int opcion=0;

        System.out.println("Bienvenido al csibyte.pruevas.Banco Csi \n"+"***********************************");
        System.out.println("Nombre: "+ nombre +"\n" + "Tipo de Cuenta: "+  tipoCuenta +"\n" + "Saldo Disponible: $ "+ saldo);
        System.out.println("***********************************");

        String menu= """
                *** Escriba la opcion deseada ***
                1- Consultar Saldo
                2- Retirar
                3- Depositar
                9- Salir
                """;

        Scanner teclado=new Scanner(System.in);
        while (opcion!=9){
            System.out.println(menu);
            opcion=teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("El saldo actualizado es: $ " +saldo);
                    break;
                case 2:
                    System.out.println("Digite el valor a retirar: ");
                    double valorRetirar= teclado.nextDouble();
                    if (valorRetirar>saldo){
                        System.out.println("fondos insuficientes");
                    }else {
                        saldo=saldo-valorRetirar;
                        System.out.println("El saldo actualizado es: $ " +saldo);
                    }
                    break;
                case 3:
                    System.out.println("Digite el valor a Despositar: ");
                    double valorDepositar= teclado.nextDouble();
                    saldo+=valorDepositar;
                    System.out.println("El saldo actualizado es: $ " +saldo);
                    break;
                case 9:
                    System.out.println("Gracias por utilizar nuestro cajero");
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        }

    }
}