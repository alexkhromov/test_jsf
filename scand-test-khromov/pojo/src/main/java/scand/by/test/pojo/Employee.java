package scand.by.test.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date hireDate;
    private String position;
    private Integer salary;

    private List< Project > projects;
    private List< Report > reports;

    public Employee() {
    }

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }

    public Date getHireDate() {

        return hireDate;
    }

    public void setHireDate( Date hireDate ) {

        this.hireDate = hireDate;
    }

    public String getPosition() {

        return position;
    }

    public void setPosition( String position ) {

        this.position = position;
    }

    public Integer getSalary() {

        return salary;
    }

    public void setSalary( Integer salary ) {

        this.salary = salary;
    }

    public List< Project > getProjects() {

        return projects;
    }

    public void setProjects( List< Project > projects ) {

        this.projects = projects;
    }

    public List< Report > getReports() {

        return reports;
    }

    public void setReports( List< Report > reports ) {

        this.reports = reports;
    }

    @Override
    public boolean equals( Object o ) {

        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Employee employee = ( Employee ) o;

        if ( !hireDate.equals( employee.hireDate ) ) return false;
        if ( !id.equals( employee.id ) ) return false;
        if ( !name.equals( employee.name ) ) return false;
        if ( !position.equals( employee.position ) ) return false;
        if ( !salary.equals( employee.salary ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + hireDate.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + salary.hashCode();

        return result;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                ", position='" + position + '\'' +
                '}';
    }
}
