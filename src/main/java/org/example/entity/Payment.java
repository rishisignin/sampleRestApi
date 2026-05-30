package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "payments")
public class Payment {

    @Id
    private String id;

    private Boolean chargeCustomAmount;
    private BigDecimal customAmount;

    // Masked PAN — only last 4 digits stored (PCI-DSS)
    private String cardNumberLast4;

    private String expirationDate;
    private String cardHolderName;
    private String zipCode;

    private Instant createdAt;
}
