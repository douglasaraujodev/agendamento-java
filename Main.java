import java.util.ArrayList;
import java.util.Scanner;

class Agendamento {
    private String nome;
    private int idade;
    private String dataExame;

    public Agendamento(String nome, int idade, String dataExame) {
        this.nome = nome;
        this.idade = idade;
        this.dataExame = dataExame;
    }

    public String getNome() {
        return nome;
    }

    public String getDataExame() {
        return dataExame;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos - " + dataExame;
    }
}

class SistemaAgendamento {
    private ArrayList<Agendamento> agendamentos = new ArrayList<>();

    public void agendar(String nome, int idade, String dataExame) {
        Agendamento agendamento = new Agendamento(nome, idade, dataExame);
        agendamentos.add(agendamento);
        System.out.println("Exame agendado com sucesso!");
    }

    public void exibirAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento encontrado.");
        } else {
            System.out.println("Agendamentos:");
            for (Agendamento a : agendamentos) {
                System.out.println(a);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaAgendamento sistema = new SistemaAgendamento();

        while (true) {
            System.out.println("\n--- Sistema de Agendamento de Exames de Vista ---");
            System.out.println("1. Agendar exame");
            System.out.println("2. Ver agendamentos");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            if (escolha == 1) {
                System.out.print("Digite seu nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite sua idade: ");
                int idade = scanner.nextInt();
                System.out.print("Digite a data do exame (AAAA-MM-DD): ");
                String dataExame = scanner.next();

                sistema.agendar(nome, idade, dataExame);
            } else if (escolha == 2) {
                sistema.exibirAgendamentos();
            } else if (escolha == 3) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
