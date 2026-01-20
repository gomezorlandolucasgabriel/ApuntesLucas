package ejercicios;

import java.util.Scanner;

public class pt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPedidos = 0, numeroUnidades = 0, pedidosRealizados = 0;
        int stockArrozInicial = 0;
        double stockAguaInicial = 0;
        String tipoDePlato = "";
        boolean aguaSuperada = false, arrozSuperado = false;
        final int ARROZMAKI = 120, ARROZNIGIRI = 50;
        final double AGUAMAKI = 0.10, AGUANIGIRI = 0.05, AGUASHASHIMI = 0.02;
        final int PRECIOMAKI = 8, PRECIONIGIRI = 10, PRECIOSHASHIMI = 12;
        int arrozAcumulado = 0, arrozGastadoEnPedido = 0, arrozRestante = 0;
        double aguaAcumulada = 0, aguaGastadaEnPedido = 0, aguaRestante = 0;
        int costeTotal = 0, importePedido = 0;
        int totalPlatosMaki = 0, totalPlatosNigiri = 0, totalPlatosShashimi = 0;

        while (numPedidos <= 0) {
            System.out.print("Ingresa el número de pedidos a registrar: ");
            numPedidos = scanner.nextInt();

            if (numPedidos <= 0) {
                System.out.println("Error: El número de pedido debe ser mayor que 0");
            }
        }

        while (stockArrozInicial <= 0) {
            System.out.print("Ingresa el stock de arroz(Gramos): ");
            stockArrozInicial = scanner.nextInt();

            if (stockArrozInicial <= 0) {
                System.out.println("Error: El número de gramos debe ser mayor que 0");
            }
        }

        while (stockAguaInicial <= 0) {
            System.out.print("Ingresa el stock de agua(Litros): ");
            stockAguaInicial = scanner.nextDouble();
            scanner.nextLine();
            if (stockAguaInicial <= 0) {
                System.out.println("Error: El número de litros debe ser mayor que 0");
            }
        }
        
            for (int i = 1; i <= numPedidos && !aguaSuperada && !arrozSuperado; i++) {
                pedidosRealizados++;
                tipoDePlato = "";
                numeroUnidades = 0;
                importePedido = 0;
                arrozGastadoEnPedido = 0;
                aguaGastadaEnPedido = 0;

                System.out.println("\n--- Pedido " + i + " ---");

                while (!tipoDePlato.equalsIgnoreCase("nigiri") && !tipoDePlato.equalsIgnoreCase("maki")
                        && !tipoDePlato.equalsIgnoreCase("shashimi")) {
                    System.out.print("Ingresa el Tipo de plato(Maki, Nigiri o Shashimi): ");
                    tipoDePlato = scanner.nextLine();
                    scanner.nextLine();
                    if (!tipoDePlato.equalsIgnoreCase("nigiri") && !tipoDePlato.equalsIgnoreCase("maki")
                            && !tipoDePlato.equalsIgnoreCase("shashimi")) {
                        System.out.println("¡Debes ingresar uno de los platos anteriormente nombrados! ");
                    }
                }

                while (numeroUnidades <= 0) {
                    System.out.print("Ingresa el número de unidades: ");
                    numeroUnidades = scanner.nextInt();

                    if (numeroUnidades <= 0) {
                        System.out.println("¡Debes ingresar al menos una unidad! ");
                    }
                }

                if (tipoDePlato.equalsIgnoreCase("maki")) {
                    arrozAcumulado += ARROZMAKI * numeroUnidades;
                    arrozGastadoEnPedido += ARROZMAKI * numeroUnidades;
                    aguaAcumulada += AGUAMAKI * numeroUnidades;
                    aguaGastadaEnPedido += AGUAMAKI * numeroUnidades;
                    costeTotal += PRECIOMAKI * numeroUnidades;
                    importePedido += PRECIOMAKI * numeroUnidades;
                    totalPlatosMaki += numeroUnidades;
                    System.out.printf("Plato: maki | Unidades: " + numeroUnidades + " | Importe cobrado: " + importePedido + " euros | Arroz gastado: " + arrozGastadoEnPedido + " gramos | Arroz acumulado: " + arrozAcumulado + " gramos | Agua gastada: %.2f" + " litros | Agua acumulada: %.2f litros\n", aguaGastadaEnPedido, aguaAcumulada  );

                } else if (tipoDePlato.equalsIgnoreCase("nigiri")) {
                    arrozAcumulado += ARROZNIGIRI * numeroUnidades;
                    arrozGastadoEnPedido += ARROZNIGIRI * numeroUnidades;
                    aguaAcumulada += AGUANIGIRI * numeroUnidades;
                    aguaGastadaEnPedido += AGUANIGIRI * numeroUnidades;
                    costeTotal += PRECIONIGIRI * numeroUnidades;
                    importePedido += PRECIONIGIRI * numeroUnidades;
                    totalPlatosNigiri += numeroUnidades;
                    System.out.printf("Plato: nigiri | Unidades: " + numeroUnidades + " | Importe cobrado: " + importePedido + " euros | Arroz gastado: " + arrozGastadoEnPedido + " gramos | Arroz acumulado: " + arrozAcumulado + " gramos | Agua gastada: %.2f" + " litros | Agua acumulada: %.2f litros\n", aguaGastadaEnPedido, aguaAcumulada  );
                } 
                
                else {
                    aguaAcumulada += AGUASHASHIMI * numeroUnidades;
                    aguaGastadaEnPedido += AGUASHASHIMI * numeroUnidades;
                    costeTotal += PRECIOSHASHIMI * numeroUnidades;
                    importePedido += PRECIOSHASHIMI * numeroUnidades;
                    totalPlatosShashimi += numeroUnidades;
                    System.out.printf("Plato: shashimi | Unidades: " + numeroUnidades + " | Importe cobrado: " + importePedido + " euros | Arroz gastado: " + arrozGastadoEnPedido + " gramos | Arroz acumulado: " + arrozAcumulado + " gramos | Agua gastada: %.2f" + " litros | Agua acumulada: %.2f litros\n", aguaGastadaEnPedido, aguaAcumulada  );
                }

                if (aguaAcumulada > stockAguaInicial) {
                    System.out.println("\n¡Has superado el stock de agua disponible! ");
                    aguaSuperada = true;
                }

                if (arrozAcumulado > stockArrozInicial) {
                    System.out.println("\n¡Has superado el stock de arroz disponible! ");
                    arrozSuperado = true;
                }
            }

            scanner.close();

            arrozRestante = stockArrozInicial - arrozAcumulado;
            aguaRestante = stockAguaInicial - aguaAcumulada;

            if (!aguaSuperada && !arrozSuperado) {
                System.out.println("\nPedidos registrados: " + pedidosRealizados + " de " + numPedidos);
                System.out.printf("\nUnidades:\nMaki: " + totalPlatosMaki + "\nNigiri: " + totalPlatosNigiri + "\nShasimi: " + totalPlatosShashimi + "\n\nConsumo total:\nArroz: " + arrozAcumulado + " Gramos\nAgua: %.2f Litros" + "\n\nStock restante:\nArroz: " + arrozRestante + " gramos\nAgua: %.2f litros\n\nCaja del dia: " + costeTotal + " euros\n\nRegistro completado con exito" , aguaAcumulada, aguaRestante );
            }    
        }
    }
