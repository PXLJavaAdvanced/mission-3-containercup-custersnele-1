package be.pxl.ja;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeelnemerCompareToTest {

    @Test
    public void vergelijkDeelnemersMetVerschillendeEindtijd() {
        Deelnemer deelnemer1 = new Deelnemer("Tester1", Klassement.V);
        deelnemer1.setLopen(Duration.ofSeconds(250));
        Deelnemer deelnemer2 = new Deelnemer("Tester2", Klassement.V);
        deelnemer2.setLopen(Duration.ofSeconds(300));
        assertTrue(deelnemer1.compareTo(deelnemer2) < 0);
        assertTrue(deelnemer2.compareTo(deelnemer1) > 0);
    }
}
