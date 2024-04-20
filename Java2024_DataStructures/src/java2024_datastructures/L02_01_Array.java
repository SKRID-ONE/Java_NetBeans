/*
Пример массива
 */
package java2024_datastructures;

/**

 */
public class L02_01_Array {
    public static void main (String [] args) {
        long [] arr;            //Ссылка на массив
        arr = new long[10];    //Создание массива
        int nElems = 0;         //Кол-во эл-в
        int j;                  //Счётчик цикла
        long searchKey;         //Ключи искомого элемента
        
  
        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        
        nElems = arr.length; // 10
        
        searchKey = 66;//Поиск элемента с ключом 66
        
        //Вывод массива в консоль
        for (j = 0; j <nElems; j++){
            System.out.println("arr["+j+"] = "+arr[j]);
        }
        
        //ПОИСК ЭЛЕМЕНТА********************************************************
        for (j=0; j<nElems; j++){
            if (arr[j] == searchKey) {
                System.out.println("I FIND "+searchKey+" !");
                break;
            }
            
            //Есди обошел весь массив и не встретил ключ
            if (j == nElems-1){
                System.out.println("I can't find: "+searchKey);
            }
        }
        
        //УДАЛЕНИЕ элемента*****************************************************
        searchKey = 55; //Номер эл-та
        for (j=0; j<nElems; j++){
            if (arr[j] == searchKey) {
                System.out.println("Elements "+ searchKey+ " is deleted");
                nElems--; // Если нашел размер "заполненной области" уменьшается на 1
                break;
            }
        }
            //Удаление происходит смещением(сдвигом) остальных элементов:
            for (int k=j; k<nElems; k++){
                arr[k] = arr [k+1];
            }
            
            //Есди обошел весь массив и не встретил ключ
            if (j == nElems){
                System.out.println("I can't delete: "+searchKey);
            }
        

        
        
        //Вывод сдвинутого массива в консоль P.S. Последний элемент массива всё же существует, 
        // т.е. ячейка 10 которая имела значение 33 также будет иметь значение 33.
        for (j = 0; j <nElems; j++){
            System.out.println("arr["+j+"] = "+arr[j]);
        }
    }
}
