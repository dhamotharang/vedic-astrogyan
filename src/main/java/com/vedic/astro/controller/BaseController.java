package com.vedic.astro.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.ErrorConstants;
import com.vedic.astro.exception.SystemException;

/**
 * Base controller of all Spring MVC controllers.
 * 
 */

public class BaseController {

	@Autowired
	@Qualifier("messageSource")
	private MessageSource messageSource;

	/**
	 * Exception handler for catching field errors.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public RestServiceResult<String> processValidationError(
			MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldError(fieldErrors);
	}

	/**
	 * Exception handler for catching field errors.
	 * 
	 * @param ex
	 * @return
	 */
/*	@ExceptionHandler(InvalidAddressException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public RestServiceResult<String> processAddressValidationError(
			InvalidAddressException ex) {
		List<FieldError> fieldErrors = ex.getFieldErrors();

		return processFieldError(fieldErrors);
	}
*/
	/**
	 * Processes all the field errors and wraps it into a ValidationError
	 * object.
	 * 
	 * @param fieldErrors
	 * @return
	 */
	private RestServiceResult<String> processFieldError(
			List<FieldError> fieldErrors) {
		RestServiceResult<String> result = new RestServiceResult<String>();
		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ErrorConstants.INVALID_INPUT_CODE);
		reason.setErrorMessage(ErrorConstants.INVALID_INPUT_MESSAGE);

		for (FieldError fieldError : fieldErrors) {

			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			reason.addError(new AttributeError(fieldError.getField(),
					localizedErrorMessage));
		}

		result.setFailureReason(reason);
		result.setResponseStatus(RestServiceStatus.FAILURE);

		return result;
	}

	/**
	 * Resolves the error message for the given field error from message source.
	 * 
	 * @param fieldError
	 * @return
	 */
	private String resolveLocalizedErrorMessage(FieldError fieldError) {

		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError,
				currentLocale);

		return localizedErrorMessage;
	}

	/**
	 * Exception handler for catching field errors.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public RestServiceResult<String> processBusinessError(BusinessException ex) {

		RestServiceResult<String> result = new RestServiceResult<String>();

		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ex.getErrorCode());
		reason.setErrorMessage(ex.getErrorMessage());

		result.setFailureReason(reason);
		result.setResponseStatus(RestServiceStatus.FAILURE);

		return result;

	}

	/**
	 * Exception handler for catching field errors.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(SystemException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public RestServiceResult<String> processSystemError(SystemException ex) {

		RestServiceResult<String> result = new RestServiceResult<String>();

		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ErrorConstants.SYSTEM_FAILURE_CODE);

		if (ex.getClass() != null) {
			reason.setErrorMessage(ex.getCause().getMessage());
		}

		result.setFailureReason(reason);
		result.setResponseStatus(RestServiceStatus.FAILURE);

		return result;

	}

	/**
	 * Exception handler for catching field errors.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public RestServiceResult<String> processOtherError(Exception ex) {

		RestServiceResult<String> result = new RestServiceResult<String>();

		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ErrorConstants.SYSTEM_FAILURE_CODE);

		if ((ex!=null) && (ex.getClass() != null)) {
			reason.setErrorMessage(ex.getCause().getMessage());
		}

		result.setFailureReason(reason);
		result.setResponseStatus(RestServiceStatus.FAILURE);

		return result;

	}
	
	
/*	protected void validateAddress(Address address) throws InvalidAddressException{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		List<Class<?>> groupes = new ArrayList<Class<?>>();

		if (address.isUS()) {
			groupes.add(USValidation.class);
		} else {
			groupes.add(NonUSValidation.class);
		}
		Set<ConstraintViolation<Address>> validationResult = validator
				.validate(address, groupes.toArray(new Class[0]));

		if (!validationResult.isEmpty()) {
			List<FieldError> fieldErrors = new ArrayList<FieldError>(
					validationResult.size());
			for (ConstraintViolation<Address> validationError : validationResult) {
				String fieldName = validationError.getPropertyPath().toString();
				FieldError fieldError = new FieldError(address.getClass()
						.getName(), fieldName, "Field should not be empty");
				fieldErrors.add(fieldError);
			}
			throw new InvalidAddressException(fieldErrors);
		}
	}*/
}
