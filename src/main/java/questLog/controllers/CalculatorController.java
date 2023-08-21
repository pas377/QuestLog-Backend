package questLog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import questLog.entities.Calculation;
import questLog.services.CalculatorService;

@RestController //i am now a restful controller
@RequestMapping("/calculation")
public class CalculatorController {
    @Autowired // make an instanciation of this class
    CalculatorService calculatorService;

    @PostMapping("/add")
    public Calculation add(@RequestBody Calculation calculation) {
        return calculatorService.add(calculation);
    }

    @PostMapping("/subtract")
    public Calculation subtract(@RequestBody Calculation calculation) {
        return calculatorService.subtract(calculation);
    }

}
