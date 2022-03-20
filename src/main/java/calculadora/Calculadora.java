package calculadora;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Calculadora {

    public static void main(String[] args) {
        new Calculadora();
    }

    public Calculadora() {
        System.out.println(suma(5,3));
        System.out.println(resta(10,3));
        System.out.println(multiplicacion(5,5));
        System.out.println(division(45,3));
    }

    private Integer resta(Integer argumentoA, Integer argumentoB){
        return argumentoA - argumentoB;
    }
    private Integer suma(Integer argumentoA, Integer argumentoB){
        return argumentoA + argumentoB;
    }
    private Integer multiplicacion(Integer aSumar, Integer iteracion){
        Integer acomulador = 0;

        for(int i =0; i<iteracion;i++){
            acomulador = suma(acomulador,aSumar);
        }
        return acomulador;
    }
    private Integer division(Integer dividendo, Integer divisor){

        if(divisor == 0){
            throw new IllegalArgumentException("No se puede dividir entre cero");
        }

        return estoyDividiendo(dividendo,divisor);
    }
    //Separamos el proceso de division para hacer un poco mas legible la division
    private Integer estoyDividiendo(Integer dividendo,Integer divisor){
        Integer cociente = 0;
        Integer acomulador = 1;
        Integer resultadoParcial = 0;
        boolean bandera = true;
        while(bandera){
            resultadoParcial = multiplicacion(divisor,acomulador);//divisor * acomulador;
            if(resultadoParcial < dividendo){
                acomulador++;
                continue;
            }else{
                if(resultadoParcial == dividendo){
                    cociente = acomulador;
                    bandera = false;
                }else{
                    cociente = acomulador-1;
                    bandera = false;
                }
            }
        }
        return cociente;
    }
}
