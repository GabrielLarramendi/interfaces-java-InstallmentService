package model.services;

import model.entities.Contract;

import java.time.LocalDateTime;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {}

    public void processContract(Contract contract, Integer months) {

        for (int i = 0; i < months; i++) {
            LocalDateTime dueMonth = contract.getDate().plusMonths(i);

        }


    }
}
