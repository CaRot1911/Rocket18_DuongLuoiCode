package enumConfig;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryConverter implements AttributeConverter<SalaryEnum,String> {


    @Override
    public String convertToDatabaseColumn(SalaryEnum name) {
        if(name == null){
            return null;
        }
        return name.getStatus();
    }

    @Override
    public SalaryEnum convertToEntityAttribute(String s) {
        if(s == null){
            return null;
        }
        return SalaryEnum.toEnum(s);
    }
}
