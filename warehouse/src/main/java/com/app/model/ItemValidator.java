package com.app.model;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class ItemValidator implements Validator{


	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item it=(Item) target;
		if (!Pattern.compile("[A-Z]{4,10}").matcher(it.getIcode()).matches()) {
			errors.rejectValue("itemCode", null, "Enter Valid Model[4 to 10 UpperCase Only]");
		}
		
		if(it.getVenUsers()==null||it.getVenUsers().isEmpty()) {
			errors.rejectValue("venUsers", null, "Please Select atleast one Vendor");
		}
		if(it.getCustUsers()==null||it.getCustUsers().isEmpty()) {
			errors.rejectValue("custUsers", null, "Please Select atleast one Customer");
		}
		if(it.getHeight()==0||0>it.getHeight())
		{
			errors.rejectValue("height", null, "Enter Valid Height Value");
		}
		if(it.getWidth()==0||0>it.getWidth())
		{
			errors.rejectValue("width", null, "Enter Valid Width Value");
		}
		if(it.getLength()==0||0>it.getLength())
		{
			errors.rejectValue("length", null, "Enter Valid Length Value");
		}
		if(it.getCost()==0||0>it.getCost())
		{
			errors.rejectValue("cost", null, "Enter Valid Cost Value");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"currency", null, "Please Select Currency Type");
		if(it.getUom().getId()==null) {
			errors.rejectValue("uom", null, "Please Select One Uom");
		}
		if(it.getSaleType().getId()==null) {
			errors.rejectValue("saleType", null, "Please Select One SaleType");
		}
		if(it.getPurchaseType().getId()==null) {
			errors.rejectValue("purcahseType", null, "Please Select Onew Purchase Type");
		}
		if (!Pattern.compile("[A-Za-z0-9\\.\\-\\_\\s]{10,200}").matcher(it.getDsc()).matches()) {
			errors.rejectValue("dsc", null,"Enter [10 to 200 Chars only and (. - _) special chars allowed ]");
			}
	}


	}


