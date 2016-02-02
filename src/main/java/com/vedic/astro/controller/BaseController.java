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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public RestServiceResponse<String> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldError(fieldErrors);
	}

	/**
	 * Processes all the field errors and wraps it into a ValidationError
	 * object.
	 * 
	 * @param fieldErrors
	 * @return
	 */
	private RestServiceResponse<String> processFieldError(List<FieldError> fieldErrors) {
		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ErrorConstants.INVALID_INPUT_CODE);
		reason.setErrorMessage(ErrorConstants.INVALID_INPUT_MESSAGE);

		for (FieldError fieldError : fieldErrors) {

			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			reason.addError(new AttributeError(fieldError.getField(), localizedErrorMessage));
		}

		return new RestServiceResponse<String>(false, reason);
	}

	/**
	 * Resolves the error message for the given field error from message source.
	 * 
	 * @param fieldError
	 * @return
	 */
	private String resolveLocalizedErrorMessage(FieldError fieldError) {

		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

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
	public RestServiceResponse<String> processBusinessError(BusinessException ex) {

		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ex.getErrorCode());
		reason.setErrorMessage(ex.getErrorMessage());

		return new RestServiceResponse<String>(false, reason);

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
	public RestServiceResponse<String> processSystemError(SystemException ex) {

		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ErrorConstants.SYSTEM_FAILURE_CODE);

		if (ex.getClass() != null) {
			reason.setErrorMessage(ex.getCause().getMessage());
		}

		return new RestServiceResponse<String>(false, reason);

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
	public RestServiceResponse<String> processOtherError(Exception ex) {

		RestServiceFailureReason reason = new RestServiceFailureReason();
		reason.setErrorCode(ErrorConstants.SYSTEM_FAILURE_CODE);

		if ((ex != null) && (ex.getClass() != null)) {
			reason.setErrorMessage(ex.getCause().getMessage());
		}

		return new RestServiceResponse<String>(false, reason);
	}
}
