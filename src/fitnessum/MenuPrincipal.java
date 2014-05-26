/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnessum;

import events.*;
import activities.*;
import exceptions.*;
import java.util.*;
import users.*;

/**
 *
 * @author mesas
 */
public class MenuPrincipal {

    private static FitnessUM fitness;
    private static String[] desportos;
    private static String[] alt;
    private static String[] outros;
    private static String[] distancia;

    public static void main(String[] args) throws Excepcoes {
        int resultado = 1;
        distancia = new String[]{"Cycling, Sport", "Cycling, Transport", "Fitness Walking", "Golf", "Indoor Cycling", "Kayaking", "Kitesurfing", "Riding", "Roller Skiing", "Rowing", "Running", "Sailing", "Skating", "Swimming", "Walking", "Wind Surfing"};
        desportos = new String[]{"Badminton", "Baseball", "Basketball", "Boxing", "Cricket", "Football, american", "Football, rugby", "Football, soccer", "Handball", "Hockey", "Polo", "Squash", "Table Tennis", "Tennis", "Volleyball, beach", "Volleyball, indoor"};
        alt = new String[]{"Hiking", "Mountain Biking", "Orienteering", "Skiing, cross country", "Skiing, downhill", "Snowboarding", "Climbing stairs", "Scuba diving"};
        outros = new String[]{"Aerobics", "Eliptical training", "Dancing", "Fencing", "Gymnastics", "Martial Arts", "Pilates",};
        fitness = new FitnessUM();
        fitness.AdicionaUser(new User());
        fitness.AdicionaUser(new User("joao", "joao", "joao", "Masculino", 1.9, 70.0, "LOL", new GregorianCalendar()));
        while (resultado != 0) {
            resultado = MenuPrincipal.Menu();
        }
    }

    private static int Menu() throws Excepcoes {
        int op, r;
        Scanner ler = new Scanner(System.in);

        System.out.println("BEM VINDO AO FITNESSUM!");
        System.out.println("1 - Login");
        System.out.println("2 - Registar");
        System.out.println("3 - Userlist");
        System.out.println("4 - Listar Desportos disponíveis");
        System.out.println("5 - Sair");
        System.out.print("Opção: ");
        r = 0;

        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {
                    r = MenuPrincipal.Login();
                    break;
                }
                case 2: {
                    MenuPrincipal.Registar();
                    r = 1;
                    break;
                }
                case 3: {
                    MenuPrincipal.PrintUserList();
                    r = 1;
                    break;
                }
                case 4: {
                    MenuPrincipal.ListarDesportos();
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
        } catch (OpcaoInvalida e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    private static int MenuUtilizador(String user) throws Excepcoes {
        int op, r;

        Scanner ler = new Scanner(System.in);
        System.out.println("-----MENU UTILIZADOR-----");
        System.out.println("1 - Ver Perfil");
        System.out.println("2 - Mudar informações");
        System.out.println("3 - Adicionar Amigo");
        System.out.println("4 - Ver Amigos");
        System.out.println("5 - Registar Actividade");
        System.out.println("6 - Listar Actividades");
        System.out.println("7 - Remover Actividade");
        System.out.println("8 - Logout");
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
                        r = MenuPrincipal.MenuInf(aux);
                    }

                    r = 1;
                    break;

                }

                case 3: {
                    while (r != 0) {
                        r = MenuPrincipal.AdicionarAmigo(aux);
                    }

                    r = 1;
                    break;
                }
                case 4: {
                    while (r != 0) {
                        r = MenuPrincipal.FriendsList(aux);
                    }

                    r = 1;
                    break;
                }
                case 5: {
                    MenuPrincipal.RegistarActividade(aux);

                    r = 1;
                    break;
                }
                case 6: {
                    try {
                        System.out.print(aux.ListarActividades());
                        
                    } catch (NaoTemActividades e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 7: {try{
                    System.out.print(aux.ListarActividades());
                    MenuPrincipal.RemoverActividade(aux);}
                catch(NaoTemActividades e){
                    System.out.println(e.getMessage());
                }
                    r = 1;
                    break;
                }
                case 8: {
                    fitness.AdicionaUser(aux);
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
            if (fitness.LoginValido(user, pass) == true) {

                while (resultado != 0) {
                    fitness.setUserLogado(user);
                    resultado = MenuPrincipal.MenuUtilizador(user);
                }

            }

        } catch (UserNaoExiste e) {
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
        System.out.println("P�?GINA DE REGISTO");

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

        System.out.print("Altura: ");
        altura = ler.nextDouble();

        System.out.print("Peso: ");
        peso = ler.nextDouble();

        System.out.print("Desporto Favorito: ");
        ler.nextLine();
        favsport = ler.nextLine();
        try {
            if (email.equals("") == true) {
                throw new UserInvalido(email);
            } else {
                if (pass1.equals(pass2) == false) {
                    throw new PassInvalida();
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
            String[] aux = date.split("-");
            dia = Integer.parseInt(aux[0]);
            mes = Integer.parseInt(aux[1]);
            ano = Integer.parseInt(aux[2]);
            data.set(Calendar.DATE, dia);
            data.set(Calendar.MONTH, mes);
            data.set(Calendar.YEAR, ano);
            u = new User(email, nome, pass1, genero, altura, peso, favsport, data);
            fitness.AdicionaUser(u);
        } catch (UserInvalido | PassInvalida | DataInvalida | AlturaInvalida | PesoInvalido user) {

            System.out.println(user.getMessage());
        }

    }

    private static void PrintUserList() {
        System.out.println(fitness.toString());
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

    private static int AdicionarAmigo(User u) throws Excepcoes {
        String user;
        Scanner ler = new Scanner(System.in);
        MenuPrincipal.PrintUserList();
        System.out.print("User: ");
        user = ler.nextLine();
        User aux;
        try {
            if (fitness.ExisteUser(user) == true) {
                aux=fitness.getUser(user);
                u.AdicionarAmigo(user);
                aux.AdicionarAmigo(u.getEmail());
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
                    r = MenuPrincipal.MenuAmigos(user);
                }
            }

        } catch (NaoTemAmigos | UserNaoExiste e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private static void RegistarActividade(User u) {
        String tipo, date, duracao;
        int dia, mes, ano;
        Double cal, hidration, duration;
        Scanner ler = new Scanner(System.in);
        GregorianCalendar data = new GregorianCalendar();
        String[] aux;
        MenuPrincipal.ListarDesportos();
        ArrayList<String> distance, sports, altitude, others;
        distance = new ArrayList<>(Arrays.asList(distancia));
        sports = new ArrayList<>(Arrays.asList(desportos));
        altitude = new ArrayList<>(Arrays.asList(alt));
        others = new ArrayList<>(Arrays.asList(outros));
        System.out.println("-----REGISTAR ACTIVIDADE-----");
        System.out.print("Nome da Actividade: ");
        tipo = ler.nextLine();
        System.out.print("Duração(h:m): ");

        duracao = ler.nextLine();
        System.out.print("Hidratação: ");

        hidration = ler.nextDouble();
        System.out.print("Data de realização(dd-mm-aa): ");
        ler.nextLine();
        date = ler.nextLine();
        aux = date.split("-");
        dia = Integer.parseInt(aux[0]);
        mes = Integer.parseInt(aux[1]);
        ano = Integer.parseInt(aux[2]);
        data.set(Calendar.DATE, dia);
        data.set(Calendar.MONTH, mes);
        data.set(Calendar.YEAR, ano);
        duration = MenuPrincipal.ConverterParaHoras(duracao);
        try {
            if (distance.contains(tipo)) {
                MenuPrincipal.ActividadeDistancia(u, data, tipo, duracao, hidration);
            } else {
                if (altitude.contains(tipo)) {
                    MenuPrincipal.ActividadeAltitude(u, data, tipo, duracao, hidration);
                } else {
                    if (sports.contains(tipo)) {
                        MenuPrincipal.ActividadeDesporto(u, data, tipo, duracao, hidration);
                    } else {
                        if (others.contains(tipo)) {
                            MenuPrincipal.ActividadeOutros(u, data, tipo, duracao, hidration);
                        } else {
                            throw new TipoNaoExiste(tipo);
                        }
                    }
                }
            }
        fitness.AdicionaUser(u);
        } catch (TipoNaoExiste e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ListarDesportos() {

        TreeSet<String> sports = new TreeSet<String>();

        System.out.println("-----LISTA DE DESPORTOS-----");
        sports.addAll(Arrays.asList(distancia));
        sports.addAll(Arrays.asList(desportos));
        sports.addAll(Arrays.asList(alt));
        sports.addAll(Arrays.asList(outros));
        for (String s : sports) {
            System.out.println(s);
        }
    }

    private static void ActividadeDistancia(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
        double avgspd, maxspd, distancia, cal, peso, altura, bmr, duracao;
        int idade;
        Scanner ler = new Scanner(System.in);
        GeneralActivity g;
        String genero;
        System.out.print("Distância(em KM): ");
        distancia = ler.nextDouble();
        duracao = MenuPrincipal.ConverterParaHoras(duration);
        avgspd = distancia / duracao;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * duracao;
        peso = u.getPeso();
        altura = u.getAltura();
        genero = u.getGen();
        idade = u.getIdade();
        if (genero.equals("Masculino") == true) {
            bmr = ((6.23 * peso) + (altura * 12.7) + (6.8 * idade));
        } else {
            bmr = ((4.35 * peso) + (altura * 4.7) + (4.7 * idade));
        }
        cal = bmr * 1.55;
        g = new Distancia(date, tipo, cal, duration, hidration, distancia, maxspd, avgspd);
        u.AdicionarActividade(g);

    }

    private static void ActividadeAltitude(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
    double avgspd, maxspd, distancia, cal, peso, altura, bmr, duracao,altmax,altmin,maxdesc,mindesc;
        int idade;
        Scanner ler = new Scanner(System.in);
        GeneralActivity g;
        String genero,tempo;
        System.out.print("Distância(em KM): ");
        distancia = ler.nextDouble();
        ler.nextLine();
        System.out.print("Tempo: ");
        tempo=ler.nextLine();
        System.out.print("Altitude máxima(em metros): ");
        
        altmax = ler.nextDouble();
        System.out.print("Altitude mínima(em metros): ");
        altmin= ler.nextDouble();
        System.out.print("Descida máxima(em metros): ");
        maxdesc = ler.nextDouble();
        System.out.print("Descida mínima(em metros): ");
        mindesc = ler.nextDouble();
        duracao = MenuPrincipal.ConverterParaHoras(duration);
        avgspd = distancia / duracao;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * duracao;
        peso = u.getPeso();
        altura = u.getAltura();
        genero = u.getGen();
        idade = u.getIdade();
        if (genero.equals("Masculino") == true) {
            bmr = ((6.23 * peso) + (altura * 12.7) + (6.8 * idade));
        } else {
            bmr = ((4.35 * peso) + (altura * 4.7) + (4.7 * idade));
        }
        cal = bmr * 1.55;
        g=new Altitude(date, tipo, cal, duration, hidration, altmax, altmin, maxdesc, mindesc, distancia, maxspd, avgspd, tempo);
        u.AdicionarActividade(g);
    }

    private static void ActividadeDesporto(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
    double avgspd, maxspd, distancia, cal, peso, altura, bmr, duracao;
        int idade;
        Scanner ler = new Scanner(System.in);
        GeneralActivity g;
        String genero,resultado;
        System.out.print("Distância(em KM): ");
        distancia = ler.nextDouble();
        ler.nextLine();
        System.out.print("Resultado(Victoria ou Derrota): ");
        resultado=ler.nextLine();
        duracao = MenuPrincipal.ConverterParaHoras(duration);
        avgspd = distancia / duracao;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * duracao;
        peso = u.getPeso();
        altura = u.getAltura();
        genero = u.getGen();
        idade = u.getIdade();
        if (genero.equals("Masculino") == true) {
            bmr = ((6.23 * peso) + (altura * 12.7) + (6.8 * idade));
        } else {
            bmr = ((4.35 * peso) + (altura * 4.7) + (4.7 * idade));
        }
        cal = bmr * 1.55;
        g = new Desporto(date, tipo, cal, duration, hidration, distancia, resultado);
        u.AdicionarActividade(g);
    }

    private static void ActividadeOutros(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
    double cal, peso, altura, bmr, duracao;
    String genero;
    int idade;
    GeneralActivity g;
    duracao = MenuPrincipal.ConverterParaHoras(duration);
        
        peso = u.getPeso();
        altura = u.getAltura();
        genero = u.getGen();
        idade = u.getIdade();
        if (genero.equals("Masculino") == true) {
            bmr = ((6.23 * peso) + (altura * 12.7) + (6.8 * idade));
        } else {
            bmr = ((4.35 * peso) + (altura * 4.7) + (4.7 * idade));
        }
        cal = bmr * 1.55;
        g=new Outros(date, tipo, cal, duration, hidration);
        u.AdicionarActividade(g);
    }

    private static int MenuAmigos(String user) throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int op, r;
        r = 1;
        User aux=fitness.getUser(user);
        System.out.println("-----Perfil de " + aux.getNome() + "-----");
        System.out.println("1 - Ver perfil");
        System.out.println("2 - Ver actividades");
        System.out.println("3 - Voltar atrás");
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
                    try {
                        System.out.print(aux.ListarActividades());
                    } catch (NaoTemActividades e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 3: {
                    r = 0;
                    break;
                }
                default: {
                    r = 1;
                    throw new OpcaoInvalida();

                }

            }
            return r;
        } catch (OpcaoInvalida e) {
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

    private static void RemoverActividade(User aux) throws Excepcoes {
        String cod;
        Scanner ler = new Scanner(System.in);
        
        try {
            System.out.println("-----REMOVER ACTIVIDADE-----");
            
            System.out.print("Código da actividade para remover: ");
            cod = ler.nextLine();
            aux.RemoverActividade(cod);
        } catch (NaoTemActividades | ActividadeNaoExiste e) {
            System.out.println(e.getMessage());
        }
    }

}
