package com.payMyBuddy.AppPay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payMyBuddy.AppPay.model.ApplicationUser;
import com.payMyBuddy.AppPay.model.Person;
import com.payMyBuddy.AppPay.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonsByUser(ApplicationUser user) {
        return personRepository.findByUserId(user.getId());
    }

    public Person addPerson(ApplicationUser user, String firstName, String lastName, String email, String phone) {
        // Logique de validation et ajout d'une nouvelle personne associée à l'utilisateur
        
        Person newPerson = new Person();
        newPerson.setUser(user);
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setEmail(email);
        newPerson.setPhone(phone);

        return personRepository.save(newPerson);
    }

    // Ajoutez d'autres méthodes liées à la logique métier des personnes
}
