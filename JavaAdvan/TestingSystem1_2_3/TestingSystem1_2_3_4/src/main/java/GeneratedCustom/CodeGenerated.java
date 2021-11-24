package GeneratedCustom;

import entity.Exam;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import repository.ExamRepository;

import java.io.Serializable;

public class CodeGenerated implements IdentifierGenerator {

    private ExamRepository examRepository;

    public CodeGenerated(){
        examRepository = new ExamRepository();

    }
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

        Exam exam = (Exam) object;

        String pra;

        if (exam.getDuration() >= 180){
           pra = "L";

        }else if (90 <= exam.getDuration()){
            pra = "M";
        }else {
            pra = "S";
        }
        int count = examRepository.getTypeByDuration(exam.getDuration());
        return pra + "-" +(count + 1);
    }
}
