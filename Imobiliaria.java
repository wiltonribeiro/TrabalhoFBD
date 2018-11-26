package imobiliaria;
import imobiliaria.controllers.ControllerAluguel;
import imobiliaria.controllers.ControllerCompra;
import imobiliaria.controllers.ControllerImovel;
import imobiliaria.controllers.ControllerUsuario;
import imobiliaria.pojo.Aluguel;
import imobiliaria.pojo.Apartamento;
import imobiliaria.pojo.Compra;
import imobiliaria.pojo.Imovel;
import imobiliaria.pojo.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                scanner.nextLine();
                System.out.println("IdUsuario proprietario:");
                int idUsuario = Integer.parseInt(scanner.nextLine());
                System.out.println("Endereço:");
                String endereco = scanner.nextLine();
                System.out.println("Complemento:");
                String complemento = scanner.nextLine();
                try {
                    controller.addImovel(new Casa(new Imovel(idUsuario, endereco, complemento)));
                } catch (Exception e) {
                    System.out.println("error: "+e.getMessage());
                }
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
        System.out.println("5 - Listar Usuários Inquilinos Atrasados");                      
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
                try {
                    for(Usuario usuario: controller.listarUsuarios()){
                       System.out.println(usuario.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
        
        ControllerAluguel controller = new ControllerAluguel();
        int id_usuario, id_imovel;
        double valor;
        
        System.out.println("----------------------------");
        System.out.println("O que deseja ?");
        System.out.println("1 - Cadastrar Aluguel");        
        System.out.println("2 - Registrar Pagamento");        
        System.out.println("3 - Listar Alugueis");
        System.out.println("4 - Listar Alugueis Atrasados");                      
        System.out.println("5 - Listar Inquilinos de Alugueis Atrasados");                      
        System.out.println("6 - Listar Alugueis em Dia");                      
        System.out.println("----------------------------");       
        int menu = scanner.nextInt();
        switch (menu){
            case 1:
                scanner.nextLine();
                System.out.println("IdInquilino:");
                id_usuario = Integer.parseInt(scanner.nextLine());
                System.out.println("IdImovel:");
                id_imovel = Integer.parseInt(scanner.nextLine());
                System.out.println("Valor:");
                valor = Double.parseDouble(scanner.nextLine());
                System.out.println("Tempo contrato(meses):");
                int tempo = Integer.parseInt(scanner.nextLine());                
                System.out.println("Data limite(dia limite para cada mês):");
                int data_limite = Integer.parseInt(scanner.nextLine());
                System.out.println("Juros Atraso(%):");
                double juros = Double.parseDouble(scanner.nextLine());
                              
                try {                              
                    controller.addAluguel(id_usuario, id_imovel, tempo, valor, juros, data_limite);
                    System.out.println("inserido com sucesso");                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                        
                break;
            case 2:
                scanner.nextLine();                
                System.out.println("IdAluguel:");
                int id_aluguel = Integer.parseInt(scanner.nextLine());
                System.out.println("Valor:");
                valor = Double.parseDouble(scanner.nextLine());
                System.out.println("Data de pagamento(dia/mes/ano):");
                String data_pagamento = scanner.nextLine();                     
                
                try {
                    controller.addPagamento(id_aluguel, data_pagamento, valor);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                        
                break;
            case 3:                       
                try {
                    for(Aluguel aluguel: controller.listarAluguel()){
                       System.out.println(aluguel.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                        
                break;
            case 4:
                try {
                    for(Aluguel aluguel: controller.listarAlugueisAtrados()){
                       System.out.println(aluguel.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                        
                break;
            case 5:
                try {
                    for(Usuario usuario: controller.listarInquilinosDeAlugueisAtrados()){
                       System.out.println(usuario.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                        
                break;
            case 6:
                try {
                    for(Aluguel aluguel: controller.listarAlugueisEmDia()){
                       System.out.println(aluguel.toString());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                        
                break;
            default:
                System.out.println("comando invalido");
                break;
        }
    }
    
    public static void menuEscolhaVendas(){
        
        ControllerCompra controllerCompra = new ControllerCompra();
        
        System.out.println("----------------------------");
        System.out.println("O que deseja ?");
        System.out.println("1 - Listar Vendas");
        System.out.println("2 - Efetuar Venda");        
        System.out.println("----------------------------");       
        int menu = scanner.nextInt();
        switch (menu){
            case 1:        
                try {
                    for(Compra compra : controllerCompra.listarCompra())
                        System.out.println(compra.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }        
                break;
            case 2:
                scanner.nextLine();
                System.out.println("IdComprador:");
                int id_usuario = Integer.parseInt(scanner.nextLine());
                System.out.println("IdImovel:");
                int id_imovel = Integer.parseInt(scanner.nextLine());
                System.out.println("Valor:");
                double valor = Double.parseDouble(scanner.nextLine());
                        
                try {
                    controllerCompra.addVenda(id_usuario, id_imovel, valor);
                    System.out.println("inserido com sucesso");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }            
                break;           
            default:
                System.out.println("comando invalido");
                break;
        }        
    }    
}
