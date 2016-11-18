package com.bitwise.manageme.rssson.util.usertypes;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.io.Serializable;
import java.util.Currency;

import javax.persistence.Embeddable;

@Embeddable
public class MonetaryAmount implements Serializable {

	private static final long serialVersionUID = -8672521413422484852L;
	
	private Double amount;
	
	private Currency currency;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
