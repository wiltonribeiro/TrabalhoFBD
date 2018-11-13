package imobiliaria;
import imobiliaria.controllers.ControllerImovel;
import imobiliaria.controllers.ControllerUsuario;
import imobiliaria.pojo.Apartamento;
import imobiliaria.pojo.Imovel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Imobiliaria {
    
    
    private static Scanner scanner;
    
    public static void main(String[] args) throws Exception {      
        scanner = new Scanner(System.in);
        
        while (true){
            System.out.println("----------------------------");
            System.out.println("Escolha a categoria:");
            System.out.println("1 - Imoveis:");
            System.out.println("2 - Usuarios");
            System.out.println("3 - Alugueis");       
            System.out.println("4 - Vendas");       
            System.out.println("----------------------------");
            int menu = scanner.nextInt();
            switch (menu){
                case 1:
                    menuEscolhaImovel();
                    break;
                case 2:
                    menuEscolhaUsuario();
                    break;
                case 3:
                    menuEscolhaAlugueis();
                    break;
                case 4:
                    menuEscolhaVendas();
                    break;
            }
        }        
    }
    
    public static void menuEscolhaImovel(){
        
        ControllerImovel controller = new ControllerImovel();
        
        System.out.println("----------------------------");
        System.out.println("O que deseja ?");
        System.out.println("1 - Cadastrar Apartamento:");
        System.out.println("2 - Cadastrar Casa");
        System.out.println("3 - Listar Imoveis");
        System.out.println("4 - Excluir Imóvel");                      
        System.out.println("----------------------------");       
        int menu = scanner.nextInt();
        switch (menu){
            case 1:
                scanner.nextLine();
                System.out.println("IdUsuario proprietario:");
                int idUsuario = Integer.parseInt(scanner.nextLine());
                System.out.println("Endereço:");
                String endereco = scanner.nextLine();
                System.out.println("Complemento:");
                String complemento = scanner.nextLine();
                System.out.println("Andar:");
                int andar = scanner.nextInt();                        
                try {
                    controller.addImovel(new Apartamento(new Imovel(idUsuario, endereco, complemento), andar));
                } catch (Exception e) {
                    System.out.println("error: "+e.getMessage());
                }                       
                break;
            case 2:
                break;
            case 3:
                try{
                    for(Imovel imovel: controller.listarImoveis())
                        System.out.println(imovel.toString());
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                break;
            default:
                System.out.println("comando invalido");
                break;
        }        
    }
    
    public static void menuEscolhaUsuario(){
        ControllerUsuario controller = new ControllerUsuario();
        
        System.out.println("----------------------------");
        System.out.println("O que deseja ?");
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Listar Usuários");
        System.out.println("3 - Listar Usuários Inquilinos");
        System.out.println("4 - Listar Usuários Proprietários");                      
        System.out.println("----------------------------");       
        int menu = scanner.nextInt();
        switch (menu){
            case 1:
                scanner.nextLine();
                System.out.println("Nome:");
                String nome = scanner.nextLine();
                System.out.println("Endereço:");
                String endereco = scanner.nextLine();
                System.out.println("Contato:");
                String contato = scanner.nextLine();
                try{
                    controller.addUsuario(nome, endereco, contato);
                    System.out.println("inserido com sucesso");
                } catch(Exception e){
                    System.out.println("error: "+e.getMessage());
                }                               
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("comando invalido");
                break;
        }        
    }
    
    public static void menuEscolhaAlugueis(){
        System.out.println("----------------------------");
        System.out.println("O que deseja ?");
        System.out.println("1 - Cadastrar Aluguel");
        System.out.println("2 - Atualizar Aluguel");
        System.out.println("3 - Registrar Pagamento");        
        System.out.println("4 - Listar Alugueis");
        System.out.println("5 - Listar Alugueis Atrasados");                      
        System.out.println("----------------------------");       
        int menu = scanner.nextInt();
        switch (menu){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("comando invalido");
                break;
        }
    }
    
    public static void menuEscolhaVendas(){
        System.out.println("----------------------------");
        System.out.println("O que deseja ?");
        System.out.println("1 - Listar Vendas");
        System.out.println("2 - Efetuar Venda");        
        System.out.println("----------------------------");       
        int menu = scanner.nextInt();
        switch (menu){
            case 1:
                break;
            case 2:
                break;           
            default:
                System.out.println("comando invalido");
                break;
        }        
    }
    
}
