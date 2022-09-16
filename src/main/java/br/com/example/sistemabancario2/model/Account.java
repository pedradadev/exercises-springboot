package br.com.example.sistemabancario2.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Accont extends AbstractEntity{
    @NotEmpty(message = "O numero da conta não pode ser nulo")
    private Integer numero;
    @NotEmpty(message = "A agencia deve ter um numero")
    private Integer agencia;
    private Double saldo = 0D;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Accont accont = (Accont) o;
        return numero.equals(accont.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numero);
    }
}
