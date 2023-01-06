package cz.tul.alg1.pokorny.semes;

import java.util.Scanner;

/**
 * Program určí kolik zadaných bodů se nachazí
 * uvnitř, vně a na hranici zadaného trojúhelníka
 * @author michal.pokorny
 */
public class TrianglePoints {
    
    /**
     * hlavní metoda
     */
    public static void bodyVuciTrojuhleniku(){
        Scanner sc = new Scanner(System.in);
        final double PRESNOST = 0.000001;
        boolean pokracovat = true;
        while(pokracovat){
            
            //input
            System.out.println("zadej vrcholy trojuhelnika:");
            double[] a = {sc.nextDouble(),sc.nextDouble()};
            double[] b = {sc.nextDouble(),sc.nextDouble()};
            double[] c = {sc.nextDouble(),sc.nextDouble()};
            double obsahABC = obsahTrojuhelniku(a, b, c);
            if(obsahABC < PRESNOST){
                System.out.println("neplatne souradnice trojuhlenkiku");
                continue;
            }
            System.out.println("Zadej pocet testovanych bodu:");
            int numOfPoints = sc.nextInt();
            System.out.println("Zadej souradnice bodu:");
            
            //calc
            int sumUvnitr = 0;
            int sumNaHranici = 0;
            int sumVne = 0;
            for (int i = 0; i < numOfPoints; i++) {
                double[] p = {sc.nextDouble(), sc.nextDouble()};
                double obsahABP = obsahTrojuhelniku(a, b, p);
                double obsahACP = obsahTrojuhelniku(a,c,p);
                double obsahBCP = obsahTrojuhelniku(b, c, p);
                
                if (Math.abs(obsahABP + obsahACP + obsahBCP - obsahABC) < PRESNOST){
                    if (obsahABP * obsahACP * obsahBCP < PRESNOST){
                        sumNaHranici++;
                    }else{
                        sumUvnitr++;
                    }
                }else{
                    sumVne++;
                }

            }
            
            //output
            System.out.println("Uvnitr trojuhelnika lezi " + sumUvnitr + " bodu");
            System.out.println("Na hranici trojuhelnika lezi " + sumNaHranici + " bodu");
            System.out.println("Vne trojuhelnika lezi " + sumVne + " bodu");
            
            //pokracovani
            String input;
            do{
                System.out.println("Pokracovat ve zpracovani (a/n):");
                input = sc.next().toLowerCase();
                if(input.equals("n")){
                    pokracovat = false;
                }
            }while(!input.equals("a") && !input.equals("n"));
        }
      
    }
    
    /**
     * vezme souřadnice trí bodů, spočítá délky stran a vrátí obsah trojúhelníku
     * @param a 
     * @param b 
     * @param c 
     * @return  Obsah trojuhelnika ABC
     */
    public static double obsahTrojuhelniku(double[] a, double[] b, double[] c){
        double delkaA = Math.sqrt(Math.pow(b[0] - c[0], 2) + Math.pow(b[1] - c[1], 2));
        double delkaB = Math.sqrt(Math.pow(a[0] - c[0], 2) + Math.pow(a[1] - c[1], 2));
        double delkaC = Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
        // Heronův vzorec
        double s = (delkaA + delkaB + delkaC)/2;
        return Math.sqrt(Math.abs(s*(s-delkaA)*(s-delkaB)*(s-delkaC)));
    }
    
    
    /*
    public static void main(String[] args) {
        double a[] = {0, 0};
        double b[] = {5, 0};
        double c[] = {3, 4};
        System.out.println(obsahTrojuhelniku(a, b, c));
        
        double d[] = {0, 0};
        double e[] = {1, 2};
        double f[] = {2, 4};
        System.out.println(obsahTrojuhelniku(d, e, f));
    }*/
    
}
