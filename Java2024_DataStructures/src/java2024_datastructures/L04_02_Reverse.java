/*
Пример использования стека № 1.
Перестановка букв в слове
 */
package java2024_datastructures;
import java.io.*;               //Для ввода/вывода данных



class StackX {
    private int maxSize;
    private char [] stackArray;
    private int top;
    
    StackX(int s){
        maxSize = s;
        stackArray = new char [s];
        top = -1;
    }
    
    public void push (char value) {         //Размещение элемента на вершине стека
        stackArray[++top]=value;
    }
    
    public char pop () {                    //Извлечение элемента с вершины
        return stackArray[top--];
    }
    
    public char peek () {                   //Подсмотреть последний элемент
        return stackArray[top];
    }
    
    public boolean isEmpty() {              //True если стек пуст
        return (top==-1);
    }
    
    public boolean isFull(){                //True если стек полон
        return (top==maxSize-1);
    }
}

//Класс Reverser 
class Reverser {
    private String input;                   //Входная строка
    private String output;                  //Выходная строка
    
    //Конструктор
    public Reverser (String in) {
        input = in;
    }
    
    public String doRev() {                 //Перестановка символов
        int stackSize = input.length();     //Определение размера стека
        StackX theStack = new StackX(stackSize);    //Создание стека
        
        //Посимвольное прочтение строки и занесение в стек
        for (int j = 0; j<input.length(); j++){
            char ch = input.charAt(j);
            theStack.push(ch);
        }
        
        output = "";
        //Извлечение данных из стека
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();       //Извлечение символа
            output+= ch;                    //Присоединение символа к строке
        }
        return output;
    }
    
}

public class L04_02_Reverse {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("Enter a string");
            System.out.flush();
            input = getString();
            if (input.equals("")) {     //Если ничего не ввести, то программа завершится
                break;
            }
         
            Reverser theR = new Reverser(input);
            output = theR.doRev();
            System.out.println("Reversed String: "+output);
        }
    }
    
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
