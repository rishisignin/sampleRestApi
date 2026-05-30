package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private Boolean chargeCustomAmount;

    private BigDecimal customAmount;

    @NotBlank(message = "Card number is required")
    @Pattern(regexp = "^\\d{13,19}$", message = "Card number must be 13 to 19 digits")
    private String cardNumber;

    @NotBlank(message = "Expiration date is required")
    @Pattern(regexp = "^\\d{2}/\\d{2}$", message = "Expiration date must be in MM/YY format")
    private String expirationDate;

    @NotBlank(message = "Security code is required")
    @Size(min = 3, max = 4, message = "Security code must be 3 or 4 digits")
    private String securityCode;

    @NotBlank(message = "Card holder name is required")
    private String cardHolderName;

    @NotBlank(message = "Zip code is required")
    private String zipCode;
}
