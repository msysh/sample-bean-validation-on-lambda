package msysh.test.validationonlambda;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {
	
	private static ObjectMapper mapper = new ObjectMapper().registerModule(new AfterburnerModule()).enable(Feature.WRITE_BIGDECIMAL_AS_PLAIN);
	
	@Override
	public String handleRequest(Object input, Context context) {
		LambdaLogger logger = context.getLogger();
		
		String inputJson = "{"
				+ "\"list\": [1, 5], "		// Min(5) Max(10)
				+ "\"num\": 10, "			// Min(5) Max(10)
				+ "\"str\": \"abc\", "
				+ "\"child\" : {"
					+ "\"list\": [1, 5]"	// Min(5) Max(10)
				+ "}}";
		logger.log("Input: " + inputJson);
		
		try {
			Input inputObj = parse(Input.class, inputJson);
			logger.log("Parsed input object : " + inputObj);
			
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
	
			Set<ConstraintViolation<Object>> results = validator.validate(inputObj);
			logger.log("Validation Error : " + results.size());
			
			for (ConstraintViolation<Object> result : results) {
				logger.log(result.getPropertyPath() + " : " + result.getMessage());
			}
		}
		catch (Exception e) {
			context.getLogger().log(e.getMessage());
		}

		return "Done.";
	}
	
	private <T> T parse(Class<T> clazz, String json) throws Exception  {
		return (T) mapper.readValue(json, clazz);
	}
}
