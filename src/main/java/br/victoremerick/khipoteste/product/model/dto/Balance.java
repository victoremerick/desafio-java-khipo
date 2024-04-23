package br.victoremerick.khipoteste.product.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Balance {

    @JsonProperty("total")
    private BigInteger total;
    @JsonProperty("limite")
    private BigInteger limit;
    @JsonProperty("data_extrato")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
    private ZonedDateTime statementCreatedAt;
}
