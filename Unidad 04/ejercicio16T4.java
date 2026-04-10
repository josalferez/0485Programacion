import java.util.Scanner;

public class ejercicio16T4 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int total = 0;
        char respuesta;
        
        // Pregunta 1
        System.out.print("¿Tu pareja parece estar más inquieta de lo normal sin ningún motivo aparente (v/f)?");
        respuesta = sc.next().charAt(0);
        if (respuesta == 'v'){
            total = total + 3;  // Equivalente a total+= 3;        
        }

        // Pregunta 2
        System.out.print("¿Ha aumentado sus gastos de vestuario? (v/f)");
        respuesta = sc.next().charAt(0);
        if (respuesta == 'v'){
            total+=3;        
        }
        
        // Pregunta 3
        System.out.print("¿Ahora se afeita y se asea con más frecuencia (si es hombre) o ahora se arregla el pelo y se asea con más frecuencia (si es mujer)? (v/f)");
        respuesta = sc.next().charAt(0);
        if (respuesta == 'v'){
            total+=3;        
        }   
        
        // Pregunta 4
        System.out.print("¿Ha perdido el interés que mostraba anteriormente por ti? (v/f)");
        respuesta = sc.next().charAt(0);
        if (respuesta == 'v'){
            total+=3;        
        }

        // Resultado del test:
		System.out.println("");
		System.out.println("El diagnóstico de nuestro informe es:");
        if (total >= 9){
            System.out.println("Ojito!");
        }else if(total > 5 && total < 9){
            System.out.println("Se está gustando");
        }else{
            System.out.println("Estate tranquilo.");
        }
        
        // Libero el recurso
        sc.close();
    }
}
