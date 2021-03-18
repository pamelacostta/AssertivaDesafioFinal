import service.UserService;

import java.util.Scanner;

public class Main {
    public static void choose() {
        System.out.println("O que você quer fazer?");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Listar");
        System.out.println("4 - Excluir ");

        UserService service = new UserService();
        Scanner input = new Scanner(System.in);

        switch (input.nextInt()) {
            case 1:
                service.insert();
                break;
            case 2:
                service.update();
                break;
            case 3:
                service.select();
                break;
            case 4:
                service.delete();
                break;
            default:
                System.out.println("Fim");
        }
    }
    public static void main(String[] args) {
        choose();
    }
}