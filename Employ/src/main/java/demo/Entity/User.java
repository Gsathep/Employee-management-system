package demo.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    @ElementCollection
    @CollectionTable(
            name = "test",
            joinColumns = @JoinColumn(name="id")
    )
    @Column(name = "Role")
    private Set <String> Roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return Roles;
    }

    public void setRoles(Set<String> roles) {
        Roles = roles;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Roles=" + Roles +
                '}';
    }

    public User(Long id, String username, String password, String email, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        Roles = roles;
    }

    public void get() {
    }
}
