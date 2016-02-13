package com.jobmatch.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {
    @Size(min = 2, max = 30)
    private String username;

    @NotNull
    @Min(18)
    private Integer age;

    public String getName() {
        return this.username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.username + ", Age: " + this.age + ")";
    }
}
