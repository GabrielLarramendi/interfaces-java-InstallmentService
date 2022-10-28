package model.services;

public class PaypalService implements OnlinePaymentService{

    @Override
    public Double onlinePaymentFee(Double amount) {
        return null;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return null;
    }
}
