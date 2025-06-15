package pl.zderka.ecommerce.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.zderka.ecommerce.sales.cart.HashMapCartStorage;
import pl.zderka.ecommerce.sales.offering.OfferCalculator;
import pl.zderka.ecommerce.sales.payment.PaymentDetails;
import pl.zderka.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.zderka.ecommerce.sales.reservation.ReservationRepository;

@Configuration
public class SalesConfiguration {

    @Bean
    SalesFacade createMySalesFacade() {
        return new SalesFacade(new HashMapCartStorage(),
                new OfferCalculator(),
                (RegisterPaymentRequest request) -> {
                    return new PaymentDetails("http://payment");
                },
                new ReservationRepository());
    }
}
