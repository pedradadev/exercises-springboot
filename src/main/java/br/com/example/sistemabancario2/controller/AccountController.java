package br.com.example.sistemabancario2.controller;

import br.com.example.sistemabancario2.model.Account;
import br.com.example.sistemabancario2.repository.AccontRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccontController extends AbstractController<Account, Long> {
    private AccontRepository repo;

    public AccontController(AccontRepository repo) {
        super(repo);
        this.repo = repo;
    }
}
