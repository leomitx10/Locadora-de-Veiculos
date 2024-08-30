package com.squad2.LocadoraDeVeiculos.controller;

import com.squad2.LocadoraDeVeiculos.model.entity.Pagamento;
import com.squad2.LocadoraDeVeiculos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;


    @GetMapping("/resumo/{carrinhoId}")
    public ResponseEntity<String> obterResumoPedido(@PathVariable Long carrinhoId) {
        String resumo = pagamentoService.resumoPedido(carrinhoId);
        return ResponseEntity.ok(resumo);
    }

    @PostMapping("/processar")
    public ResponseEntity<String> processarPagamento(@RequestBody Pagamento pagamento) {
        String resultado = pagamentoService.pagamentoCliente(pagamento);
        return ResponseEntity.ok(resultado);
    }
}
