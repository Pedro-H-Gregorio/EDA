import interfaces.IController;
import interfaces.IProduct;
import orderlinkedlist.OrderLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IController controller = new Controller();
        controller.connectStorage(new OrderLinkedList<Product>());

        printMenssage("Bem vindo ao Estoque");
        printMenssage("Escolha uma das opções abaixo:");
        String alternative;
        do{
            printLine("1","Adicionar produto");
            printLine("2","Retirar produtos");
            printLine("3","Listar produtos");
            printLine("4","Checar existência de produto");
            printLine("5","Sair");

            printBreakLine();
            printQuest("Qual sua escolha?");
            alternative = scanner.next();

            switch (alternative) {
                case "1":
                    printMenssage("Você está na seção de adicionar produto");
                    printQuest("Qual o produto que deseja adicionar ?");
                    String name = scanner.next();
                    printQuest("Qual a quantidade que deseja adicionar?");
                    Integer quantity = scanner.nextInt();
                    controller.add(name, quantity);
                    printMenssage("Produto adicionado");

                    break;
                case "2":
                    printMenssage("Você está na seção de remover produto");
                    printQuest("Qual o produto que deseja remover ?");
                    String namer = scanner.next();
                    printQuest("Qual a quantidade que deseja remover?");
                    Integer quantityr = scanner.nextInt();
                    int controll = controller.remove(namer, quantityr);
                    if(controll == -1){
                        printMenssage("Produto não existe ou não a quantidade pretendida estar maior do que a armazenada");
                    } else if (controll == 1) {
                        printMenssage("Produto removido do sistema");
                    } else {
                    printMenssage("Foi removido a quantidade " + quantityr + " do produto " + namer);
                    }

                    break;
                case "3":
                    printMenssage("Você está na seção de listagem produto");
                    printLine("Produtor", "Quantidade");
                    for (IProduct product : controller.list()) {
                        printLine(product.getName(), product.getQuantity().toString());
                    }
                    printBreakLine();

                    break;
                case "4":
                    printMenssage("De qual produto deseja informações ?");
                    String namei = scanner.next();
                    IProduct product = controller.checkProduct(namei);
                    if(product == null){
                        printMenssage("Produto não existe");
                    } else {
                        printMenssage("Produto encontrado");
                        printLine("Produtor", "Quantidade");
                        printLine(product.getName(), product.getQuantity().toString());
                    };
                    printBreakLine();
                    break;
                case "5":
                    break;
                default:
                    printMenssage("Por favor, insira o número certo!");
                    break;
            }

        }while(!alternative.equals("5"));

        printMenssage("ADEUS");
    }

    public static void printMenssage(String menssage){
        System.out.println("******************************");
        System.out.println(menssage);
        System.out.println("******************************");
    }
    public static void printLine(String first, String second){
        System.out.println(String.join(" - ",first,second));
    }

    public static void printQuest(String quest){
        System.out.println(quest);
    }

    public static void printBreakLine(){
        System.out.println("******************************");
    }
}