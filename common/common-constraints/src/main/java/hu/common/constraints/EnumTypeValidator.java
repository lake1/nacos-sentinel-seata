
package hu.common.constraints;


import hu.common.enums.BaseTypeStateEnum;
import hu.common.exception.BusinessException;
import hu.common.util.EnumUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义系统内的枚举验证注解实现类
 *
 * @date 2018-11-08
 */
public class EnumTypeValidator implements ConstraintValidator<EnumType, Integer> {

	private Class<? extends BaseTypeStateEnum> baseTypeStateEnum;

	private EnumType enumType;


	@Override
	public void initialize(EnumType parameters) {

		baseTypeStateEnum = parameters.type();
		if (baseTypeStateEnum == null){
			throw new BusinessException("请传入枚举类型类");
		}
		enumType = parameters;
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
		if (value == null && enumType.skip()) {
			return true;
		}
		return EnumUtil.exists(baseTypeStateEnum,value);
	}
}
