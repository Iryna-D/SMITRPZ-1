/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Iryna
 */
public class JavaApplication2 {  // ищем строки короче средней

    /**
     * @param args the command line arguments
     */
    public static String[] st(String[] instr) {  // возвращает строки короче среднего
        String[] c = new String[5];  // тут строки на выход
        int Sum = 0, Mid = 0;  // сумма и среднее
        for(int i = 0; i < 5; i++) {   // вычисляем сумму
            Sum = Sum+instr[i].length();
        }
        Mid=Sum/5; // вычисляем среднее
        for(int i = 0; i < 5; i++) {   // строки на выход
            if(instr[i].length()<Mid) {c[i]=instr[i];}
        }
        return c;
    }
        
    public static void main(String[] args) {
        String[] a = new String[5];  // строки на входе
        a[0]="3 s"; a[1]="4 sy"; a[2]="5 sym"; a[3]="6 symb"; a[4]="7 symbo";

        String[] b = new String[5];  // строки на выходе
        b=st(a);  // вызываем функцию

        System.out.println(b[0]);  //Выводим строки с результатами
        System.out.println(b[1]);  
        System.out.println(b[2]);  
        System.out.println(b[3]);  
        System.out.println(b[4]);  
    }

}
