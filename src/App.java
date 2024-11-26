import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception
     {
    System.out.println("--------------BINGO------------------");
    System.out.println("---------------------------------------");
    System.out.println("Cartones:");
    
    Carton carton1= new Carton("N°: 0001");
    Carton carton2= new Carton("N°: 0002");
    Carton carton3= new Carton("N°: 0003");

carton1.imprimirCarton();
carton2.imprimirCarton();
carton3.imprimirCarton();
System.out.println("---------------------------------");

ArrayList <Carton> cartones= new ArrayList<>();
cartones.add(carton1);
cartones.add(carton2);
cartones.add(carton3);


Bolillero unBolillero= new Bolillero();

Planilla laPlanilla= new Planilla(unBolillero);
laPlanilla.setCartones(cartones);


while (!laPlanilla.hayCartonLleno()) {
    laPlanilla.agregarNumeroSalido();

    laPlanilla.mostrarMarcados();

    laPlanilla.SoloFaltaUno();
}

for(Carton carton: cartones){
    if (carton.cartonLleno()) {
        
    System.out.println("\n\n");
    System.out.println("El carton "+carton.getIdCarton()+" esta lleno");
    }
}

System.out.println("\n\n");
laPlanilla.imprimirSalieron();

    }
}
