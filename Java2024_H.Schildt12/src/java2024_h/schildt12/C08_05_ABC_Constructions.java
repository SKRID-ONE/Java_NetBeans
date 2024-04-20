/* 
Демонстрация очередности выполнения конструкторов .
 */
package java2024_h.schildt12;

/**
 *
 * @author Administration
 */
public class C08_05_ABC_Constructions {
    public static void main (String [] args) {
        CC cc = new CC();
        
    }
}

class AA {
    AA (){
        System.out.println("AA construction");
    }
}

class BB extends AA {
    BB (){
        System.out.println("BB construction");
    }
}

class CC extends BB {
    CC (){
        System.out.println("CC construction");
    }
}