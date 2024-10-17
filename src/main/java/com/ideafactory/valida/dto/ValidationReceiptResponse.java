package com.ideafactory.valida.dto;

import java.time.LocalDateTime;

public record ValidationReceiptResponse(
        String details,
        Boolean isAssigned,
        Boolean isValid,
        LocalDateTime timestamp


) {
}
