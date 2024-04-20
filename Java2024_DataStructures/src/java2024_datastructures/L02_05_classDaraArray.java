/*
Хранение объектов
 */
package java2024_datastructures;

/**

 */

class Person {
    private String lastName;
    private String firstName;
    private int age;
    
    //Конструктор
    public Person(String last, String first, int age){
        lastName = last;
        firstName = first;
        this.age = age;
    }
    
    //Методы
    public void displayPerson(){
        System.out.println(lastName+" "+firstName+", "+age+" age.");
    }
    
    public String getLast(){
        return lastName;
    }    
}

class ClassDataArray {
    private Person[] a; //Ссылка на массив класса Person
    private int nElems;
    
    public ClassDataArray (int size) {
        a = new Person[size];
        nElems = 0;   
    }
    
    //Поиск
    public Person find (String searchName){
        int j;
        //Поиск в массиве, определение индекса
        for (j=0;j<nElems;j++) {
            if (a[j].getLast() == searchName) {
                break;
            }
        }
        
        //Если индекс равен числу элемиентов, значит ничего не найдено.
        //P.S. елси элементов 10 то последний индекс a[9];
        if (j==nElems){
            return null;    //Не найдено
        } else {
            return a[j];    //Найдено
        }
    }
    
    //Добавление
    public void insert (String last, String first, int age){
        a[nElems] = new Person (last,first,age);
        nElems++;                                   //Увеличение счётчика
    }
    
    //Удаление
    public boolean delete (String searchName){
        int j;
        //Поиск в массиве, определение индекса
        for (j=0;j<nElems;j++) {
            if (a[j].getLast() == searchName) {
                break;
            }
        }
        
        //Смещение элементов массива
        for (int k = j; k<nElems; k++){
            a[k] = a [k+1];
        }
        nElems--;                                   //Уменьшеение счётчика
        return true;
    }
    
    public void displayArr(){
        for (int i=0; i<nElems;i++){
            a[i].displayPerson();
        }
    }
}

public class L02_05_classDaraArray {
    public static void main (String [] args) {
    
        Person person1 = new Person ("Veter", "Mike", 24);
        person1.displayPerson();

        int MaxSize = 100;
        ClassDataArray arr;                 //Ссылка
        arr = new ClassDataArray(MaxSize);  //Создание массива объектов

        //Вставка 10 объектов
        arr.insert("Spirin", "Kirill", 26);
        arr.insert("Spirina", "Kseniya", 24);
        arr.insert("Spirin", "Shustrik", 26);
        arr.insert("Ulitin", "I-one", 25);
        arr.insert("Ulitina", "Nastya", 25);
        arr.insert("Krilov", "Nikita", 24);
        arr.insert("Krilova", "Elena", 20);
        arr.insert("Grishina", "Nastya", 28);
        arr.insert("Alin", "Antoniy", 24);
        arr.insert("Alina", "John", 24);


        arr.displayArr();                   //Ввод содержимого
        
        System.out.println();
        System.out.println("Search Spirin");
        
        String searchKey = "Spirin";        //Поиск элемента (ключ)
        Person found;
        found = arr.find(searchKey);

        if (found != null) {
            System.out.println("Found it!");
            found.displayPerson();
        } else {
            System.out.println("Can't found "+searchKey);
        }
        System.out.println("______________________________");
        System.out.println("Delete Ulitina, Krilova, Alina");
        System.out.println();
        arr.delete("Ulitina");
        arr.delete("Krilova");
        arr.delete("Alina");
    
        arr.displayArr();                   //Ввод содержимого
    }
}
