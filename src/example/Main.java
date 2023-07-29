package example;

import example.domain.*;


import java.math.BigDecimal;

public class Main {

    /**
     * Buradaki örnek şu şekilde:
     * Bir bankada vezne'den para çekim miktarı günlük 40.000 TL olsun.
     * Bu bankaya bir müşteri geldiğinde veznedeki çalışandan 480.000 TL istediğinde,
     * Banka kuralları gereği vezene çalışan personel bu işlemi yapamayacaktır.
     * Dolayısıyla bu bir süreçe dönüşecek, veznedar bir üstündeki personel olan yöneticiye,
     * Eğer yöneticinin bu tutarı vermeye yetkisi yoksa yönetici bir üst personel olan müdür'e,
     * Eğer müdürün de bu tutarı vermeye yetkisi yoksa müdür bir üst personel olan bölge sorumlusuna
     * onay için ilgili talebi iletecektir.
     *
     * Dışarıdan bakıldığında da bu bir sorumluluk/yetki zinciri içerisinde ilerlemeye başlıyor.
     *
     * Böyle bir sorunu Chain of Responsibility Pattern kullanarak kodlayalım, çözelim.
     *
     * @param args
     */
    public static void main(String[] args) {

        Withdraw withdraw = new Withdraw(
                "1",
                BigDecimal.valueOf(480000),
                "TL",
                "TR645748396857485960343456");

        Employee veznedar = new Veznedar();
        Employee yonetici = new Yonetici();
        Employee mudur = new Mudur();
        Employee bolgeYoneticisi = new BolgeYoneticisi();

        veznedar.setNextApprover(yonetici);
        yonetici.setNextApprover(mudur);
        mudur.setNextApprover(bolgeYoneticisi);

        withdraw.process(veznedar);


    }
}