package scand.by.test.pojo;

import java.io.Serializable;
import java.util.List;

public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;

    private List< Employee > employees;
    private List< Report > reports;

    public Project() {
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

    public String getDescription() {

        return description;
    }

    public void setDescription( String description ) {

        this.description = description;
    }

    public List< Employee > getEmployees() {

        return employees;
    }

    public void setEmployees( List< Employee > employees ) {

        this.employees = employees;
    }

    public List< Report > getReports() {

        return reports;
    }

    public void setReports( List< Report > reports ) {

        this.reports = reports;
    }

    @Override
    public boolean equals(Object o) {

        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Project project = ( Project ) o;

        if ( !description.equals( project.description ) ) return false;
        if ( !id.equals( project.id ) ) return false;
        if ( !name.equals( project.name ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();

        return result;
    }

    @Override
    public String toString() {

        return "Project{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
