/*
    Переменная типа суперкласса может 
    ссылаться на объект подкласса
 */
package java2024_h.schildt12;

/**
Ссылочной переменной типа суперкласса можно присваивать ссылку на 
объект любого подкласса, производного от данного суперкласса.
 */
public class C08_03_Ref {
    public static void main (String [] args){
        
        //Классы BoxWeight и Box находятся в c08_02_Box01
        BoxWeight weightbox = new BoxWeight (1,2,3,4);
        Box plainbox = new Box();
        double vol;
        
        vol = weightbox.volume();
        System.out.println("Объем weightbox = "+vol);
        System.out.println("Вес weightbox = "+weightbox.weight);
        System.out.println();
        
        //Присвоить ссылку на BoxWeight ссылке на Box
        plainbox = weightbox;
        vol = plainbox.volume();
        System.out.println("Объем plainbox = "+vol);
        
        //Член weight не опреден в plainbox    *(1)
        //System.out.println("Вес plainbox = "+plainbox.weight);
    }
}       

/* (1)
Здесь weightbox является ссылкой на объекты BoxWeight, а plainbox -
ссылкой на объекты Вох. Поскол ьку BoxWeight - подкласс Вох, переменной 
plainЬox разрешено присваивать ссылку на объект weightbox. 
Важно понимать, что именно тип ссылочной переменной, а не тип объекта, на 
который она ссылается, определяет, к каким членам можно получать 
доступ. Другими словами, когда ссылочной переменной типа суперкласса 
присваивается ссылка на объект подкласса, то доступ имеется только к тем 
частям объекта, которые определены в суперклассе. Вот почему переменная 
plainbox не может получить доступ к weight, даже если она ссылается на 
объект BoxWeight. Если подумать, то в этом есть смысл, потому что суперклассу 
ничего не известно о том, что к нему добавляет подкласс. Поэтому 
последняя строка кода в предыдущем фрагменте закомментирована. Ссылка 
Вох не может получить доступ к полю weight, т.к. в классе Вох оно не определено. 
*/