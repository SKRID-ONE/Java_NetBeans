/*
Деление программы на классы
 */
package java2024_datastructures;

/**
В новой версии массив будет инкапсулирован в классе с именем LowArray. 
* Класс будет предоставлять методы, при помощи которых объекты других классов 
* (LowArrayApp в данном случае) смогут обращаться к массиву. 
* Эти методы обеспечивают взаимодействие между LowArray и LowArrayApp.
 */

//Создание нового класса (в котором мы будем хранить массив)
class LowArray {
    private long[] a; //Ссылка на массив "а"
    
    //Конструкторs:
    public LowArray(){
        System.out.println("You forgot to indicate the size of array");
    }
    
    public LowArray(int size){
        a = new long [size]; //Создание массива размером "size" и передаче ссылке "а"
    }
    
    //Метод для вставки элемента
    public void setElem(int index, long value){ // Два параметра индекс и значение для записи 
        a [index] = value;
    }
    
    //Метод для чтения элемента:
    public long getElem (int index) {
        return a [index];
    }
}


public class L02_02_LowArrayApp {
    public static void main (String [] args) {
        LowArray array = new LowArray(20);
        
        int nElems = 0;     // Количество элементов в массиве
        int j;              //Счетчик цикла
        
        array.setElem(0, 77); //Вставка в индекс 0 числа 77
        array.setElem(1, 55);
        array.setElem(2, 66);
        array.setElem(3, 88);
        array.setElem(4, 99);
        array.setElem(5, 00);
        array.setElem(6, 22);
        array.setElem(7, 33);
        array.setElem(8, 44);
        array.setElem(9, 11);
        
        nElems = 10; // Массив содержит 10 элементов (при этом длинна массива равна 20, см. строку 40)

        //Вывод всех используемых элементов массива
        for (j = 0; j <nElems; j++) {
            System.out.print(array.getElem(j)+" ");
        }
        System.out.println();
        
        //Поиск элемента********************************************************
        int searchKey = 26;     
        //Перебор массива
        for (j = 0; j <nElems; j++) {
            if(array.getElem(j)==searchKey){
                break;
            }
        }
        
        if (j == nElems) {
            System.out.println("Elements "+searchKey+" not found");
        } else {
            System.out.println("Elements "+searchKey+" found");
        }
        
        //Удаление элемента*****************************************************
        searchKey = 55;
        for (j = 0; j <nElems; j++) {
            if(array.getElem(j)==searchKey){
                System.out.println("Elements "+searchKey+" deleted");
                break;
            }
        }
        
        for (int k = j; k<nElems; k++){
            array.setElem(k, array.getElem(k+1));
        }
        nElems--; // Уменьшение размера (в книге так, но должно убавляться только при удачном удалении)
        
        //Повторный выыод массива***********************************************
        System.out.println("NEW ARRAY");
        for (j = 0; j <nElems; j++) {
            System.out.print(array.getElem(j)+" ");
        }
        System.out.println();
    }
}
