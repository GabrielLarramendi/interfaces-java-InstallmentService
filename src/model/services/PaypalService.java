package model.services;

public class PaypalService implements OnlinePaymentService{

    @Override
    public Double onlinePaymentFee(Double amount) { //Taxa própria
        return amount * 0.02;
    }

    @Override
    public Double interest(Double amount, Integer months) { //Taxa do serviço do paypal
        return amount * 0.01 * months;
    }
}
