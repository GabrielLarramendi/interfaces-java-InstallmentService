package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {

        double basicQuota = contract.getTotalValue() / months;

        for (int i = 0; i < months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i + 1);
            double interest = onlinePaymentService.interest(basicQuota, i + 1); //Calcula a taxa do paypal;
            double fee = onlinePaymentService.onlinePaymentFee(basicQuota + interest); //Calcula a taxa de serviço em cima do valos básico + taxa paypal;
            double quota = interest + fee + basicQuota; //Valor total da parcela;
            contract.getInstallments().add(new Installment(dueDate, quota)); //Adiciona a parcela à lista de parcelas do contrato;
        }
    }
}
