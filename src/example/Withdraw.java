package example;

import example.domain.Employee;

import java.math.BigDecimal;


public class Withdraw {
    private String customerId;
    private BigDecimal amount;
    private String currencyType;
    private String sourceAccountId;

    public Withdraw(
            String customerId,
            BigDecimal amount,
            String currencyType,
            String sourceAccountId
    ) {
        this.customerId = customerId;
        this.amount = amount;
        this.currencyType = currencyType;
        this.sourceAccountId = sourceAccountId;
    }

    public void process(Employee employee){
        employee.processRequest(this);
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }
}
