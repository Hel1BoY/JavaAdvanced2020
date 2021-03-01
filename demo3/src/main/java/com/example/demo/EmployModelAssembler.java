package com.example.demo;

public class EmployModelAssembler implements RepresentationModelAssembler<Employee,EntityModel<Employee>>{

    public EntityModel<Employee> toModel(Employee entity){
        return EntityModel.of(entity,linkTo(me))
    }

}
