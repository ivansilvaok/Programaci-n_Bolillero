import java.util.Random;
import java.util.ArrayList;

public class Bolillero{


    private ArrayList<Integer> bolillas;
    private Random aleatorio;


    public Bolillero(){
        aleatorio= new Random();

        DefinirBolillas();
    }

    public void DefinirBolillas(){

        bolillas= new ArrayList<>();
        for (int i = 1; i <90; i++) {
            bolillas.add(i);
        }
    }


    public int getBolillas(){
        if(bolillas.isEmpty()){
            throw new IllegalStateException("Ya salieron todas las bolillas");
        }

        int i= aleatorio.nextInt(bolillas.size());

        return bolillas.remove(i);
    }
}