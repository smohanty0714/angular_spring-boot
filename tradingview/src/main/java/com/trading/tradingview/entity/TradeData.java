package com.trading.tradingview.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.trading.tradingview.enums.TradeType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TradeData {
	@Id
	@GeneratedValue
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long transactionId;

	@JsonProperty(access = Access.WRITE_ONLY)
	private @NotNull TradeType side;

	private @NotNull  int volume;

	private @NotNull BigDecimal price;

	
}
