package br.com.netplus.app.domain;

import br.com.netplus.app.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Date dataPagamento;
    private Date dataVencimento;

    private PagamentoComBoleto(){

    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,  Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
