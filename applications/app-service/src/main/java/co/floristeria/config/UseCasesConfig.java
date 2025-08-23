package co.floristeria.config;

import co.floristeria.model.arreglofloral.gateways.ArreglofloralRepository;
import co.floristeria.model.cliente.gateways.ClienteRepository;
import co.floristeria.model.destinatario.gateways.DestinatarioRepository;
import co.floristeria.model.pedido.gateways.PedidoRepository;
import co.floristeria.usecase.arreglofloral.ArreglofloralUseCase;
import co.floristeria.usecase.cliente.ClienteUseCase;
import co.floristeria.usecase.destinatario.DestinatarioUseCase;
import co.floristeria.usecase.pedido.PedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.floristeria.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public ArreglofloralUseCase arreglofloralUseCase(ArreglofloralRepository arreglofloralRepository) {
                return  new ArreglofloralUseCase(arreglofloralRepository);
        }

        @Bean
        public ClienteUseCase clienteUseCase(ClienteRepository clienteRepository) {
                return new ClienteUseCase(clienteRepository);
        }

        @Bean
        public DestinatarioUseCase destinatarioUseCase(DestinatarioRepository destinatarioRepository) {
                return new DestinatarioUseCase(destinatarioRepository);
        }

        @Bean
        public PedidoUseCase pedidoUseCase(PedidoRepository pedidoRepository,
                                           ClienteRepository clienteRepository,
                                           ArreglofloralRepository arreglofloralRepository,
                                           DestinatarioRepository destinatarioRepository) {
                return new PedidoUseCase(pedidoRepository, clienteRepository, arreglofloralRepository, destinatarioRepository);
        }
}
