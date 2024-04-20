/*
Реализация сортировки методом вставки
 */
package java2024_datastructures;

/*

 */



class InsertSort {
    private long [] a;
    private int nElems;
    
    InsertSort(int size){
        a = new long [size];
        nElems = 0;
    }
    
    public void insert (long value) {
        a[nElems] = value;
        nElems++;
    }
    
    public void display(){
        for (int i = 0; i<nElems; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    //Метод сортировки вставкой (It is My!) Не работает 07.04.24
    public void insertSort (){
//        for(int out = 0; out<nElems; out++){    
//            long value = a [out];
//            System.out.println("Marker position: "+out+", marker value: "+ a[out]);
//
//            //Определяем новую позицию
//            int in = out;
//
//            while(true){
//                if (in>=0 && a[in]>value){
//                    in--;
//                }else {
////                    in++;
//                    System.out.println("New position of marker (in) = "+in);
//                    break;
//                }
//            }
//            
//            //Выполняем сдвиг вправо
//            for (int i = out; i>in; i--) {
//                a[i]=a[i-1];
//            }
//            a[in] = value;
//        }
        int out, in;
        long value;
        for (out = 0; out<nElems; out++) {
            in = out;
            value = a [out];
//            System.out.println("Marker position(out): "+out+", marker value: "+ a[out]);
            
            //Определение новой позиции
            while (in>0){
//                System.out.println(value+"_"+a[in]);
                if (value<a[in-1]) {
//                    System.out.println("n--");
                    in--;
                } else {
//                    System.out.println("New position of marker (in) = "+in);
                    break;
                }
            }
            //Выполняем сдвиг вправо
            for (int i = out; i>in; i--) {
                a[i]=a[i-1];
            }
            a[in] = value;
//            display();
        }
    }
    
    //Метод сортировки вставкой (из книги)
    public void insertSortPlus () {
        int out, in;
        long value;
        int nSwap = 0;
        int nCompare = 0;
        /* Маркер out. Инвариант: Начинается с ячейки a[1], все что до маркера, 
            считается частично отсортированным. 
            Т.е. Если есть элемент a[0] на первой итерации считается частично отсортированным
            Это логично - ведь он единственный.
            Также начинается с ячейки а[1], т.к. надо сравнивать с предыдущей ячейкой.
            Иначе (если а[0]) произойдент выход за пределы массива.
        */
        for (out = 1; out <nElems; out++){
            in = out;
            value = a[out];
            
            //Определение нового места на маркерованного элемента
            // in>0 чтобы не выйти за пределы массива
            while (in>0 && a[in-1]>=value) {
                a[in] = a[in-1];
                in--;
                nCompare++;
                nSwap++;
            }
            //Вставляем маркерованный элемент на новое место
            if(a[in]==value){
                //
            }else{
                a[in] = value;
                nSwap++;
            }
        }
        
        //Вывод количества сравнений и перестановок
        System.out.println("Сравнений: "+nCompare+". Перестановок: "+nSwap);
    }
    //Задание 3.2***************************************************************
    public long median () {
        return a[nElems/2];
    }
    //3.2***********************************************************************
    
    //Задание 3.3***************************************************************
    public void noDups () {
        for (int i = 0; i<nElems-1; i++) {
            int k = 0;
            
            //Т.к. алгоритм отсортирован, то дубликаты идут друг за другом
            if (i<nElems&&a[i]==a[i+1]){
                //Когда встретился дубликат, считает сколько всего таких значений
                for (int j = i; j<nElems;j++) {
                    if (j<nElems && a[i]==a[j]){
                        k++;
                    }
                }
                //Смещает оставшийся массив
                for (int l=i;l<nElems;l++) {
                    
                    if (l+k-1<nElems) {         //Проверка выхода за пределы массива
                        a[l] = a [l+k-1];
                    }
                }
                nElems-=k-1;
            }
        }
    }
    //3.3***********************************************************************
    
    //Задание 3.6 - Удаление дубликатов сортировкой вставки*********************
    
    
    public void insertSortNoDups() {
        int in, out;
        long value;

        
        for (out = 1; out<nElems; out++) {          //Внешний маркер
            value = a [out];
            
            //Определение нового места
            in = out;
            int k=0;
            while (in>0 && a[in-1]>=value) {
                
                if (a[in-1] == value){
////                    ДОДЕЛАТЬ
////                    System.out.println(a[in-1]+" is having dups");
////                    a[in] = a[in-2];
////                    break;
                } else {
                    a[in] = a[in-1];
                }
                in--;
            }
            a [in] = value;
            
            if (k>0){
                System.out.println(a[in]+": " +k);
            }
        }
    
    }
    //3.6***********************************************************************
}

public class L03_03_InsertSort {
    public static void main (String [] args){
        int  maxSize = 100;
        InsertSort ar_2 = new InsertSort(maxSize);
        
        ar_2.insert(9);
        ar_2.insert(9);
        ar_2.insert(9);
        ar_2.insert(5);
        ar_2.insert(5);
//        ar_2.insert(9);
//        ar_2.insert(2);
//        ar_2.insert(4);
//        ar_2.insert(5);
//        ar_2.insert(5);
//        ar_2.insert(5);
//        ar_2.insert(3);



//          for (int i = 0; i<maxSize; i++){
//              long n = (long) (java.lang.Math.random()*(maxSize-1));
//              ar_2.insert(n);
//          }

//        for(int i = maxSize-1; i>0; i--){
//            ar_2.insert(i);
//        }
        ar_2.display();
        
        ar_2.insertSortNoDups();
        
        System.out.println("********SORT********");
        ar_2.display();
//        System.out.println("Медиана массива: "+ar_2.median());
        
//        ar_2.noDups();
//        ar_2.display();
    }
}
