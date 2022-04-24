package com.pedrogomes.cursmc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrogomes.cursmc.domain.Categoria;
import com.pedrogomes.cursmc.domain.Cidade;
import com.pedrogomes.cursmc.domain.Cliente;
import com.pedrogomes.cursmc.domain.Endereco;
import com.pedrogomes.cursmc.domain.Estado;
import com.pedrogomes.cursmc.domain.ItemPedido;
import com.pedrogomes.cursmc.domain.Pagamento;
import com.pedrogomes.cursmc.domain.PagamentoComBoleto;
import com.pedrogomes.cursmc.domain.PagamentoComCartao;
import com.pedrogomes.cursmc.domain.Pedido;
import com.pedrogomes.cursmc.domain.Produto;
import com.pedrogomes.cursmc.domain.enums.EstadoPagamento;
import com.pedrogomes.cursmc.domain.enums.TipoCliente;
import com.pedrogomes.cursmc.repositories.CategoriaRepository;
import com.pedrogomes.cursmc.repositories.CidadeRepository;
import com.pedrogomes.cursmc.repositories.ClienteRepository;
import com.pedrogomes.cursmc.repositories.EnderecoRepository;
import com.pedrogomes.cursmc.repositories.EstadoRepository;
import com.pedrogomes.cursmc.repositories.ItemPedidoRepository;
import com.pedrogomes.cursmc.repositories.PagamentoRepository;
import com.pedrogomes.cursmc.repositories.PedidoRepository;
import com.pedrogomes.cursmc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	}

}
