package questLog.services;

import org.springframework.stereotype.Service;
import questLog.entities.Calculation;

@Service
public class CalculatorService {


    //Add
    public Calculation add(Calculation calculation) {
        /*
            Takes in a calculation entity
            Takes the value from opA
            Takes the value from opB
            adds the values from opA and opB together
            Stores the results in the result field of the calculation entity
            return the updated calculation entity to the caller.
         */
        int a, b;
        a = calculation.getOpA();
        b = calculation.getOpB();
        int sum = a + b;

        calculation.setResult(sum);

        return calculation;
    }
    //Subtract
    public Calculation subtract(Calculation calculation) {
        /*
            Takes in a calculation entity
            Takes the value from opA
            Takes the value from opB
            subtracts the values from opA and opB together
            Stores the results in the result field of the calculation entity
            return the updated calculation entity to the caller.
         */
        int a, b;
        a = calculation.getOpA();
        b = calculation.getOpB();
        int sum = a - b;

        calculation.setResult(sum);

        return calculation;
    }
    //Multiply

    //Divide
}
