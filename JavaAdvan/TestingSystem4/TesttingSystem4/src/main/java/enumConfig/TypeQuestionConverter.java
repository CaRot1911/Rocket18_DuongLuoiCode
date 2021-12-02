package enumConfig;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeQuestionConverter implements AttributeConverter<TypeQuesEnum,String> {
    @Override
    public String convertToDatabaseColumn(TypeQuesEnum typeQuestionEnum) {
        if(typeQuestionEnum == null){
            return null;
        }
        return typeQuestionEnum.getStatus();
    }

    @Override
    public TypeQuesEnum convertToEntityAttribute(String s) {
        if(s == null){
            return null;
        }
       return TypeQuesEnum.toEnum(s);
    }
}
