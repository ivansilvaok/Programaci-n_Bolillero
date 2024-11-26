import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet; //Representa una coleccion que no permite elementos duplicados
import java.util.Set; 



public class Carton {
    
private ArrayList <Integer> carton;
private ArrayList <Boolean> marcados;
private Random aleatorio;
private String id_carton;


//Este constructor de la clase Carton inicializa un nuevo cartón con un ID dado
public Carton (String id_carton){

    this.id_carton= id_carton;

    aleatorio= new Random();  //configura generadores de números aleatorios

    carton= new ArrayList<>();
    //crea las listas necesarias para almacenar los números del cartón y los elementos marcados
    marcados=new ArrayList<>(Collections.nCopies(15, false));

    DefinirCarton();
    //llama a métodos para definir y ordenar el contenido del cartón. 
    OrdenarCarton();

}


public void DefinirCarton(){

    Set<Integer> numerosUsados = new HashSet<>();
    while (carton.size()<15) {
        int numero= aleatorio.nextInt(90) +1;
        if (!numerosUsados.contains(numero)){
            carton.add(numero);
            numerosUsados.add(numero);
        }
        
    } 
}

public void OrdenarCarton(){
    Collections.sort(carton);
}

public String getIdCarton(){
    return id_carton;
}

public ArrayList<Integer> getCarton(){
return carton;
}

public void imprimirCarton(){

    System.out.println("Carton: "+id_carton+":"+carton);
}


public void marcarNumero(int numero){
int index= carton.indexOf(numero);
if(index != -1){
    marcados.set(index, true);
}
}


public void imprimirMarcados(){

    System.out.println("Carton: "+id_carton+" Marcados: "+marcados);
}

public boolean cartonLleno(){
for(boolean marcado : marcados){
    if (!marcado) {
        return false;
    }
}
    return true;

}

public boolean faltaUno(){
    int falta= 0;
    for(boolean marcado:marcados){
        if (!marcado) {
            falta ++;
        }
    }
    return falta==1;
}

}

