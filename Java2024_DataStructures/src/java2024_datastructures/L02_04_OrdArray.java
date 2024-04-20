/*
Бинарный поиск в методе find()
Сортированный массив (метод intsert() сначала определяет позицию нового элемента
 */
package java2024_datastructures;

/*Программа orderedArray.java похожа на highArray.java (листинг 2.3). 
* Главное отличие заключается в том, что find() использует двоичный поиск.
 */

class OrdArray {
    private long a[];   //Ccылка на массив
    private int nElems; //Счетчик элементов данных
    
    //Конструктор
    OrdArray(int size){
        a = new long [size];    //Создание массива 
        nElems=0;
    }
    
    public int size () {
        return nElems;
    }
    
        
    //Метод бинарного поиска элемента*******************************************
    public int find (long searchKey) {
        int lowerBound = 0;         //Нижний предел области поиска
        int upperBound = nElems-1;  //Верхний предел области поиска
        int curIn;                  //Проверяемая ячейка
        
        while(true){
            curIn = (lowerBound+upperBound)/2;  //Определение среднего значения
            
            if (a[curIn] == searchKey) {
                return curIn;                   //Элемент найден
            } else if (lowerBound>upperBound) {
                return -1;                      //Элемент НЕ найден, З.Ы. в книге предлагают вернуть nElems - т.к. выходит за пределы массива (ну т.е. в массиве из 10 элементов, нет элемента с индексом a[10], т.к. начинается a[0];
            } else {
                if(a[curIn]<searchKey){         //Определение нового диапазона поиска
                    lowerBound = curIn+1;       //Находится в верхней половине
                }else{
                    upperBound = curIn-1;       //Находится в нижней половине
                }                               //+1 и -1 т.к. сама ячейка а[curIn] уже проверена
            }    
        }    
    }
    
    //Метод вставки элемента****************************************************
    // (можно добавить бинарный поиск, только на сравнение ><)
    public void insert (long value){
        int j = 0;
        
        //Определение места для вставки, чтобы массив был отсортирован.
        for(j=0; j<nElems; j++){
            if (a[j]>value) {
                break;
            }
        }
   
        
        //Перемещение последующих элементов из книги
        for (int k = nElems; k>j;k--) {
            a[k] = a[k-1];
        }
        
        
        a[j] = value;                   //Вставка нашего элемента
        nElems++;                       //Увеличиваем счётчик элементов
    }
    
      //Метод удаления************************************************************
    public boolean delete (long value) {
        
        int j = find(value);
        if (j ==-1) {
            System.out.println("Value "+value+" not found");
            return false;                   //Значение не найдено, удалять нечего.
        } else {
            for (int k = j; k<nElems; k++){ //Смещение остальных элементов массива
                a[k] = a [k+1];
                
            }
            nElems--;                       //Уменьшение счётчик элементов
            System.out.println("Value "+value+" is deleted");
            return true;
            
        }
    
    }
    
    //Метод вывода содержимого дисплея******************************************
    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    //Выполнение 2.4************************************************************
    public void insertBi(long value){
        //Бинарный поиск 
        int minValue = 0;
        int maxValue = nElems-1;    //(!)Ячейки с нуля
        int tryValue;

        while (true) {
            tryValue = (maxValue+minValue)/2;

            if (value>a[tryValue]&value<=a[tryValue+1]){    //Элемент найден!
                tryValue = tryValue+1;      //Новый элемент надо вставить в следующую учейку, которой он больше!
                break;
            }
             else if (value<a[0]){          //Если новый элемент меньше минимального значения
                tryValue = 0;
                break;
            }
            else if (minValue>maxValue) {
                tryValue = nElems;          //Если в массиве нет места между двух ячеек для вставки и оно больше минимального, значит новое значение на данный момент максимальное
                break;
            } else {                        //Поиск элемента
                if (value>a[tryValue]){
                    minValue = tryValue+1;
                } else {
                    maxValue = tryValue-1;
                }
            }
        }
        
        //Перемещение последующих элементов из книги
        for (int k = nElems; k>tryValue;k--) {
            a[k] = a[k-1];
        }
        
        
        a[tryValue] = value;                    //Вставка нашего элемента
        nElems++;                               //Увеличиваем счётчик элементов
      
    }
    
    public void deleteBi (long value) {
        //Двоичный поиск элемента для удаления
        int minValue = 0;
        int maxValue = nElems-1;            //Последняя занятая ячейка a[nElems-1]
        int tryValue;
        
        while(true){
            tryValue = (maxValue+minValue)/2;
            if (value==a[tryValue]) {          //Элемент найден!
                System.out.println("Value "+value+" is deleted");
                break;
            } else if (minValue>maxValue) { // Элемент не найден!
                tryValue = nElems;          // Присваиваем пустую ячейку (последняя занятая ячейка a[nElems-1])
                nElems++;                   // Алгоритм попытается "удалить" пустой элемент и уменьшит "отображаемых" количество элементов
                                            //Решается присвоением tryValue значения -1, но после этого надо будет добавлять для проверки if (tryValue=!-1)
                
                System.out.println("Value "+value+" is not found");
                break;
            } else {                        // Поиск элемента
                if (value>a[tryValue]){        // Определение нового диапазона поиска
                    minValue = tryValue+1;  // Значение  tryValue уже проверено, поэтому +1 и -1
                } else {
                    maxValue = tryValue-1;
                }
            }
        }
        
        //Удаление сдвигом оставшихся элементов
        for (int i = tryValue; i<nElems; i++) {
            a[i] = a[i+1];
        }
        nElems--;                           //Уменьшение счётчик элементов
    }
    
    
    //2.4***********************************************************************
        
    //Задание 2.5***************************************************************
    
    public long getValue (int i){
        return a[i];
    }
    
    public OrdArray merge(OrdArray a, OrdArray b) {
        //Создание нового массива        
        int nElemsC = a.nElems+b.nElems;
        OrdArray c = new OrdArray(nElemsC);
        
        //Заполнение нового массива данными из массива а
        for (int i = 0; i <a.nElems; i++) {
            c.insert(a.getValue(i));
        }
        
        //Заполнение нового массива данными из массива b
        for (int i = 0; i <b.nElems; i++) {
            c.insert(b.getValue(i));
        }
            
        return c;
    }
}


////////////////////////////////////////////////////////////////////////////////
public class L02_04_OrdArray {
    public static void main (String [] args){
        int maxSize = 100;              //Задание размера массива
        OrdArray arr;                   //Создание ссылки
        arr = new OrdArray (maxSize);   //Cоздание массива
        
        arr.insertBi(22);                 //Вставка 10 элементов
        arr.display();
        arr.insertBi(33);
        arr.display();
        arr.insertBi(11);
        arr.display();
        arr.insertBi(66);
        arr.insertBi(55);
        arr.insertBi(99);
        arr.insertBi(77);
        arr.insertBi(88);
        arr.insertBi(44);
        arr.insertBi(00);


        arr.display();                  //Вывод содержимого
        
        int searchKey = 11;             //Поиск элемента
        
        if (arr.find(searchKey)== -1) {
            System.out.println("Value "+searchKey+" not found");    //Не нашли
        } else {
            System.out.println("Value "+searchKey+" found");        //Нашли
        }
        
        
        
        
        arr.delete(00);                 //Удаление
        arr.delete(99);
        arr.delete(55);
        
        arr.display();                  //Вывод содержимого
        
        //Задание 2.4***********************************************************
        arr.insertBi(55);
        arr.insertBi(56);
        arr.display(); 
        
        System.out.println("*********************DELETE 55 and 99*********************");
        arr.deleteBi(55);
        arr.display(); 
        arr.deleteBi(99);
        arr.display();
        //2.4*******************************************************************
        
        //Задание 2.5(метод 1)**************************************************
        System.out.println("********25********");
        OrdArray arr1 = new OrdArray(100);
        OrdArray arr2 = new OrdArray(100);
        
        arr1.insertBi(4);
        arr1.insertBi(2);
        arr1.insertBi(3);
        arr1.insertBi(1);
        
        arr2.insertBi(8);
        arr2.insertBi(6);
        arr2.insertBi(7);
        arr2.insertBi(5);
        arr2.insertBi(0);
        arr2.insertBi(9);
        
        OrdArray arr3 = arr1.merge(arr1, arr2);
        arr3.display();
        //2.5*******************************************************************
    }
}
////////////////////////////////////////////////////////////////////////////////





/* Метод find();
В самом начале метода переменным lowerBound и upperBound приисваиваются индексы первой и последней занятой ячейки массива. Эти переменные определяют 
диапазон, в котором может находиться элемент с искомым ключом searchKey. Затем 
в цикле while текущий индекс curIn устанавливается в середину этого диапазона.
Если повезет, curIn сразу укажет на искомый элемент, поэтому мы сначала 
проверяем эту возможность. Если элемент найден, мы возвращаем его индекс curIn. 
При каждой итерации цикла диапазон уменьшается вдвое. В конечном итоге он сократится настолько, что дальнейшее деление станет невозможным. Эта ситуация 
проверяется в следующей команде: если lowerBound больше upperBound, значит, поиск 
завершен. (Если индексы равны, то диапазон состоит из одного элемента, и понадобится еще одна итерация цикла.) Поиск не может продолжаться без диапазона; 
если заданный элемент не найден, метод возвращает nElems, общее количество 
элементов. Это значение не является действительным индексом, потому что последняя заполненная ячейка массива имеет индекс nElems-1. Пользователь класса 
интерпретирует это значение как признак того, что элемент не был найден.
Если curIn не указывает на искомый элемент, а диапазон все еще остается достаточно большим, то его следует разделить пополам. Мы сравниваем значение 
по текущему индексу a[curIn], находящееся в середине диапазона, с искомым 
значением searchKey
сли значение searchKey больше, значит, поиск должен осуществляться в верхней половине диапазона. Соответственно lowerBound нужно присвоить значение 
curIn, а точнее индекс следующей ячейки, потому что ячейка curIn уже была проверена в начале цикла.
Если значение searchKey меньше a[curIn], то поиск следует ограничить нижней 
половиной диапазона. Соответственно upperBound смещается до ячейки, предшествующей curIn. На рис. 2.8 показано, как изменяется диапазон в этих двух 
ситуациях.
*/

