/*
Реализация сортировки объектов на языке Java
 */
package java2024_datastructures;

/**
    Лексикографические сравнения после кода
 */
//Создание класса-объекта Person
class Person {
    private String lastName;
    private String firstName;
    private int age;
    
    //Constructures
    public Person (String last, String first, int age){
        lastName = last;
        firstName = first;
        this.age = age;
    }
    
    public void displayPerson(){
        System.out.println("Last name: "+lastName+". First name: "+firstName+". Age: "+age);
    }
    
    public String getLast(){
        return lastName;
    }
}

//Сохдание класса-массива объектов Person

class ArrayInObj {
    private Person [] a;    //Ссылка на массив "а" объектов Person
    private int nElems;
    
    //Constructure
    ArrayInObj (int size) {
        a = new Person [size];
        nElems = 0;
    }
    
    public void insert(String last, String first, int age){
        a [nElems] = new Person (last, first, age);
        nElems++;
    }
    
    public void display() {
        for (int i = 0; i<nElems;i++){
            a[i].displayPerson();
        }
    }
    //Сортировка объектов методом всставки
    public void insertionSort(){
        int out, in;
        Person value;       //Создание ссылки value на объект Person 
        
        for (out = 1; out<nElems; out++) { // out - маркер. Левее маркера всё частично отсортированно.
                                           // Начинается с 1, чтобы проверить с 0-м элементом. И не выходить за предел массива.
            in = out;
            value = a[out];
            //Сдвиг поэлементно вправо эл-в, которые меньше чем value
            while (in>0 && a[in-1].getLast().compareTo(value.getLast())>0) {
                a[in] = a [in-1];
                in--;                   //Try in--
            }
            a [in] = value;
        }
    }
    
}

public class L03_04_ObjectSort {
    public static void main (String [] args){
        int maxSize = 100;
        ArrayInObj arr;
       
        arr = new ArrayInObj(maxSize);
        //Вставка 10 объектов
        arr.insert("Spirin", "Kirill", 26);
        arr.insert("Spirina", "Kseniya", 24);
        arr.insert("Spirin", "Shustrik", 2);
        arr.insert("Ulitin", "I-one", 25);
        arr.insert("Ulitina", "Nastya", 25);
        arr.insert("Krilov", "Nikita", 24);
        arr.insert("Krilova", "Elena", 20);
        arr.insert("Grishina", "Nastya", 28);
        arr.insert("Alin", "Antoniy", 24);
        arr.insert("Alina", "John", 24);
        arr.display();
        
        System.out.println("Array was sorted");
        arr.insertionSort();
        
        arr.display();
    }
}

/*
Лексикографические сравнения
Метод insertSort() в объекте objectSort.java сходен с аналогичным методом программы insertSort.java, но он был адаптирован для сравнения объектов по ключевому полю lastName вместо значения примитивного типа.
Метод compareTo() класса String используется для выполнения сравнений в методе insertSort(). Выражение, в котором он используется, выглядит так:
a[in-1].getLast().compareTo(temp.getLast()) > 0
Метод compareTo() возвращает разные целочисленные значения в зависимости 
от относительного лексикографического (то есть алфавитного) расположения объекта String, для которого вызван метод, и объекта String, переданного в аргументе. 
Возвращаемые значения перечислены в табл. 3.1.
Например, если s1 содержит строку «cat», а s2 — строку «dog», функция вернет 
отрицательное число. В программе objectSort.java этот метод используется для 
сравнения строки фамилии a[in-1] со строкой фамилии temp
*/