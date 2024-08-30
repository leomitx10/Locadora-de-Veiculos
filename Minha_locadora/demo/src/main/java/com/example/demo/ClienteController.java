package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "form";
    }

    @PostMapping("/cadastrar")
    public String cadastrarCliente(Cliente cliente, Model model) {
        if (!clienteRepository.existsByEmail(cliente.getEmail())) {
            clienteRepository.save(cliente);
            model.addAttribute("mensagem", "Cadastro realizado com sucesso!");
        } else {
            model.addAttribute("mensagem", "E-mail já cadastrado!");
        }
        return "form";
    }
}