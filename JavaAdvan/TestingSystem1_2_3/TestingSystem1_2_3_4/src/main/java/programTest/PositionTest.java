package programTest;

import entity.Position;
import repository.PositionRepository;

import java.util.List;

public class PositionTest {

    public static void main(String[] args) {

        PositionRepository positionRepository = new PositionRepository();

        List<Position> positionList = positionRepository.getAllPosition();

        for(Position elem : positionList){
            System.out.println(elem.getPositionID()+"-"+elem.getPositionName());
        }
    }
}
