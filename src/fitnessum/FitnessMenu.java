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
        String[] desportos;
        String[] alt;
        String[] outros;
        String[] distancia;
//        distancia = new String[]{"Cycling, Sport", "Cycling, Transport", "Fitness Walking", "Golf", "Indoor Cycling", "Kayaking", "Kitesurfing", "Riding", "Roller Skiing", "Rowing", "Running", "Sailing", "Skating", "Swimming", "Walking", "Wind Surfing"};
//        desportos = new String[]{"Badminton", "Baseball", "Basketball", "Boxing", "Cricket", "Football, american", "Football, rugby", "Football, soccer", "Handball", "Hockey", "Polo", "Squash", "Table Tennis", "Tennis", "Volleyball, beach", "Volleyball, indoor"};
//        alt = new String[]{"Hiking", "Mountain Biking", "Orienteering", "Skiing, cross country", "Skiing, downhill", "Snowboarding", "Climbing stairs", "Scuba diving"};
//        outros = new String[]{"Aerobics", "Eliptical training", "Dancing", "Fencing", "Gymnastics", "Martial Arts", "Pilates"};
        fitness = new FitnessUM();
//        fitness.CarregarDesportos(distancia, desportos, alt, outros);
        fitness.AdicionaUser(new User("lol", "Helena Fernandes", "lol", "Feminino", 1.5, 40.0, "LOL", new GregorianCalendar(2002, 9, 4)));
        fitness.AdicionaUser(new User("joao", "Joao Fernandes", "joao", "Masculino", 1.9, 70.0, "LOL", new GregorianCalendar(1993, 7, 21)));

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
        System.out.println("5 - Gravar objecto");
        System.out.println("6 - Gravar txt");
        System.out.println("7 - Carregar Objecto");
        System.out.println("8 - Sair");
        System.out.print("Opção: ");
        r = 0;

        op = ler.nextInt();
        try {
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
                case 5: {
                    try {
                        FitnessMenu.GravarObjecto();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 6: {
                    try {
                        FitnessMenu.GravarTxt();

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 7: {
                    try {
                        FitnessMenu.CarregarObjecto();

                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    r = 1;
                    break;
                }
                case 8: {
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
//                    while (r != 0) {
//                        r = FitnessMenu.MenuRecordes(aux);
//                    }
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
            if (user.equals("admin") == true && pass.equals("admin") == true) {
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

        System.out.print("Altura: ");
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
        System.out.println("4 - Logout");
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
                case 4: {
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
        String nome, date, tipo, duracao, horas;
        int dia, mes, ano, hora, minuto;
        Double cal, hidration, duration;
        Scanner ler = new Scanner(System.in);
        GregorianCalendar data;
        String[] datas, time;
        TreeSet<String> distance, sports, altitude, others;

        
        try {
        System.out.print(fitness.ListarDesportos());
        distance = fitness.getDistancia();
        sports = fitness.getDesporto();
        altitude = fitness.getAltitude();
        others = fitness.getOutros();
        System.out.println("-----REGISTAR ACTIVIDADE-----");
        System.out.print("Nome da Actividade: ");
        nome = ler.nextLine();
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
        tipo = fitness.getTipo(nome);
        System.out.println(tipo);
        
            switch (tipo) {
                case "Desporto": {
                    FitnessMenu.ActividadeDesporto(u, data, tipo, duracao, hidration);
                    break;
                }
                case "Distancia": {
                    FitnessMenu.ActividadeDistancia(u, data, tipo, duracao, hidration);
                    break;
                }
                case "Altitude": {
                    FitnessMenu.ActividadeAltitude(u, data, tipo, duracao, hidration);
                    break;
                }
                case "Outros": {
                    FitnessMenu.ActividadeOutros(u, data, tipo, duracao, hidration);
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

    private static void ActividadeDistancia(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
        double avgspd, maxspd, distancia, cal, peso, altura, bmr, duracao;
        int idade;
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
        String genero;
        System.out.print("Distancia(em KM): ");
        distancia = ler.nextDouble();
        avgspd = distancia / convertido;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * convertido;
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
        g = new Distancia(date, tipo, cal, hidration, distancia, maxspd, avgspd, hora, minuto);
        u.AdicionarActividade(g);

    }

    private static void ActividadeAltitude(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
        double avgspd, maxspd, distancia, cal, peso, altura, bmr, altmax, altmin, maxdesc, mindesc, convertido;
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
        g = new Altitude(date, tipo, cal, hidration, altmax, altmin, maxdesc, mindesc, distancia, maxspd, avgspd, tempo, hora, minuto);
        u.AdicionarActividade(g);
    }

    private static void ActividadeDesporto(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
        double avgspd, maxspd, distancia, cal, peso, altura, bmr, convertido;
        int idade, hora, minuto;
        String time[] = duration.split(":");
        hora = Integer.parseInt(time[0]);
        minuto = Integer.parseInt(time[1]);
        Scanner ler = new Scanner(System.in);
        GeneralActivity g;
        String genero, resultado;
        System.out.print("Distância(em KM): ");
        distancia = ler.nextDouble();
        ler.nextLine();
        System.out.print("Resultado(Victória/Derrota/Empate): ");
        resultado = ler.nextLine();
        convertido = (double) minuto / 60;
        convertido += (double) hora;
        avgspd = distancia / convertido;
        maxspd = ((avgspd * avgspd) / (2 * distancia)) * convertido;
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
        g = new Competicao(date, tipo, cal, hidration, distancia, resultado, avgspd, maxspd, hora, minuto);
        u.AdicionarActividade(g);
    }

    private static void ActividadeOutros(User u, GregorianCalendar date, String tipo, String duration, Double hidration) {
        double cal, peso, altura, bmr, convertido;
        String genero;
        int idade, hora, minuto;
        GeneralActivity g;
        String time[] = duration.split(":");
        hora = Integer.parseInt(time[0]);
        minuto = Integer.parseInt(time[1]);
        convertido = (double) minuto / 60;
        convertido += (double) hora;
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
        g = new Outros(date, tipo, cal, hidration, hora, minuto);
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

            System.out.println(aux.ConsultarActividade(data));

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
        System.out.println("4 - Voltar ao menu de utilizador");
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
                case 4: {
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
        System.out.println("1 - Criar Evento");
        System.out.println("2 - Listar Eventos disponíveis");
        System.out.println("3 - Inscrever num Evento");
        System.out.println("4 - Voltar ao menu de utilizador");
        System.out.print("Opção: ");
        op = ler.nextInt();
        try {
            switch (op) {
                case 1: {
                    FitnessMenu.CriarEvento(aux);
                    r = 1;
                    break;
                }
                case 2: {
                    FitnessMenu.ListarEventos();
                    r = 1;
                    break;
                }
                case 3: {
                    r = 1;
                    break;
                }
                case 4: {
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

    private static void CriarEvento(User aux) throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        int dia, mes, ano;
        String[] args;
        String nome, local, date, tipo;
        GregorianCalendar datafim;
        Evento e;
        try {
            System.out.print("Nome do Evento: ");
            nome = ler.nextLine();
            System.out.print("Local do Evento: ");
            local = ler.nextLine();
            if (nome.equals("") == true || local.equals("") == true) {
                throw new NomeInvalido();
            }
            if (fitness.ExisteEvento(nome) == true) {
                throw new EventoJaExistente(nome);
            }
            System.out.print("Tipo de Actividade: ");
            tipo = ler.nextLine();
            if (FitnessMenu.ExisteActividade(tipo) == false) {
                throw new TipoNaoExiste(tipo);
            }
            System.out.print("Data limite de inscrições(dd-mm-aa): ");
            date = ler.nextLine();
            if (date.equals("") == true) {
                throw new DataInvalida();
            }
            args = date.split("-");
            dia = Integer.parseInt(args[0]);
            mes = Integer.parseInt(args[1]);
            ano = Integer.parseInt(args[2]);
            datafim = new GregorianCalendar(ano, mes, dia);
            e = new Evento(nome, local, 1, datafim);
            e.InscreverUser(aux.getNome());
            fitness.AdicionarEvento(e);
            aux.InscreverEvento(e.getNome());
            fitness.AdicionaUser(aux);
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

    private static boolean ExisteActividade(String tipo) {
        return fitness.ExisteActvidade(tipo);
    }

    private static void AdicionarDesporto() throws Excepcoes {
        Scanner ler = new Scanner(System.in);
        String nome;
        String tipo;

        try {
            System.out.print("Nome do desporto: ");
            nome = ler.nextLine();
            if (nome.equals("") == true) {
                throw new DesportoInvalido();
            }
            System.out.print("Tipo de Desporto(Altitude,Competição,Distância,Outros):");
            tipo = ler.nextLine();
            fitness.InserirDesporto(nome, tipo);
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
                    ListarPedidos(aux);
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
                    ListarPedidos(aux);
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

    private static void ListarPedidos(User aux) throws Excepcoes {
    ArrayList<String> feitos,recebidos;
    
        feitos = aux.getListaAmigos().getPedidosFeitos();
            recebidos = aux.getListaAmigos().getPedidosRecebidos();
            if (!feitos.isEmpty()) {
                System.out.println("Pedidos feitos:");
                for (String s : feitos) {
                    System.out.println(s);
                }
            }
            if (!recebidos.isEmpty()) {
                System.out.println("Pedidos recebidos:");
                for (String s : recebidos) {
                    System.out.println(s);
                }
            }
            if (recebidos.isEmpty() && feitos.isEmpty()) {
                throw new NaoTemPedidos();
            }
    }
}
