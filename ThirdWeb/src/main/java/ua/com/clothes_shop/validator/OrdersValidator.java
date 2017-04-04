package ua.com.clothes_shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.clothes_shop.entity.Orders;
import ua.com.clothes_shop.service.OrdersService;

public class OrdersValidator implements Validator{
	
    private final OrdersService ordersService;
    
	public OrdersValidator(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Orders.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Orders orders = (Orders) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "Can't be empty");
	}

}
