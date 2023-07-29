package example.domain;

import example.Withdraw;

import java.math.BigDecimal;

public class BolgeYoneticisi extends Employee{

    @Override
    public void processRequest(Withdraw request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(750000)) <= 0) {
            System.out.println(this.getClass().getName() + " tarafından "
                    + request.getAmount() + " tutarında para çekme işlemi onaylandı.");
        } else if (nextApprover != null) {

            System.out.println(request.getAmount() + "TL tutarındaki işlem, "
                    +this.getClass().getName() + "'ın maksimum limitini aştığı için işlem "
                    + nextApprover.getClass().getName() + " kişisine gönderildi.");

        }
    }
}
