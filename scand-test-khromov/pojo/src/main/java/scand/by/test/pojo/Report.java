package scand.by.test.pojo;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Employee employee;
    private Project project;
    private Date createDate;
    private String body;

    public Report() {
    }

    public Long getId() {

        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }

    public Employee getEmployee() {

        return employee;
    }

    public void setEmployee( Employee employee ) {

        this.employee = employee;
    }

    public Project getProject() {

        return project;
    }

    public void setProject( Project project ) {

        this.project = project;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public void setCreateDate( Date createDate ) {

        this.createDate = createDate;
    }

    public String getBody() {

        return body;
    }

    public void setBody( String body ) {

        this.body = body;
    }

    @Override
    public boolean equals( Object o ) {

        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        Report report = (Report) o;

        if ( !body.equals( report.body ) ) return false;
        if ( !createDate.equals( report.createDate ) ) return false;
        if ( !id.equals( report.id ) ) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + createDate.hashCode();
        result = 31 * result + body.hashCode();

        return result;
    }

    @Override
    public String toString() {

        return "Report{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", body='" + body + '\'' +
                '}';
    }
}
