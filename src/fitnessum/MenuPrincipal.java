/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitnessum;

import comparators.*;
import exceptions.*;
import java.util.*;
import users.*;

/**
 *
 * @author mesas
 */
public class MenuPrincipal {
    private static FitnessUM fitness;
    public static void main(String[] args) throws Excepcoes{
    int resultado=1;
   fitness=new FitnessUM();
    fitness.AdicionaUser(new User());
    
    while(resultado!=0){
        resultado=MenuPrincipal.Menu();
    }
}
private static int Menu() throws Excepcoes {
    int op,r;
    Scanner ler=new Scanner(System.in);
    
    System.out.println("BEM VINDO AO FITNESSUM!");
    System.out.println("1 - Login");
    System.out.println("2 - Registar");
    System.out.println("3 - Userlist");
    System.out.println("4 - Sair");
    System.out.print("Opção: ");
    r=0;
    
    op=ler.nextInt();
    switch(op){
        case 1:{
            r=MenuPrincipal.Login();
            break;
        }
        case 2:{
            MenuPrincipal.Registar();
            r=1;
            break;
        }
        case 3:{
            MenuPrincipal.PrintUserList();
            r=1;
            break;
        }
        case 4:{
            r=0;
            break;
        }
        default:{
           System.out.println("Opção inválida! Tente outra");
           r=1;
           break;
        }
    }
    return r;
    }
private static int MenuUtilizador(User u) throws Excepcoes{
    int op,r;
    
    Scanner ler=new Scanner(System.in);
    System.out.println("-----MENU UTILIZADOR----");
    System.out.println("1 - Ver Perfil");
System.out.println("2 - Mudar informações");
System.out.println("3 - Sair");
System.out.print("Opção: ");
r=op=2;
op=ler.nextInt();
switch(op){
    case 1:{
        System.out.print(u.toString());
        r=1;
        break;
    }
    case 2:{
        
        while(r!=0){
            r=MenuPrincipal.MenuInf(u);
        }
        r=1;
        break;
        
    }
    case 3:{
        
        r=0;
        break;
    }
}
return r;
}
    private static int Login() throws Excepcoes{
        String user,pass;
        Scanner ler=new Scanner(System.in);
        User u;
        int resultado=1;
   System.out.println("PÁGINA DE LOGIN");
   System.out.print("Username: ");
   user=ler.nextLine();
   System.out.print("Password: ");
   pass=ler.nextLine();
   try{
       if(fitness.LoginValido(user,pass)==true){
           u=fitness.getUser(user);
   while(resultado!=0){
       
       resultado=MenuPrincipal.MenuUtilizador(u);
   }
       }
           
       
   
   }catch(Excepcoes e){
       if(e instanceof UserNaoExiste){
       System.out.println(((UserNaoExiste)e).getMessage());    
       }else{
       System.out.println(((LoginInvalido)e).getMessage());    
       }
       
   }
   
   
   
    return 1;
    }

    private static void Registar() throws Excepcoes {
        String email,nome,pass1,pass2,genero,favsport,date,height,weight;
        
        int dia,mes,ano;
        double peso,altura;
        GregorianCalendar data=new GregorianCalendar();
        Scanner ler=new Scanner(System.in);
        User u;
        System.out.println("PÁGINA DE REGISTO");
        
        System.out.print("Email: ");
        email=ler.nextLine();
        
        System.out.print("Password: ");
        pass1=ler.nextLine();
        System.out.print("Confirmar Password: ");
        pass2=ler.nextLine();
        
        System.out.print("Nome: ");
        nome=ler.nextLine();
        
        System.out.print("Genero: ");
        genero=ler.nextLine();
        
        System.out.print("Data de Nascimento(dd-mm-aa): ");
        date=ler.nextLine();
        
        System.out.print("Altura: ");
        altura=ler.nextDouble();
        
        
        System.out.print("Peso: ");
        peso=ler.nextDouble();
        
        
        System.out.print("Desporto Favorito: ");
        ler.nextLine();
        favsport=ler.nextLine();
        try{
        if(email.equals("")==true ){
            throw new UserInvalido(email);
        }else{
            if(pass1.equals(pass2)==false){
                throw new PassInvalida();
            }else{
                if(date.equals("")){
                    throw new DataInvalida();
                }else{
                    if(altura<=0.0){
                        throw new AlturaInvalida();
                    }else{
                        if(peso<=0.0){
                            throw new PesoInvalido();
                        }
                    }
                }
            }
        }
        String[]aux=date.split("-");
        dia=Integer.parseInt(aux[0]);
        mes=Integer.parseInt(aux[1]);
        ano=Integer.parseInt(aux[2]);
        data.set(Calendar.DATE, dia);
        data.set(Calendar.MONTH, mes);
        data.set(Calendar.YEAR, ano);
        u=new User(email, nome, pass1, genero, altura, peso, favsport, data);
        fitness.AdicionaUser(u);
        }
        catch(UserInvalido | PassInvalida | DataInvalida | AlturaInvalida | PesoInvalido user){
           
                System.out.println(user.getMessage());
            }
        
        
        
       
              
       
           
       
    }
    
    private static void PrintUserList() {
    System.out.println(fitness.toString());
    }

    private static int MenuInf(User u) {
   int op,r;
   double peso,altura;
   String pass2,pass1,sport;
    Scanner ler=new Scanner(System.in);
    
    System.out.println("-----Informaçoes Pessoais----");
    System.out.println("1 - Mudar Peso");
System.out.println("2 - Mudar Altura");
System.out.println("3 - Mudar Desporto Favorito");
System.out.println("4 - Mudar Password");
System.out.println("5 - Voltar ao menu de utilizador");
System.out.print("Opção: ");
op=r=1;

op=ler.nextInt();

switch(op){
    case 1:{
        System.out.print("Peso: ");
        peso=ler.nextDouble();
        
        u.setPeso(peso);
        r=1;
        break;
    }
    case 2:{
        System.out.print("Altura: ");
        
        altura=ler.nextDouble();
        
        u.setAltura(altura);
        r=1;
        break;
        
    }
    case 3:{
        
        System.out.print("Desporto Favorito: ");
        ler.nextLine();
        sport=ler.nextLine();
        u.setDesporto_favorito(sport);
        r=1;
        break;
    }
    case 4:{
        ler.nextLine();
        System.out.print("Nova Password: ");
        pass1=ler.nextLine();
        System.out.print("Confirmar Password: ");
        pass2=ler.nextLine();
        try{
            if(pass1.equals(pass2)==false){
                throw new PassInvalida();
            }
        }catch(PassInvalida p){
            System.out.println(p.getMessage());
        }
        u.setPassword(pass1);
    }
    case 5:{
        
        r=0;
        break;
    }

}

return r;
    }
}

    
    
    
        
    

