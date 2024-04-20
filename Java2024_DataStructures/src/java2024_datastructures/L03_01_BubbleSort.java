/*
Реализация пузырьковой сортировки 
 */
package java2024_datastructures;

/*

 */

class ArrayBub {
    private long[] a;       //Ссылка на массив а[]
    private int nElems;     //Количество элементов массива
    
    //конструктор
    ArrayBub(int masxSize){
        a = new long [masxSize];    //Создание массива
        nElems=0;                   //Счетчик количества элементов = 0
    }
    
    //Метод простой вставки
    public void insert (long value) {
        a[nElems]=value;
        nElems++;
    }
    
    //Метод вывода массива на дисплей
    public void display(){
        for (int i = 0; i<nElems; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    //ПУЗЫРЬКАВАЯ СОРТИРОВКА****************************************************
  
    
    //Пузырьковая сортировка (несовершенная, т.к. проверяет уже отсортированное)
    public void bubbleSort (){
        for (int i=0; i<nElems;i++){

            //Данная часть алгоритма отсортирует только одно значение. Для того,
            //чтобы прогнать каждый элемент, данную сортировку необходимо провести
            //столько раз,сколько элементов у нас есть (поэтому она в еще одном цикле)
            for (int j=0;j<nElems-1;j++){   //nElems-1 т.к. индекс последней ячейки a[nElems-1]
                if(a[j]>a[j+1]){
                    swap(j,(j+1));
                }
            }
        }
    }
    
    //Более совершенная пузырьковая сортировка, т.к. не проверяет правую отсортированную часть.
    public void bubbleSortPlus (){
        //Внешний цикл
        for (int out=nElems-1; out>0;out--){          //в книге (i>1), мне проще для понимания i>0
            
            //Внутренний цикл (прогонит вправо только одно число)
            for (int in=0;in<out;in++){   //nElems-1 т.к. индекс последней ячейки a[nElems-1]
                if(a[in]>a[in+1]){
                    swap(in,(in+1));
                }
            }
        }
    }
    //Задание 3.1***************************************************************
    public void bubbleSortDouble () {
        /*Метод ищет сначала максимальное значение и сдвигает его вправо, 
        * затем ищет минимальное и сдвигает его влево.
        */
        int max;        //До какого значения сдвигать вправо 
        int min = 0;    //До какого значения сдвигать влево
        int in;         //Внутренний цикл
        
        for (max=nElems-1; max>min; max--) {  //Внешний цикл, уменьшает диапазон сдвига

            for (in = min; in<max; in++){     //Внутренний цикл, сдвигает вправо
                if(a[in]>a[in+1]){
                    swap(in,(in+1));
                }
            }
            max--;
            
            for (in = max; in>min;in--) {   //Внутренний цикл, сдвигает влево
                if (a[in]<a[in-1]) {
                    swap(in,(in-1));
                }
            }
            min++;
        }
    }
    //3.1***********************************************************************
    
    public void swap(int x, int y){
        long z = a[x];
        a[x] = a[y];
        a[y] = z;
    }
    
    //Задание 3.4***************************************************************
    public void oddEvenSort() {
        
        for (int n = 0; n<(nElems/2); n++) {        //Сделать n раз
            for (int i = 0; i<nElems-1; i+=2) {
                if(i+1<nElems & a[i]>a[i+1]){
                        swap(i,(i+1));
                    }
            }
            for (int i = 1; i<nElems-1; i+=2) {
                if(i+1<nElems & a[i]>a[i+1]){
                        swap(i,(i+1));
                    }
            }
        }
    }
    
    //3.4***********************************************************************
}

public class L03_01_BubbleSort {
    
    public static void main (String args[]){
        int maxSize = 175000;
        ArrayBub arr1 = new ArrayBub (maxSize);

//        arr1.insert(33);
//        arr1.insert(22);
//        arr1.insert(11);
//        arr1.insert(44);
//        arr1.insert(66);
//        arr1.insert(55);
//        arr1.insert(99);
//        arr1.insert(00);
//        arr1.insert(77);
//        arr1.insert(88);

        //Генерация случайных чисел и заполнение массива
        for (int i = 0;i<maxSize;i++ ) {
            long n = (long) (java.lang.Math.random()*(maxSize-1));
            arr1.insert(n);
        }
        //Вставка элементов в обратном порядке *(для определения максимального времени сортировки)
//        for(int i = maxSize-1; i>0; i--){
//            arr1.insert(i);
//        }
//        arr1.display();
        
        System.out.println("SORT");
//        arr1.bubbleSortDouble();
        arr1.oddEvenSort();
//        arr1.swap(8, 9);
//        arr1.display();
        
        
        
    }
}
