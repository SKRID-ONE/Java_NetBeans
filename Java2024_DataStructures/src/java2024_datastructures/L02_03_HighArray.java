/*
Усовершенствованная версия работы с массивами*
 */
package java2024_datastructures;

/**
 *
 * @author Administration
 */

class HighArray {
    private long [] a;      //Ссылка на массив а 
    private int nElems;     // Количество элементов в массиве
    
    //Конструкторы:
    HighArray(){
        System.out.println("Set size!");
    }
    
    HighArray(int size){
        a = new long [size];    // Создание массива 
        nElems=0;               // Пока что нет элементов
    }
    
    //Метод поиска, возращает boolean******************************************* 
    public boolean find (long searchKey){
        
        int j;
        for (j = 0; j<nElems; j++){
            if (a[j] == searchKey) {
                break;    
            }    
        }
        
        // Проверка найдено ли значение?
        if (j == nElems){
            return false; //Нет
        } else {
            return true; // Да!
        }
    }
    
    //Метод вставки элемента****************************************************
    public void insert (long value){
        a[nElems] = value;  //Вставка
        nElems++;           //Увеличение счетчика элементов, чтобы следующая
                            //вставка была произведена в следующую ячейку
    }
    
    //Метод удаления элемента***************************************************
    public boolean delete (long value){
        //Сначала поиск элемента
        int j;
        for (j = 0; j<nElems; j++){
            if (a[j] == value) {
                System.out.println("Object "+value+" deleted!");
                break;

            }    
        }
        // Проверка найдено ли значение для удаления?
        if (j == nElems){
            return false;   //Нет
        } else {            // Да! Далее перезапись массива!
            for (int k = j; k<nElems; k++){
                a[k] = a[k+1];
            }
            nElems--;       //Уменьшение счетчика элементов, их стало меньше!
            return true; 
        }    
    }
    
    //Вывод всех элементов массива**********************************************
    public void display() {
        for (int j = 0; j<nElems; j++){
                System.out.print(a[j]+", ");
        }
        System.out.println();
    }

    //Выполнение задания 2.1****************************************************
        public long  getMax(){
            long maxValue = -1;
                for (int i=0; i<nElems;i++) {
                    if (a[i]>maxValue) {
                        maxValue=a[i];
                    }
                }
            return maxValue;
        }
    
    //Выполнение задания 2.2****************************************************
        public long  removeMax(){
            long maxValue = -1;

                for (int i=0; i<nElems;i++) {
                    if (a[i]>maxValue) {
                        maxValue=a[i];
                    }
                }
            delete(maxValue);
            return maxValue;

        }
    //**************************************************************************
        
    //Выполнение задания 2.6****************************************************
        public void noDups(){
            for (int i = 0; i <nElems; i++){
                for (int j = 0; j <nElems; j++){
                    if (i!=j & a[i]==a[j]){
                        delete(a[j]);   
                    }    
                }
            }
        }
    //2.6***********************************************************************

    
}



public class L02_03_HighArray {
    public static void main (String [] args){
        int maxSize = 100; // Размер массива
        
        HighArray arr;                  // Создание ссылки arr
        arr = new HighArray(maxSize);   //Создание массива
        
        
        arr.insert(66);
        arr.insert(00);                 //Вставка 10 элементов
        arr.insert(11);
        arr.insert(66);

        arr.insert(22);
        arr.insert(33);
        arr.insert(44);
        arr.insert(55);
        arr.insert(66);

        arr.insert(77);
        arr.insert(88);
        arr.insert(99);
        arr.insert(66);
        

        arr.display();
        
        //Выполнение задания 2.6************************************************
            arr.noDups();
        //2.6*******************************************************************
        
        
        arr.display();                  //Вывод массива
        System.out.println("Max value: "+arr.getMax());
        
        long  searchKey = 66;           //Элемент для поиска
        
        if (arr.find(searchKey)){
            System.out.println("Element "+searchKey+" found!");
        }else{ 
            System.out.println("Element "+searchKey+" not found!");
        }
        /*
        Мешают выполнению задания 2.3
        arr.delete(66);                 //Удаление трех элементов:
        arr.delete(99);
        arr.delete(00);
        
        arr.display();                  //Вывод измененного массива!
        
        System.out.println("Max value: "+arr.getMax());
        arr.removeMax();
        
        arr.display(); \
        */
        
//        //Выполнение задания 2.3************************************************
//            long [] b = new long [maxSize];
//            //Сортировка массива (от большего к меньшему)
//            for (int i = 0; i <maxSize; i++){
//                b[i] = arr.removeMax();
//            }
//            //Вывод нового массива
//            System.out.println("Отсортированный массив:");
//
//            for (int i = 0; i <maxSize; i++){
//                if (b[i]!=-1){
//                    System.out.print(b[i]+" ");
//                }
//            }
//            System.out.println();
//        //2.3*******************************************************************
        

    }
}
