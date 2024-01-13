
package ahorcado;

import java.util.Random;
import java.util.Scanner;

/*
 * JUEGO DEL AHORCADO
 * ACIERTA CON LA PELÍCULA
 * @author javier
 */
public class Ahorcado {

    
    public static void main(String[] args) {
        
        //Scanner teclado_int = new Scanner(System.in);
        Scanner teclado_str = new Scanner(System.in);
        int intentos = 8;
       
        //FUNCIÓN QUE MUESTRA LA PELI
        String pelicula = mostrarPeli();
        
        System.out.println(pelicula.length());// mostrar tamaño
        //muestra la peli codificada con un método char
        String peliCodificada = peliCodificada(pelicula);
        char[] cod = peliCodificada.toCharArray();
        System.out.println("---> "+ peliCodificada);
        
        // VARIABLE PARA INICIAR EL BUCLE
        boolean juegoTerminado = false;
        do{
            // SE SOLICITA LETRA POR TECLADO
            System.out.println("INTRODUCE UNA LETRA EN MAYUSCULA: ");
            String letra = teclado_str.nextLine();
            char[] letras = letra.toCharArray();
            boolean puntuar = false;
            
            // SE COMPRUEBA SI EXISTE LA LETRA
            for (int i = 0; i< pelicula.length(); i++){ 
                if (pelicula.charAt(i) == letras[0]){
                    cod[i] = letras[0];
                    puntuar = true;
                    
                }
            }
            if (puntuar == true){
                intentos = intentos;
            }else{
                intentos = intentos -1;
            }
            System.out.println(">>>> "+ String.valueOf(cod));
            System.out.println("TE QUEDAN: " + intentos + " INTENTOS");
            
            // MOSTRAMOS QUE EL JUGADOR HA GANADO
            if (String.valueOf(cod).equals(pelicula)){
                System.out.println("HAS ACERTADO LA PELICULA!!!!");
                //System.out.println("VOLVER A JUGAR? S / N");
                //String sino = teclado_str.nextLine();
                //if (sino.equals('S') || sino.equals('s')){
                juegoTerminado = true;      
            }
            if (intentos <= 0){
                System.out.println("HAS AGOTADO TODOS LOS INTENTOS SIN ADIVINAR LA PELICULA");
                System.out.println("LA PELICULA ES: " +pelicula);
                juegoTerminado = true;
            }
         
        }while (!juegoTerminado);
        System.out.println("GRACIAS POR JUGAR");
        System.out.println("PARA SALIR PULSA S");
        String salir = teclado_str.nextLine();
        if (String.valueOf(salir).equals("s")){
            System.exit(0);
        }
    }
    
    // MÉTODO QUE DEVUELVE UNA PELI EN STRING PARA PODER SACAR CADA CARACTER
    public static String mostrarPeli(){
        String arrayPeliculas[] = {"EN BUSCA DEL ARCA PERDIDA", "INDIANA JONES",
        "LA JUNGLA DE CRISTAL", "TERMINATOR", "LA FAMILIA ADAMS", "EL PADRINO",
        "PANDEMIC", "TOP GUN", "SINISTER", "LA CUPULA",
        "POLTERGUEIST", "EL EXORCISTA", "SCREAM", "ATRAPADA", "LA MATANZA DE TEXAS",
        "MALEFICIO", "RAMBO", "ET", "IT", "CAZAFANTASMAS",
        "EL MAGO DE OZ", "CENICIENTA", "HARRY POTTER"};  
        Random num = new Random(); // AL AZAR DECIDE UNA POSICIÓN DEL ARRAY
        int n = num.nextInt(arrayPeliculas.length);
        return arrayPeliculas[n];      
    }
           
    // MÉTODO PARA CODIFICAR LA PELI
    public static String peliCodificada(String peli){ 
        char[]letras = peli.toCharArray();
        for (int i = 0; i < letras.length; i++){
            if (Character.isLetter(letras[i])){
               letras[i] = '*'; 
            }         
        }
        return String.valueOf(letras);    
    }
 
    //MÉTODO QUE COMPRUEBA SI LA LETRA EXISTE
    public static String probarLetra(String pelicula, String letraSolicitada){
        char[]letras = pelicula.toCharArray();
        char[]letraSolic = letraSolicitada.toCharArray();
        //boolean es = false;
        for (int i = 0; i < letras.length; i++){
            if (letraSolic[0] == letras[i]){
                if (Character.isLetter(letras[i])){
                    letras[i] = letraSolic[0];
                          
                }    
            }else{
                if (Character.isLetter(letras[i])){
                    letras[i] = '*';
                    
                }   
            }
        }
        return String.valueOf(letras);
    }
 
}
