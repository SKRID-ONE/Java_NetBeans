/*
Реализация сортировки методом выбора
 */
package java2024_datastructures;

/*

 */

class ArraySel {
    private long [] a;
    private int nElems;
    
    //Констуктор
    ArraySel(int size){
        a = new long [size];
        nElems = 0;
    }
    
    public void insert (long value){
        a [nElems] = value;
        nElems++;
    }
    
    public void display(){
        for (int i = 0; i <nElems; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    //Сортировка методоми выбора************************************************
    public void selectionSort () {
        //Внешний цикл, отсекает по одному значению слева
        for (int out = 0; out <nElems; out++){
            int min = out;
            //Внутренний цикл поменяет out ячейку на минимальную которую найдет, если не найдет поменяет саму с собой*
            for (int in = out; in<nElems; in++){
                if (a[in]<a[min]){          //!Сравнение именно с новым минимумом!
                    min = in;
                }
            }
            swap(out,min);
        }
        
        /*  Как я сам понял и написал
        for (int min=0; min<nElems; min++){
            int newMin = min;
            for (int i = min; i<nElems; i++) {
                if (a[i]<a[newMin]){
                    newMin = i;
                }
            } 
            swap(min, newMin);
        } 
        */
    }
    //**************************************************************************
    
    void swap (int q, int w){
        long e = a[q];
        a[q] = a[w];
        a[w] = e;
    }
    
}

public class L03_02_SelectSort {
    public static void main (String [] args) {
        
        int maxSize = 175000;
        ArraySel ar_1 = new ArraySel(maxSize);
//    ar_1.insert(3);
//    ar_1.insert(8);
//    ar_1.insert(0);
//    ar_1.insert(7);
//    ar_1.insert(2);
//    ar_1.insert(1);
//    ar_1.insert(6);
//    ar_1.insert(9);
//    ar_1.insert(5);
//    ar_1.insert(4);
    
//    //Генерация случайных чисел и заполнение массива
//        for (int i = 0; i < maxSize; i++) {
//            long n = (long) (java.lang.Math.random()*(maxSize-1));
//            ar_1.insert(n);
//        }
        for(int i = maxSize-1; i>0; i--){
            ar_1.insert(i);
        }
//        ar_1.display();
        System.out.println("********SORT********");


        ar_1.selectionSort();
//        ar_1.display();    
        
    }
}


