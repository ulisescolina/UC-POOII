/*
   Se van a crear 10 cuentas las cuales van numeradas del 1 al 10
   las cuentas pares vas a ser de tipo Convenio y las impares de tipo Comun.
   al llamar a: 
    comprarPuntos(X, Y) estamos tratando de comprar Y puntos para la cuenta X.
    lo que debe devolvernos es la cantidad de puntos, lo cual se calcula diferente dependiendo del valor de X.
   
    Las organizaciones se crean con costoPorPunto = 2.
    Las cuentas comunes tienen un costoPorPunto = 5.

    Cuando X es par, el resultado esperado debe ser: 2 (siempre)
    Cuando X es impar, el resultado esperado debe ser: Y/5 (dado a que todas las organizaciones se crean con un costo por punto de 5)
 */
package p1;
import modelo.Sistema;

/**
 *
 * @author ulisss
 */
public class P1 {
    public static void main(String[] args) {
        Sistema s = Sistema.getInstancia();
        
        if (args.length == 2) {
            if (args[0] != null && args[1] != null) {
                try {
                    System.out.println(s.comprarPuntos(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
                } catch (NumberFormatException e) {
                    System.err.print("No se puede transformar los parametros a formato numerico\n");
                    return;
                }
                return;
            }
        } else {
            System.err.print("Cantidad de parametros incorrecta.\n\nSolo se admiten dos parametros\n");
            return;
        }
        
        System.out.println(s.comprarPuntos(1, 20000));   
    }
}
