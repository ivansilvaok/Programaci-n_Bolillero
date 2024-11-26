import java.util.ArrayList;


public class Planilla {
    
    private ArrayList<Integer> salieron;
    private Bolillero bolillas;
    private ArrayList<Carton> cartones;



    public Planilla(Bolillero bolillas){
        this.bolillas=bolillas;
        this.salieron= new ArrayList<>();
        this.cartones= new ArrayList<>();
    }

    public void setSalieron(ArrayList<Integer> salieron){
        this.salieron= salieron;
    }

    public void agregarNumeroSalido(){
        try {
            int numero= bolillas.getBolillas();
            salieron.add(numero);
            System.out.println("Bolilla numero: "+numero);
            VerificarSalido(numero);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimirSalieron(){

        System.out.println("Han salido los numeros: "+salieron);
    }


    public void VerificarSalido(int numero){
        for(Carton carton : cartones){
            carton.marcarNumero(numero);
        }
    }


    public void mostrarMarcados(){
        for(Carton carton : cartones){
            carton.imprimirMarcados();
        }
    }

    public void setCartones(ArrayList<Carton> cartones){
    this.cartones= cartones;
    }

    public boolean hayCartonLleno(){
        for(Carton carton: cartones){
            if (carton.cartonLleno()) {
                return true;
            }
        }
        return false;
    }

    public void SoloFaltaUno(){
        for(Carton carton: cartones){
            if (carton.faltaUno()){
                System.out.println("El carton: "+carton.getIdCarton()+" esta a un numero de completarse");
            }
        }
    }
}
