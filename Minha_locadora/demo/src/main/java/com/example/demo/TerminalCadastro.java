package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@SpringBootApplication
public class TerminalCadastro {

    private final ClienteService clienteService;
    private final VeiculoService veiculoService;

    public TerminalCadastro(ClienteService clienteService, VeiculoService veiculoService) {
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TerminalCadastro.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("1. Cadastrar Cliente");
                    System.out.println("2. Cadastrar Veículo");
                    System.out.println("3. Sair");
                    System.out.print("Escolha uma opção: ");
                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    switch (opcao) {
                        case 1:
                            cadastrarCliente(scanner);
                            break;
                        case 2:
                            cadastrarVeiculo(scanner);
                            break;
                        case 3:
                            System.out.println("Saindo");
                            return;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            }
        };
    }

    private void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome Completo: ");
        String nome = scanner.nextLine();

        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            try {
                System.out.print("Data de Nascimento (YYYY-MM-DD): ");
                dataNascimento = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("CNH: ");
        String cnh = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNomeCompleto(nome);
        cliente.setDataNascimento(dataNascimento.toString());
        cliente.setCpf(cpf);
        cliente.setCnh(cnh);
        cliente.setEmail(email);

        try {
            clienteService.salvar(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    private void cadastrarVeiculo(Scanner scanner) {
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Acessórios (separados por vírgula): ");
        String acessorios = scanner.nextLine();

        System.out.print("Preço por Dia: ");
        double precoPorDia = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(modelo);
        veiculo.setCategoria(categoria);
        veiculo.setAcessorios(acessorios);
        veiculo.setPrecoPorDia(precoPorDia);

        try {
            veiculoService.salvar(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
        }
    }
}
