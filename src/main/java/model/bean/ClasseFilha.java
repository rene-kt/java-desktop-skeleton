package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClasseFilha extends Pessoa {
    
    private String email;

    public ClasseFilha() {
        setFuncao("Cliente");
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Column
    public String getNome() {
        return super.getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Column
    public String getCpf() {
        return super.getCpf(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Column
    public String getFuncao() {
        return super.getFuncao(); 
    }

     
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
