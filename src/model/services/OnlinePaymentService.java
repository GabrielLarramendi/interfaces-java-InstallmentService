package model.services;

public interface OnlinePaymentService {

    Double onlinePaymentFee(Double amount);

    Double interest(Double amount, Integer months);

}
