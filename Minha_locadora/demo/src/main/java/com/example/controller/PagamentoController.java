package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Pagamento;
import com.example.service.PagamentoService;

@RestController
@RequestMapping("/api")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/pagamento")
    public Pagamento save(@RequestBody Pagamento pagamento) {
        pagamentoService.save(pagamento);
        return pagamento;
    }

    @GetMapping("/pagamento")
    public List<Pagamento> get() {
        return pagamentoService.get();
    }

    @GetMapping("/pagamento/{id}")
    public Pagamento get(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.get(id);
        if (pagamento == null) {
            throw new RuntimeException("Pagamento not found for the Id: " + id);
        }
        return pagamento;
    }

    @PutMapping("/pagamento")
    public Pagamento update(@RequestBody Pagamento pagamento) {
        pagamentoService.save(pagamento);
        return pagamento;
    }

    @DeleteMapping("/pagamento/{id}")
    public String delete(@PathVariable Long id) {
        pagamentoService.delete(id);
        return "Pagamento has been deleted with id: " + id;
    }
}
