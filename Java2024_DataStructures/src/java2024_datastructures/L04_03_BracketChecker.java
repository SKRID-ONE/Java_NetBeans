/*
Пример использования стека № 2. Поиск парных скобок
 */
package java2024_datastructures;

import java.io.*;

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

class BracketChecker {
    private String input;                   //Входная строка
    
   //Конструктор
    BracketChecker (String in) {
        input = in;
    }
    //Метод проверки парных скобок
    public void check(){
        int stackSize = input.length();     //Определение размера стека
        StackX stack = new StackX(stackSize);   //Создание стека
        
        //Последовательное чтение символов строкиэ
        for (int j = 0; j<input.length();j++) {
            char ch = input.charAt(j);
            //Отбор нужных символов: {}[]()
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    //Извлечь и проверить если стек не пустой
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if (ch=='}' && chx != '{' ||
                            ch==']' && chx != '[' ||
                            ch==')' && chx != '('){
                            System.out.println("Error: "+ch+" at "+j);
                        }  
                    } else {    //Преждевременная нехватка элементов
                        System.out.println("Error: "+ch+" at "+j);  
                    } 
                    break;
                default:
                    break;          //Для остальных символов, ничего не делать.
            }     
        }
        //В этой точке обработаны все символы, цикл закончился
        if (!stack.isEmpty()){
            System.out.println("Error: missing right delimiter");   //Потерян символ справа
        }
    }   
}

public class L04_03_BracketChecker {
    public static void main(String[] args) throws IOException{
        //Ввод данных с консоли
        String input;
        System.out.print("Enter code");
        System.out.flush();
        input = getString();
        
        //Выполение проверки скобок в строке кода (input)
        BracketChecker theChecker = new BracketChecker(input);
        theChecker.check();
    }
    
    //Чтение строки
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = br.readLine();
        return input;
    }
}
