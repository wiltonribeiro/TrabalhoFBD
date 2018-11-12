package imobiliaria;

import imobiliaria.controllers.ControllerImovel;
import imobiliaria.pojo.Imovel;

public class Imobiliaria {
    
    public static void main(String[] args) throws Exception {
        
        ControllerImovel controllerImovel = new ControllerImovel();
        
        System.out.println("Listando imoveis");
        for(Imovel imovel: controllerImovel.listarImoveis()){
            System.out.println(imovel.toString());
        }   
    }
    
}
