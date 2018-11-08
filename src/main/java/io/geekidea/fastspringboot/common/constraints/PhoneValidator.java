package io.geekidea.fastspringboot.common.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 自定义手机号码验证注解实现类
 * @author liujixiang
 * @date 2018-11-08
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private static final String REG_EX = "^1[3,4,5,6,7,8,9]\\d{9}$";
	private static final Pattern PATTERN = Pattern.compile(REG_EX);

	@Override
	public void initialize(Phone parameters) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (value ==null){
			return true;
		}
		return PATTERN.matcher(value).matches();
	}
}
