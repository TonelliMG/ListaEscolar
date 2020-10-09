package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.Scanner;

public class BASE {
    
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

    List<Professor> ListaProfessor=new ArrayList<Professor>();
    Professor xProfessor;
    
        int opcao;

        do{
            menu();
            opcao = S.nextInt();
            
            switch(opcao){
            case 1: 
                Adicionar(ListaProfessor);
                break;
                
            case 2:
                Listar(ListaProfessor);
                break;
                
            case 3:
                Remover(ListaProfessor);
                break;
                
            case 4:
                Limpar(ListaProfessor);
                break;
                
            case 5:
                Verificar(ListaProfessor);
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }

//////////////////////////////////////////////////////////////////////////////// ABRIR O MENU DE OPCOES

    public static void menu(){
        System.out.println("\tBEM VINDO AO GESTOR, QUAL OPERAÇÃO VOCÊ DESEJA REALIZAR:");
        System.out.println("0. Encerrar");
        System.out.println("1. Adicionar um professor ao sistema");
        System.out.println("2. Listar todos os professores presentes na lista");
        System.out.println("3. Remover um professor da lista");
        System.out.println("4. Remover todos os professores da lista");
        System.out.println("5. Verificar se um professor existe na lista");
        System.out.println("Opcao desejada:");
    }

//////////////////////////////////////////////////////////////////////////////// ADICIONAR PROFESSOR A LISTA

    static void Adicionar(List<Professor> ListaProfessor){
        
        Scanner S = new Scanner(System.in);
        
        Professor xProfessor;
        xProfessor= new Professor();
        
        ConsoleClear();
        System.out.println();
        
        System.out.println("\nDigite a matricula do professor:");
        xProfessor.Matricula=S.nextLine();
        
    
        
        System.out.println("\nDigite o nome do professor:");
        xProfessor.Nome=S.nextLine();
        
        System.out.println("\nDigite o email do professor:");
        xProfessor.Email=S.nextLine();
        
        System.out.println("\nDigite o telefone do professor:");
        xProfessor.Telefone=S.nextLine();
        
        ListaProfessor.add(xProfessor);
        
        ConsoleClear();
        System.out.println();
    }

//////////////////////////////////////////////////////////////////////////////// LISTAR TODOS OS PROFESSORES -> MATRICULA, NOME, TELEFONE, EMAIL

    static void Listar(List<Professor> Cad){
        
        Scanner S = new Scanner(System.in);
        
        ConsoleClear();
        System.out.println();
        int pos=1, esc;
        
        for(Professor x:Cad){
            System.out.println("#"+pos+"");
            System.out.printf("MATRICULA: %1$s", x.Matricula);
            System.out.printf("\nNOME: %1$s", x.Nome);
            System.out.printf("\nTELEFONE: %1$s", x.Email);
            System.out.printf("\nEMAIL: %1$s", x.Telefone);
            System.out.println("");
            System.out.println("");
            pos++;
        }
        do{
        System.out.println("Digite 1 para retornar ao menu principal:");
        esc=S.nextInt();
        }while(esc!=1);
        ConsoleClear();
        System.out.println();
    }

//////////////////////////////////////////////////////////////////////////////// VERIFICAR A EXISTENCIA DO PROFESSOR POR MEIO DA SUA POSICAO NA LISTA

    static void Verificar(List<Professor> ListaProfessor){
        
        Scanner S = new Scanner(System.in);
        
        int posicao=-1;
        
        ConsoleClear();
        System.out.println();
        
        System.out.println("Digite o numero de matricula para verificar a existencia:");
        String Item;
        Item=S.nextLine();
        
        for(Professor x:ListaProfessor){
        if(x.Matricula.equals(Item)){
        posicao=ListaProfessor.indexOf(x);
        }
        }
        
        if(posicao>=0){
            System.out.printf("\nProfessor encontrado na posição %1$d da lista.\n", posicao+1);
        }
        else{
            System.out.println("\nProfessor não encontrado na lista.\n");
        }
    }

//////////////////////////////////////////////////////////////////////////////// REMOVER UM PROFESSOR DA LISTA POR MEIO DA SUA MATRICULA

    static void Remover(List<Professor> ListaProfessor){
        
        Scanner S = new Scanner(System.in);
        
        ConsoleClear();
        System.out.println();
        
        System.out.println("Digite a posição do Professor que você deseja remover:");
        int y, z;
        y= S.nextInt();
        z= y-1;
        
        if (z<ListaProfessor.size()){
            ListaProfessor.remove(z);
        }
        
        else{
            System.out.println("Nao existe ninguem na posicao desejada");
        }
    }

//////////////////////////////////////////////////////////////////////////////// LIMPAR TODOS OS DADOS DE TODOS OS PROFESSORES DA LISTA

    static void Limpar(List<Professor> ListaProfessor){
        
        Scanner S = new Scanner(System.in);
        
        ConsoleClear();
        System.out.println();
        
        System.out.println("Digite 1 para confirmar a escolha ou qualquer outro para voltar ao menu:");
        int escolha;
        escolha=S.nextInt();
        
        if(escolha==1){
            ListaProfessor.clear();
            ConsoleClear();
            System.out.println();
            System.out.println("Todos os professores foram removidos da lista.\n\n");
        }
        else{
            System.out.println("Retornando ao menu");
        }
    }

//////////////////////////////////////////////////////////////////////////////// LIMPAR O CONSOLE AUTOMATICAMENTE

    static void ConsoleClear() {
        
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.setAutoDelay(2);
 
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
            robot.setAutoDelay(2);

        } catch (AWTException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

////////////////////////////////////////////////////////////////////////////////

