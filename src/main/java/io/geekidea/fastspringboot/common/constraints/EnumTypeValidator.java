package io.geekidea.fastspringboot.common.constraints;

import io.geekidea.fastspringboot.common.enums.BaseTypeStateEnum;
import io.geekidea.fastspringboot.common.exception.BusinessException;
import io.geekidea.fastspringboot.util.EnumUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义系统内的枚举验证注解实现类
 * @author liujixiang
 * @date 2018-11-08
 */
public class EnumTypeValidator implements ConstraintValidator<EnumType, Integer> {

	private Class<? extends BaseTypeStateEnum> baseTypeStateEnum;

	@Override
	public void initialize(EnumType parameters) {
		baseTypeStateEnum = parameters.type();
		if (baseTypeStateEnum == null){
			throw new BusinessException("请传入枚举类型类");
		}
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
		if (value ==null){
			return true;
		}
		return EnumUtil.exists(baseTypeStateEnum,value);
	}
}
