package cz.tul.alg1.pokorny.semes;

import java.util.Scanner;

/**
 * program slouží pro výběr a spuštěný určité úlohy - vánoční nebo semestrální
 * @author michal.pokorny
 */
public class UI {

    /**
     * hlavní main metoda
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean konec = false;
        while(!konec){
            System.out.println("vyber ulohu, kterou chces spustit (vanocni/semestralni/konec):");
            String uloha = sc.next().toLowerCase();
            if (uloha.equals("vanocni")){
                Christmas.present();
                System.out.println("");
            }else if(uloha.equals("semestralni")){ // changeeee na semestralni
                TrianglePoints.bodyVuciTrojuhleniku();
            }else if(uloha.equals("konec")){
                konec = true;
            }
            
        }
    }

}
