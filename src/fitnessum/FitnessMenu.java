/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package fitnessum;

import java.io.IOException;
import java.util.*;
import exceptions.*;
import users.*;
import activities.*;
import events.*;
/**
 *
 * @author mesas
 */
public class FitnessMenu {

    private static FitnessUM fitness;

    public static void main(String[] args) throws Excepcoes {
        int resultado = 1;
       
//        distancia = new String[]{"Cycling, Sport", "Cycling, Transport", "Fitness Walking", "Golf", "Indoor Cycling", "Kayaking", "Kitesurfing", "Riding", "Roller Skiing", "Rowing", "Running", "Sailing", "Skating", "Swimming", "Walking", "Wind Surfing"};
//        desportos = new String[]{"Badminton", "Baseball", "Basketball", "Boxing", "Cricket", "Football, american", "Football, rugby", "Football, soccer", "Handball", "Hockey", "Polo", "Squash", "Table Tennis", "Tennis", "Volleyball, beach", "Volleyball, indoor"};
//        alt = new String[]{"Hiking", "Mountain Biking", "Orienteering", "Skiing, cross country", "Skiing, downhill", "Snowboarding", "Climbing stairs", "Scuba diving"};
//        outros = new String[]{"Aerobics", "Eliptical training", "Dancing", "Fencing", "Gymnastics", "Martial Arts", "Pilates"};
        fitness = new FitnessUM();
//        fitness.CarregarDesportos(distancia, desportos, alt, outros);
        
while (resultado != 0) {
            resultado = FitnessMenu.Menu();
        }
    }

    private static int Menu() throws Excepcoes {
        int op, r;
        Scanner ler = new Scanner(System.in);
        System.out.println("  _____ _ _                       _   _ __  __ \n"
                + " |  ___(_) |_ _ __   ___  ___ ___| | | |  \\/  |\n"
                + " | |_  | | __| '_ \\ / _ \\/ __/ __| | | | |\\/| |\n"
                + " |  _| | | |_| | | |  __/\\__ \\__ \\ |_| | |  | |\n"
                + " |_|   |_|\\__|_| |_|\\___||___/___/\\___/|_|  |_|\n"
                + "                                               \n"
                + "");

        System.out.println("BEM VINDO AO FITNESSUM!");
        System.out.println("1 - Login");
        System.out.println("2 - Registar");
        System.out.println("3 - Userlist");
        System.out.println("4 - Listar Desportos disponíveis");
        System.out.println("5 - Listar Eventos");
        System.out.println("6 - Gravar objecto");
        System.out.println("7 - Gravar txt");
        System.out.println("8 - Carregar Objecto");
        System.out.println("9 - Sair");
        System.out.print("Opção: ");
        r = 1;
 try {
        op = ler.nextInt();
       
            switch (op) {
                case 1: {
                    r = FitnessMenu.Login();
                    break;
                }
                case 2: {
                    FitnessMenu.Registar();
                    r = 1;
                    break;
                }
                case 3: {
                    FitnessMenu.PrintUserList();
                    r = 1;
                    break;
                }
                case 4: {
                    FitnessMenu.ListarDesportos();
                    r = 1;
                    break;
                }
                case 5:{
                    ListarEventos();
                    r=1;
                    break;
                }
                case 6: {
                    try {
                        FitnessMenu.GravarObjecto();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 7: {
                    try {
                        FitnessMenu.GravarTxt();

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 8: {
                    try {
                        FitnessMenu.CarregarObjecto();

                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 9: {
                    r = 0;
                    break;
                }
                default: {
                    throw new OpcaoInvalida();

                }
            }
        } catch (OpcaoInvalida | InputMismatchException | NaoTemEventos e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    private static int MenuUtilizador(String user) throws Excepcoes {
        int op, r;

        Scanner ler = new Scanner(System.in);
        int dia, mes, ano, hora, minuto;
        String date, horas;
        String[] datas, time;
        System.out.println("-----MENU UTILIZADOR-----");
        System.out.println("1 - Ver Perfil");
        System.out.println("2 - Mudar informações");
        System.out.println("3 - Amigos");
        System.out.println("4 - Actividades");
        System.out.println("5 - Eventos");
        System.out.println("6 - Recordes");
        System.out.println("7 - Logout");
        System.out.print("Opção: ");
        r = op = 2;
        User aux;
        aux = fitness.getUser(user).clone();
        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {
                    System.out.print(aux.toString());
                    r = 1;
                    break;
                }
                case 2: {

                    while (r != 0) {
                        r = FitnessMenu.MenuInf(aux);
                    }

                    r = 1;
                    break;

                }

                case 3: {
                    while (r != 0) {
                        r = FitnessMenu.MenuAmigos(aux);
                    }

                    r = 1;
                    break;
                }

                case 4: {
                    while (r != 0) {
                        r = FitnessMenu.MenuActividades(aux);
                    }
                    r = 1;
                    break;
                }
                case 5: {
                    while (r != 0) {
                        r = FitnessMenu.MenuEventos(aux);
                    }
                    r = 1;
                    break;
                }
                case 6: {
                    while (r != 0) {
                        r = FitnessMenu.MenuRecordes(aux);
                    }
                    r = 1;
                    break;
                }
                case 7: {
                    r = 0;
                    fitness.AdicionaUser(aux);
                    break;
                }
                default: {
                    throw new OpcaoInvalida();
                }
            }

        } catch (OpcaoInvalida e) {
            System.out.println(e.getMessage());

        }
        return r;
    }

    private static int Login() throws Excepcoes {
        String user, pass;
        Scanner ler = new Scanner(System.in);
        User u;
        int resultado = 1;
        System.out.println("PAGINA DE LOGIN");
        System.out.print("Username: ");
        user = ler.nextLine();
        System.out.print("Password: ");
        pass = ler.nextLine();
        try {
            if (fitness.LoginAdmin(user,pass)==true) {
                while (resultado != 0) {
                    resultado = FitnessMenu.MenuAdmin();
                }
            } else {
                if (fitness.LoginValido(user, pass) == true) {

                    while (resultado != 0) {

                        resultado = FitnessMenu.MenuUtilizador(user);
                    }
                }
            }

        } catch (UserNaoExiste | LoginInvalido e) {
            System.out.println(e.getMessage());

        }

        return 1;
    }

    private static void Registar() throws Excepcoes {
        String email, nome, pass1, pass2, genero, favsport, date, height, weight;

        int dia, mes, ano;
        double peso, altura;
        GregorianCalendar data = new GregorianCalendar();
        Scanner ler = new Scanner(System.in);
        User u;
        System.out.println("PÁGINA DE REGISTO");

        System.out.print("Email: ");
        email = ler.nextLine();

        System.out.print("Password: ");
        pass1 = ler.nextLine();
        System.out.print("Confirmar Password: ");
        pass2 = ler.nextLine();

        System.out.print("Nome: ");
        nome = ler.nextLine();

        System.out.print("Genero: ");
        genero = ler.nextLine();

        System.out.print("Data de Nascimento(dd-mm-aa): ");
        date = ler.nextLine();

        System.out.print("Altura(cm): ");
        altura = ler.nextDouble();

        System.out.print("Peso: ");
        peso = ler.nextDouble();

        System.out.print("Desporto Favorito: ");
        ler.nextLine();
        favsport = ler.nextLine();
        try {
            if (email.equals("") == true || email.contains("@") == false || fitness.ExisteUser(email) == true) {
                throw new UserInvalido(email);
            } else {
                if (pass1.equals(pass2) == false) {
                    throw new PassInvalida();
                } else {
                    if (nome.equals("") == true) {
                        throw new NomeInvalido();
                    } else {
                        if (date.equals("")) {
                            throw new DataInvalida();
                        } else {
                            if (altura <= 0.0) {
                                throw new AlturaInvalida();
                            } else {
                                if (peso <= 0.0) {
                                    throw new PesoInvalido();
                                }
                            }
                        }
                    }
                }
            }

            String[] aux = date.split("-");
            dia = Integer.parseInt(aux[0]);
            mes = Integer.parseInt(aux[1]);
            ano = Integer.parseInt(aux[2]);
            data = new GregorianCalendar(ano, mes, dia);
            u = new User(email, nome, pass1, genero, altura, peso, favsport, data);
            fitness.AdicionaUser(u);
        } catch (UserInvalido | PassInvalida | DataInvalida | AlturaInvalida | PesoInvalido user) {

            System.out.println(user.getMessage());
        }

    }

    private static void PrintUserList() {
        System.out.print(fitness.toString());
    }

    private static int MenuInf(User u) {
        int op, r;
        double peso, altura;
        String pass2, pass1, sport;
        Scanner ler = new Scanner(System.in);

        System.out.println("-----Informaçoes Pessoais----");
        System.out.println("1 - Mudar Peso");
        System.out.println("2 - Mudar Altura");
        System.out.println("3 - Mudar Desporto Favorito");
        System.out.println("4 - Mudar Password");
        System.out.println("5 - Voltar ao menu de utilizador");
        System.out.print("Opção: ");
        op = r = 1;

        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {
                    System.out.print("Peso: ");
                    peso = ler.nextDouble();

                    u.setPeso(peso);
                    r = 1;
                    break;
                }
                case 2: {
                    System.out.print("Altura: ");

                    altura = ler.nextDouble();

                    u.setAltura(altura);
                    r = 1;
                    break;

                }
                case 3: {

                    System.out.print("Desporto Favorito: ");
                    ler.nextLine();
                    sport = ler.nextLine();
                    u.setDesporto_favorito(sport);
                    r = 1;

                    break;
                }
                case 4: {
                    ler.nextLine();
                    System.out.print("Nova Password: ");
                    pass1 = ler.nextLine();
                    System.out.print("Confirmar Password: ");
                    pass2 = ler.nextLine();
                    try {
                        if (pass1.equals(pass2) == false) {
                            throw new PassInvalida();
                        }
                    } catch (PassInvalida p) {
                        System.out.println(p.getMessage());
                    }
                    u.setPassword(pass1);
                }
                case 5: {
                    fitness.AdicionaUser(u);
                    r = 0;
                    break;
                }
                default: {
                    throw new OpcaoInvalida();
                }

            }
        } catch (OpcaoInvalida e) {
            System.out.println(e.getMessage());
        }

        return r;
    }

    private static int MenuAdmin() throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int op, r;
        String user, event;
        op = r = 1;
        System.out.println("-------MENU ADMIN-------");
        System.out.println("1 - Remover Utilizador");
        System.out.println("2 - Remover Evento");
        System.out.println("3 - Adicionar Desporto");
        System.out.println("4 - Criar Evento");
        System.out.println("5 - Logout");
        System.out.print("Opção: ");
        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {

                    System.out.print(fitness.toString());
                    System.out.print("Utilizador a remover: ");
                    ler.nextLine();
                    user = ler.nextLine();
                    if (fitness.ExisteUser(user) == true) {
                        fitness.RemoverUtilizador(user);
                    
                    }
                    r = 1;
                    break;
                }
                case 2: {

                    System.out.print(fitness.ListarEventos());
                    ler.nextLine();
                    event = ler.nextLine();
                    fitness.RemoverEvento(event);
                    r = 1;
                    break;
                }
                case 3: {
                    AdicionarDesporto();
                    r = 1;
                    break;
                }
                case 4:{
                    CriarEvento();
                    r=1;
                    break;
                }
                case 5: {
                    r = 0;
                    break;
                }
                default: {
                    throw new OpcaoInvalida();
                }
            }
        } catch (OpcaoInvalida | EventoNaoExiste | UserNaoExiste e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    private static int AdicionarAmigo(User u) throws Excepcoes {
        String user;
        Scanner ler = new Scanner(System.in);
        FitnessMenu.PrintUserList();
        System.out.print("User: ");
        user = ler.nextLine();
        User aux;
        try {
            if (fitness.ExisteUser(user) == true) {
                aux = fitness.getUser(user);
                u.FazerPedido(user);
                aux.ReceberPedido(u.getEmail());
                fitness.AdicionaUser(u);
                fitness.AdicionaUser(aux);
            }

        } catch (UserNaoExiste e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private static int RemoverAmigo(User u) throws Excepcoes {
        String user;
        Scanner ler = new Scanner(System.in);

        User aux;
        try {
            System.out.println(u.MostrarFriendsList());
            System.out.print("User: ");
            user = ler.nextLine();
            if (fitness.ExisteUser(user) == true) {
                aux = fitness.getUser(user);
                u.RemoverAmigo(user);
                aux.RemoverAmigo(u.getEmail());
                fitness.AdicionaUser(aux);
                fitness.AdicionaUser(u);
            }

        } catch (UserNaoExiste e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private static int FriendsList(User u) throws Excepcoes {
        String user;
        Scanner ler = new Scanner(System.in);
        int r = 1;
        try {
            System.out.print(u.MostrarFriendsList());

            System.out.print("User: ");

            user = ler.nextLine();
            if (fitness.ExisteUser(user) == true) {

                while (r != 0) {
                    r = FitnessMenu.MenuAmigo(user);
                }
            }

        } catch (NaoTemAmigos | UserNaoExiste e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private static void RegistarActividade(User u)throws Excepcoes  {
        String nome, date, tipo, duracao, horas,type;
        int dia, mes, ano, hora, minuto;
        Double cal, hidration, duration;
        Scanner ler = new Scanner(System.in);
        GregorianCalendar data;
        String[] datas, time;
        

        
        try {
        System.out.print(fitness.ListarDesportos());
        System.out.println("-----REGISTAR ACTIVIDADE-----");
        System.out.print("Descrição da Actividade: ");
        nome = ler.nextLine();
        System.out.print("Tipo da Actividade: ");
        type=ler.nextLine();
        System.out.print("Duração(h:m): ");

        duracao = ler.nextLine();
        System.out.print("Hidratação: ");

        hidration = ler.nextDouble();
        System.out.print("Data de realização(dd-mm-aa): ");
        ler.nextLine();
        date = ler.nextLine();
        System.out.print("Hora de Início da Actividade(hh:mm): ");
        horas = ler.nextLine();
        datas = date.split("-");
        time = horas.split(":");
        hora = Integer.parseInt(time[0]);
        minuto = Integer.parseInt(time[1]);
        dia = Integer.parseInt(datas[0]);
        mes = Integer.parseInt(datas[1]);
        ano = Integer.parseInt(datas[2]);
        data = new GregorianCalendar(ano, mes, dia, hora, minuto);
        
       
        tipo=fitness.getTipo(type);
      System.out.println(tipo);
            switch (tipo) {
                case "Competicao": {
                    FitnessMenu.ActividadeCompeticao(u, data,nome, type, duracao,hidration);
                    break;
                }
                case "Distancia": {
                    FitnessMenu.ActividadeDistancia(u, data,nome, type,duracao,hidration);
                    break;
                }
                case "Altitude": {
                    FitnessMenu.ActividadeAltitude(u, data,nome, type, duracao,hidration);
                    break;
                }
                case "Outros": {
                    FitnessMenu.ActividadeOutros(u, data, nome,type, duracao, hidration);
                    break;
                }
                default: {
                    throw new TipoNaoExiste(tipo);
                }
            }
            fitness.AdicionaUser(u);
        } catch (TipoNaoExiste | NaoTemDesportos e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ListarDesportos() throws Excepcoes {
try{
        
        System.out.print(fitness.ListarDesportos());
    }catch(NaoTemDesportos e){
    System.out.println(e.getMessage());
    }

}

    private static void ActividadeDistancia(User u, GregorianCalendar date, String nome,String tipo, String duration, Double hidration) {
        double avgspd, maxspd, distancia, cal, bmr, val;
       
        int hora, minuto;
        double convertido;
        String[] time;
        time = duration.split(":");
        hora = Integer.parseInt(time[0]);
        minuto = Integer.parseInt(time[1]);
        convertido = ((double) minuto) / 60;
        convertido += (double) hora;
        Scanner ler = new Scanner(System.in);
        GeneralActivity g;
      
        System.out.print("Distancia(em KM): ");
        distancia = ler.nextDouble();
        avgspd = distancia / convertido;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * convertido;
        
       bmr=u.getTaxa();
       val=fitness.getVarCal(tipo);
        cal = bmr * val;
        g = new Distancia(date,nome, tipo, cal, hidration, distancia, maxspd, avgspd, hora, minuto);
        u.AdicionarActividade(g);
       
    }

    private static void ActividadeAltitude(User u, GregorianCalendar date, String nome,String tipo, String duration, Double hidration) {
        double avgspd, maxspd, distancia, cal,  bmr, altmax, altmin, maxdesc, mindesc, convertido,val;
        int idade, hora, minuto;
        String time[] = duration.split(":");
        hora = Integer.parseInt(time[0]);
        minuto = Integer.parseInt(time[1]);
        Scanner ler = new Scanner(System.in);
        GeneralActivity g;
        String genero, tempo;
        System.out.print("Distância(em KM): ");
        distancia = ler.nextDouble();

        System.out.print("Tempo: ");
        ler.nextLine();
        tempo = ler.nextLine();
        System.out.print("Altitude máxima(em metros): ");

        altmax = ler.nextDouble();
        System.out.print("Altitude mínima(em metros): ");
        altmin = ler.nextDouble();
        System.out.print("Descida máxima(em metros): ");
        maxdesc = ler.nextDouble();
        System.out.print("Descida mínima(em metros): ");
        mindesc = ler.nextDouble();
        convertido = minuto / 60;
        convertido += (double) hora;
        avgspd = distancia / convertido;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * convertido;
       
       bmr=u.getTaxa();
        val=fitness.getVarCal(tipo);
        cal = bmr * val;
        g = new Altitude(date, nome,tipo, cal, hidration, altmax, altmin, maxdesc, mindesc, distancia, maxspd, avgspd, tempo, hora, minuto);
        u.AdicionarActividade(g);
       
    }

    private static void ActividadeCompeticao(User u, GregorianCalendar date, String nome,String tipo, String duration, Double hidration) {
        double avgspd, maxspd, distancia, cal, bmr, convertido,val;
        int idade, hora, minuto;
        String time[] = duration.split(":");
        hora = Integer.parseInt(time[0]);
        minuto = Integer.parseInt(time[1]);
        
        Scanner ler = new Scanner(System.in);
        GeneralActivity g;
        String  resultado;
        System.out.print("Distância(em KM): ");
        distancia = ler.nextDouble();
        ler.nextLine();
        System.out.print("Resultado(Victória/Derrota/Empate): ");
        resultado = ler.nextLine();
        convertido = (double) minuto / 60;
        convertido += (double) hora;
        avgspd = distancia / convertido;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * convertido;
        
        bmr=u.getTaxa();
        val=fitness.getVarCal(tipo);
        cal = bmr * val;
        g = new Competicao(date, nome,tipo, cal, hidration, distancia, resultado, avgspd, maxspd, hora, minuto);
        u.AdicionarActividade(g);
        
      
    }

    private static void ActividadeOutros(User u, GregorianCalendar date, String nome,String tipo, String duration, Double hidration) {
        double cal,bmr, val;
        
        int hora, minuto;
        GeneralActivity g;
        String time[] = duration.split(":");
        hora = Integer.parseInt(time[0]);
        minuto = Integer.parseInt(time[1]);
        
        bmr=u.getTaxa();
        
        val=fitness.getVarCal(tipo);
        
        cal = bmr * val;
      
        g = new Outros(date,nome, tipo, cal, hidration, hora, minuto);
        u.AdicionarActividade(g);
    }

    private static int MenuAmigo(String user) throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int op, r;
        r = 1;
        User aux = fitness.getUser(user);
        System.out.println("-----Perfil de " + aux.getNome() + "-----");
        System.out.println("1 - Ver perfil");
        System.out.println("2 - Ver actividades");
        System.out.println("3 - Consultar Actividades");
        System.out.println("4 - Voltar atrás");
        System.out.print("Opção: ");
        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {
                    System.out.print(aux.toString());
                    r = 1;
                    break;
                }
                case 2: {

                    System.out.print(aux.ListarActividades());

                    r = 1;
                    break;
                }
                case 3: {

                    System.out.print(aux.ListarActividades());
                    FitnessMenu.ConsultarActividade(aux);

                    r = 1;
                    break;
                }

                case 4: {
                    r = 0;
                    break;
                }
                default: {
                    r = 1;
                    throw new OpcaoInvalida();

                }

            }
            return r;
        } catch (OpcaoInvalida | NaoTemActividades | ActividadeNaoExiste e) {
            System.out.println(e.getMessage());
            return r;
        }

    }

    private static Double ConverterParaHoras(String duracao) {
        String[] aux = duracao.split(":");
        double horas, minutos;
        horas = Double.parseDouble(aux[0]);
        minutos = (Double.parseDouble(aux[1])) / 60;
        horas += minutos;
        return horas;
    }

    private static void ConsultarActividade(User aux) throws Excepcoes {
        int dia, mes, ano, hora, minuto;
        String date, horas, detalhes;
        String[] datas, time;
        GregorianCalendar data;
        GeneralActivity g = null;
        Scanner ler = new Scanner(System.in);
        try {
     System.out.print(aux.ListarActividades());
            System.out.print("Data de realização(dd-mm-aa): ");
            date = ler.nextLine();
            System.out.print("Hora de Início da Actividade(hh:mm): ");
            horas = ler.nextLine();
            datas = date.split("-");
            time = horas.split(":");
            hora = Integer.parseInt(time[0]);
            minuto = Integer.parseInt(time[1]);

            dia = Integer.parseInt(datas[0]);
            mes = Integer.parseInt(datas[1]);
            ano = Integer.parseInt(datas[2]);
            data = new GregorianCalendar(ano, mes, dia, hora, minuto);

            System.out.print(aux.ConsultarActividade(data));

        } catch (ActividadeNaoExiste | NaoTemActividades e) {
            System.out.println(e.getMessage());
        }
    }

    private static int MenuActividades(User aux) throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int op, r;
        r = 1;
        System.out.println("----ACTIVIDADES----");
        System.out.println("1 - Registar Actividades");
        System.out.println("2 - Listar Actividade");
        System.out.println("3 - Consultar Actividade");
        System.out.println("4 - Remover Actividade");
        System.out.println("5 - Voltar ao menu de utilizador");
        System.out.print("Opção: ");
        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {
                    FitnessMenu.RegistarActividade(aux);

                    r = 1;
                    break;
                }
                case 2: {

                    System.out.print(aux.ListarActividades());

                    r = 1;
                    break;
                }
                case 3: {

                    System.out.print(aux.ListarActividades());
                    FitnessMenu.ConsultarActividade(aux);

                    r = 1;
                    break;
                }
                case 4:{
                    FitnessMenu.RemoverActividade(aux);
                    r=1;
                    break;
                }
                case 5: {
                    r = 0;
                    break;
                }
                default: {
                    throw new OpcaoInvalida();
                }
            }
        } catch (OpcaoInvalida | NaoTemActividades e) {
            System.out.println(e.getMessage());
        }
        return r;

    }

    private static int MenuAmigos(User aux) throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int op, r, n;
        ArrayList<String> feitos, recebidos;
        feitos = recebidos = new ArrayList<String>();
        op = r = 1;
        System.out.println("----AMIGOS----");
        System.out.println("1 - Adicionar Amigos");
        System.out.println("2 - Ver Amigos");
        System.out.println("3 - Remover Amigos");
        System.out.println("4 - Ver Pedidos");
        System.out.println("5 - Voltar atrás");
        System.out.print("Opção: ");
        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {
                    while (r != 0) {
                        r = FitnessMenu.AdicionarAmigo(aux);
                    }
                    r = 1;
                    break;
                }
                case 2: {
                    while (r != 0) {
                        r = FitnessMenu.FriendsList(aux);
                    }
                    r = 1;
                    break;
                }
                case 3: {
                    while (r != 0) {
                        r = FitnessMenu.RemoverAmigo(aux);
                    }
                    r = 1;
                    break;
                }
                case 4: {
                    while (r != 0) {
                        r = FitnessMenu.MenuPedidos(aux);
                    }

                    r = 1;
                    break;
                }
                case 5: {
                    r = 0;
                    break;
                }
                default: {
                    throw new OpcaoInvalida();
                }
            }
        } catch (NaoTemAmigos | UserNaoExiste e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

//    private static int MenuRecordes(User aux) throws Excepcoes {
//        Scanner ler = new Scanner(System.in);
//        String nome;
//        int op = 1, r = 1;
//        System.out.println("------RECORDES------");
//        System.out.println("1 - Listar Recordes");
//        System.out.println("2 - Consultar Recordes");
//        System.out.println("3 - Voltar atrás");
//        System.out.print("Opção: ");
//        op = ler.nextInt();
//
//        try {
//            switch (op) {
//                case 1: {
//                    System.out.print(aux.ListarRecordes());
//                    r = 1;
//                    break;
//                }
//                case 2: {
//                    System.out.print(aux.ListarRecordes());
//                    System.out.print("Tipo do Recorde: ");
//                    ler.nextLine();
//                    nome = ler.nextLine();
//                    if (aux.ExisteRecorde(nome) == false) {
//                        throw new RecordeNaoExistente(nome);
//                    } else {
//                        System.out.print(aux.ConsultarRecorde(nome));
//                    }
//                    r = 1;
//                    break;
//                }
//                case 3: {
//                    r = 0;
//                    break;
//                }
//                default: {
//                    throw new OpcaoInvalida();
//                }
//            }
//        } catch (NaoTemActividades | RecordeNaoExistente | OpcaoInvalida e) {
//            System.out.println(e.getMessage());
//        }
//        return r;
//    }
    private static void GravarObjecto() throws IOException {
        String file;
        Scanner ler = new Scanner(System.in);
        System.out.print("Nome do ficheiro onde quer gravar o estado: ");
        file = ler.nextLine();
        fitness.gravaObj(file);
    }

    private static void GravarTxt() throws IOException {
        String file;
        Scanner ler = new Scanner(System.in);
        System.out.print("Nome do ficheiro onde quer gravar o txt: ");
        file = ler.nextLine();
        fitness.gravaTxt(file);
    }

    private static void CarregarObjecto() throws IOException, ClassNotFoundException {
        String file;
        Scanner ler = new Scanner(System.in);
        System.out.print("Nome do ficheiro de onde quer ler o estado guardado: ");
        file = ler.nextLine();
        fitness.CarregaObj(file);
    }

    private static int MenuEventos(User aux) throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int op, r;
        r = 1;
        System.out.println("----EVENTOS----");
       
        System.out.println("1 - Listar Eventos disponíveis");
        System.out.println("2 - Inscrever num Evento");
        System.out.println("3 - Voltar ao menu de utilizador");
        System.out.print("Opção: ");
        op = ler.nextInt();
        try {
            switch (op) {
                
                case 1: {
                    FitnessMenu.ListarEventos();
                    r = 1;
                    break;
                }
                case 2: {
                    InscreverEvento(aux);
                    r = 1;
                    break;
                }
                case 3: {
                    fitness.AdicionaUser(aux);
                    r = 0;
                    break;
                }
                default: {
                    throw new OpcaoInvalida();
                }
            }
        } catch (NaoTemEventos | EventoNaoExiste | OpcaoInvalida e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    private static void CriarEvento() throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int dia, mes, ano,max;
        String[] fim,fazer;
        String nome, localrealizacao,localinscricao, date1,date2, tipo;
        GregorianCalendar datafim,datarealizacao;
        Evento e;
        try {
            System.out.print("Nome do Evento: ");
            nome = ler.nextLine();
            System.out.print("Local de realização do evento: ");
            localrealizacao = ler.nextLine();
            System.out.print("Local de inscrição do evento: ");
            localinscricao = ler.nextLine();
            if (nome.equals("") == true || localinscricao.equals("") == true || localrealizacao.equals("")==true) {
                throw new NomeInvalido();
            }
            if (fitness.ExisteEvento(nome) == true) {
                throw new EventoJaExistente(nome);
            }
            System.out.print("Tipo de Actividade: ");
            tipo = ler.nextLine();
            if (FitnessMenu.ExisteDesporto(tipo) == false) {
                throw new TipoNaoExiste(tipo);
            }
            System.out.print("Data limite de inscrições(dd-mm-aa): ");
            date1 = ler.nextLine();
            
            System.out.print("Data da realização do eveto:(dd-mm-aa): ");
            date2 = ler.nextLine();
            if (date1.equals("") == true || date2.equals("") == true) {
                throw new DataInvalida();
            }
            System.out.print("Número Máximo de inscrições: ");
            max = ler.nextInt();
            fim = date1.split("-");
            fazer=date2.split("-");
            dia = Integer.parseInt(fim[0]);
            mes = Integer.parseInt(fim[1]);
            ano = Integer.parseInt(fim[2]);
            datafim = new GregorianCalendar(ano, mes, dia);
            dia = Integer.parseInt(fazer[0]);
            mes = Integer.parseInt(fazer[1]);
            ano = Integer.parseInt(fazer[2]);
            datarealizacao=new GregorianCalendar(dia, mes, ano);
            e = new Evento(nome, tipo, localrealizacao, localinscricao, datarealizacao, datafim, max);
            if(fitness.ExisteEvento(nome)){
                throw new EventoJaExistente(nome);
            }else{
            fitness.AdicionarEvento(e);
            }
        } catch (NomeInvalido | TipoNaoExiste | DataInvalida | EventoJaExistente a) {
            System.out.println(a.getMessage());
        }
    }

    private static void ListarEventos() throws Excepcoes {
        if (fitness.NrdeEventosValidos() == 0) {
            throw new NaoTemEventos();
        } else {
            System.out.print(fitness.ListarEventos());
        }
    }

    private static boolean ExisteDesporto(String nome) {
        return fitness.ExisteDesporto(nome);
    }

    private static void AdicionarDesporto() throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        String nome;
        String tipo;
double cal;
        try {
            System.out.print("Nome do desporto: ");
            nome = ler.nextLine();
            if (nome.equals("") == true) {
                throw new DesportoInvalido();
            }
            System.out.print("Tipo de Desporto(Altitude,Competicao,Distancia,Outros):");
            tipo = ler.nextLine();
            System.out.print("Variável das calorias: ");
           cal = ler.nextDouble();
            if(fitness.ExisteTipo(tipo)){
            fitness.InserirDesporto(nome, tipo,cal);    
            }
            
        } catch (DesportoInvalido | TipoNaoExiste e) {
            System.out.println(e.getMessage());
        }

    }

    private static int MenuPedidos(User aux) throws Excepcoes {
        ArrayList<String> feitos, recebidos;
        int op, r;
        Scanner ler = new Scanner(System.in);
        String user;
        User u;
        op = r = 1;
        
        try {
            

            System.out.println("1 - Aceitar pedido");
            System.out.println("2 - Rejeitar pedido");
            System.out.println("3 - Voltar atrás");
            
System.out.print("Opção: ");
op = ler.nextInt();            
switch (op) {
                case 1: {
                    ListarPedidosRecebidos(aux);
                    System.out.print("User: ");
                    ler.nextLine();
                    user = ler.nextLine();
                    if (fitness.ExisteUser(user) == true) {
                        u = fitness.getUser(user).clone();
                        aux.AdicionarAmigo(user);
                        aux.RemoverPedidoRecebido(user);
                        u.RemoverPedidoFeito(aux.getEmail());
                        u.AdicionarAmigo(aux.getEmail());
                        fitness.AdicionaUser(u);
                        fitness.AdicionaUser(aux);
                    }
                    r=1;
                break;
                }
                case 2: {
                    ListarPedidosRecebidos(aux);
System.out.print("User: ");
                    ler.nextLine();
                    user = ler.nextLine();
                    if (fitness.ExisteUser(user) == true) {
                        u = fitness.getUser(user).clone();
                        aux.RemoverPedidoRecebido(user);
                        u.RemoverPedidoFeito(aux.getEmail());
                        fitness.AdicionaUser(u);
                        fitness.AdicionaUser(aux);
                    }
                    r=1;
                break;
                }
                case 3: {
                    r = 0;
                    break;
                }
                default: {
                    throw new OpcaoInvalida();
                }
            }

        } catch (UserNaoExiste | NaoTemPedidos | OpcaoInvalida e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    private static void ListarPedidosFeitos(User aux) throws Excepcoes {
    ArrayList<String> feitos;
    
        feitos = aux.getListaAmigos().getPedidosFeitos();
           
            if (!feitos.isEmpty()) {
                System.out.println("Pedidos feitos:");
                for (String s : feitos) {
                    System.out.println(s);
                }
            }else{
            
            {
                throw new NaoTemPedidos();
            }
    }}
    private static void ListarPedidosRecebidos(User aux) throws Excepcoes {
    ArrayList<String> recebidos;
    
        recebidos = aux.getListaAmigos().getPedidosRecebidos();
           
            if (!recebidos.isEmpty()) {
                System.out.println("Pedidos recebidos:");
                for (String s : recebidos) {
                    System.out.println(s);
                }
            }else{
            
            {
                throw new NaoTemPedidos();
            }
    }}

    private static void RemoverActividade(User u) throws Excepcoes {
   Scanner ler=new Scanner(System.in);
   String[]aux1,aux2;
   GregorianCalendar date;
   String nome,data,horas;
   int hora,minuto,dia,mes,ano;
        try{
            System.out.print(u.ListarActividades());
            System.out.print("Designação da actividade: ");
            nome=ler.nextLine();
           System.out.print("Data de realização da actividade(dd-mm-aa): ");
           data=ler.nextLine();
           System.out.print("Hora de realização da actividade(hh:mm): ");
           horas=ler.nextLine();
           aux1=data.split("-");
           aux2=horas.split(":");
           dia=Integer.parseInt(aux1[0]);
        mes=Integer.parseInt(aux1[1]);
        ano=Integer.parseInt(aux1[2]);
        hora=Integer.parseInt(aux2[0]);
        minuto=Integer.parseInt(aux2[1]);
        date=new GregorianCalendar(ano, mes, dia,hora,minuto);
        if(!u.ExisteActividade(date)){
            throw new ActividadeNaoExiste();
        }
        u.RemoverActividade(date);
        fitness.AdicionaUser(u);
        }catch(ActividadeNaoExiste | NaoTemDesportos e){
            System.out.println(e.getMessage());
        }
    }

    private static int MenuRecordes(User aux) throws Excepcoes {
    Scanner ler=new Scanner(System.in);
    int op,r;
    r=op=1;
    String tipo;
    System.out.println("-----MENU RECORDES-----");
    System.out.println("1 - Listar Recordes");
    System.out.println("2 - Consultar Recordes");
    System.out.println("3 - Voltar atrás");
    System.out.print("Opção: ");
    op=ler.nextInt();
    try{
        switch(op){
            case 1:{
                System.out.print(aux.ListarRecordes());
                r=1;
                break;
            }
            case 2:{
                System.out.print(aux.ListarRecordes());
                System.out.print("Recorde: ");
                ler.nextLine();
                tipo=ler.nextLine();
                System.out.print(aux.ConsultarRecorde(tipo));
            }
        }
    }catch(NaoTemRecordes | RecordeNaoExistente e){
        System.out.println(e.getMessage());
    }
    return r;
    }

    private static void InscreverEvento(User aux) throws Excepcoes {
    Scanner ler=new Scanner(System.in);
    String nome;
    Evento e;
    GregorianCalendar system=new GregorianCalendar();
        try{
        System.out.print(fitness.ListarEventosDisponiveis());
        System.out.print("Nome do evento em qual se quer inscrever: ");
        nome=ler.nextLine();
        if(!fitness.ExisteEvento(nome)){
            throw new EventoNaoExiste();
        }else{
            e=fitness.getEvento(nome).clone();
            if(aux.TemActividades(e.getTipo())==false || e.getDatafim().before(system)==true){
                throw new InscricaoInvalida();
            }else{
                e.InscreverUser(aux.getEmail());
                fitness.AdicionarEvento(e);
                aux.InscreverEvento(nome);
                fitness.AdicionaUser(aux);
                  
            }
        }
    }catch(NaoTemEventos | InscricaoInvalida a){
        System.out.println(a.getMessage());
    }
    }
}


