/*
 *Доступ к членам и наследование
 */
package java2024_h.schildt12;

/**
 *
 * @author Administration
 */
public class C08_02_Box01 {
    public static void main (String [] args) {
        //Создание объекта BoxWeight
        BoxWeight mybox1 = new BoxWeight(1,2,3,4);
        double vol1 = mybox1.volume();
        System.out.println("Объем фигуры 1 = "+vol1);
        System.out.println("Вес фигуры 1 = "+mybox1.weight);
        System.out.println();
        
        //Создание объекта BoxColor
        BoxColor mybox2 = new BoxColor(5,6,7,"red");
        double vol2 = mybox2.volume();
        System.out.println("Объем фигуры 2 = "+vol2);
        System.out.println("Цвет фигуры 2 = "+mybox2.color);
        
    }
}

class Box {
    private double width;
    double height;
    double depth;
    
    // Конструкторы:
    //  Конструктор для клонирования объекта  
    Box (Box ob){
        width=ob.width;
        height=ob.height;
        depth=ob.depth;
    }
    
    //Конструктор с тремя размерами
    Box (double w, double h, double d) {
        width = w;
        height = h;
        depth= d;
    }
    
    //Конструктор без размеров
    Box () {
        width = -1;
        height = -1;
        depth= -1;
    }
    
    //Конструктор для создания "куба"
    Box (double len) {
        width = len;
        height = len;
        depth= len;
    }
    
    //Методы:
    //Вычислить объем
    double volume(){
        return width*height*depth;
    }
    
}


//Наследование класса Box (extends) и включение weight
class BoxWeight extends Box {
       double weight;
       
       //Конструттор для BoxWeight
       BoxWeight(double w, double h,double d,double m){
            
            //Ошибка т.к. width переменная имеет модификатор private.
            //Её использование возможно с применением super() P.S. См. C08_03_Super
            //width = w;
            height = h;
            depth= d;
            weight = m;
       }
       
       //Конструттор если забыл указщать размеры.
       BoxWeight(){
            System.out.print("You lose size");
       }

}

//Добавление классу Box цвета.

class BoxColor extends Box {
    String color;
    
    BoxColor(double w, double h,double d, String c){
        //width = w;
        height = h;
        depth = d;
        color = c;
    }
}