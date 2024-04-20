/*
    Демонстрация ключевого слова extends
 */
package java2024_h.schildt12;

/**
 * Как видите, подкласс В включает в себя все члены своего суперкласса А. Вот почему объект subOb может получать доступ к i и j и вызывать 
showij (). Кроме того, внутри sum () на i и j можно ссылаться напрямую, как 
если бы они были частью В.
 */

class A {
    int i;
    int j;
    
    void showij () {
        System.out.println("i and j = "+i+","+j);
    }
}

class B extends A {
    int k;
    
    void showk(){
        System.out.println("k:"+k);
    }
    
    void sum(){
        System.out.println("sum of i,j,k = "+(i+j+k));
    }
}

public class C08_01_Extends {
    
    public static void main (String [] args) {
        A superOb = new A();
        B subOb = new B();
        
        //Супер класс можно использовать сам по себе.
        
        superOb.i = 10;
        superOb.j = 20;
        superOb.showij();
        
        //Подкласс имеет доступ ко всем открытым членам своего суперкласса.
        subOb.i = 11;
        subOb.j = 21;
        subOb.k = 31;
        
        subOb.showij();
        subOb.showk();
        subOb.sum();
    }
}
