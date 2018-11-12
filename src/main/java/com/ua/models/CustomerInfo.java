package com.ua.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "customer")
@Entity
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerInfoId;

    public int getCustomerInfoId() {
        return customerInfoId;
    }

    //    --------------------------------------------------------
    @Column(unique = true)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    --------------------------------------------------------
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    //    --------------------------------------------------------
//    @Enumerated(EnumType.)
//    private Set<Role> roles;
//    public Set<Role> getRoles() {
//        return roles;
//    }
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//    public void setRole(Role role){
//        roles.add(role);
//    }
    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    --------------------------------------------------------
    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
//    --------------------------------------------------------
}
