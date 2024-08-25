package Pilha;

import java.util.Random;
import java.util.Stack;

public class PilhaDinamica03 {

    public static void main(String[] args) {
        Random random = new Random();
        
        
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();
        
        
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(9) + 1; 
            if (num >= 1 && num <= 3) {
                pilha1.push(num);
            } else if (num >= 4 && num <= 6) {
                pilha2.push(num);
            } else {
                pilha3.push(num);
            }
        }
        
       
        System.out.println("Fase 1: Pilhas iniciais");
        printStacks(pilha1, pilha2, pilha3);
        
       
        for (int i = 0; i < 100; i++) {
            int targetPilha = random.nextInt(3) + 1; 
            
            if (targetPilha == 1 && !pilha2.isEmpty() && !pilha3.isEmpty()) {
                int numFromPilha2 = pilha2.pop();
                int numFromPilha3 = pilha3.pop();
                System.out.println("Empilhando os números " + numFromPilha2 + " e " + numFromPilha3 + " na pilha 1");
                pilha1.push(numFromPilha2);
                pilha1.push(numFromPilha3);
            } else if (targetPilha == 2 && !pilha1.isEmpty() && !pilha3.isEmpty()) {
                int numFromPilha1 = pilha1.pop();
                int numFromPilha3 = pilha3.pop();
                System.out.println("Empilhando os números " + numFromPilha1 + " e " + numFromPilha3 + " na pilha 2");
                pilha2.push(numFromPilha1);
                pilha2.push(numFromPilha3);
            } else if (targetPilha == 3 && !pilha1.isEmpty() && !pilha2.isEmpty()) {
                int numFromPilha1 = pilha1.pop();
                int numFromPilha2 = pilha2.pop();
                System.out.println("Empilhando os números " + numFromPilha1 + " e " + numFromPilha2 + " na pilha 3");
                pilha3.push(numFromPilha1);
                pilha3.push(numFromPilha2);
            }
            
           
            if (pilha1.isEmpty() || pilha2.isEmpty() || pilha3.isEmpty()) {
                System.out.println("O programa foi encerrado porque uma das pilhas está vazia.");
                break;
            }
        }
        
       
        System.out.println("Fase 2: Pilhas finais");
        printStacks(pilha1, pilha2, pilha3);
    }
    
    private static void printStacks(Stack<Integer> pilha1, Stack<Integer> pilha2, Stack<Integer> pilha3) {
        System.out.println("Pilha 1: " + pilha1);
        System.out.println("Pilha 2: " + pilha2);
        System.out.println("Pilha 3: " + pilha3);
    }
}
