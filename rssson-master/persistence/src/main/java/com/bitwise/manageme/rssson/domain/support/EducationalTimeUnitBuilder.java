package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.base.EducationalTimeUnit;

@Component
public class EducationalTimeUnitBuilder extends EntityBuilder<EducationalTimeUnit> {

	@Override
	void initProduct() {
		this.product = new EducationalTimeUnit();
	}
	
	public EducationalTimeUnitBuilder unit(String name, Double baseUnits, String symbol, Boolean archived) {
		this.product.setName(name);
		this.product.setBaseUnits(baseUnits);
		this.product.setSymbol(symbol);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	EducationalTimeUnit assembleProduct() {
		return this.product;
	}

}
