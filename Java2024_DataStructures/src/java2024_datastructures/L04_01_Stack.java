/*
Реализация стека на языке Java
 */
package java2024_datastructures;

/*

 */

class StackX {
    private int maxSize;
    private long [] stackArray;
    private int top;
    
    public StackX (int s) {
        maxSize = s;
        stackArray = new long [s];
        top = -1;
    }
    
    public void push (long j){
        stackArray [++top] = j;         //Сначала увеличение переменной топ
    }                                   //потом вставка элемента

    public long pop () {
        return stackArray[top--];       //Сначала возвращение элемента
    }                                   //потом уменьшение топ
    
    public long peek(){                 //Чтение элемента с вершины стека
        return stackArray[top];
    }
    
    public boolean isEptry(){           //Проверка пуст ли стек
        return (top==-1);               //True если стек пуст
    }
    
    public boolean isFull() {           //Проверка полон ли стек
        return (top == maxSize-1);
    }
}


public class L04_01_Stack {

    public static void main(String[] args) {
        StackX theStack = new StackX(10);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        
        while (!theStack.isEptry()) {
            long value = theStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();
    }
    
}
