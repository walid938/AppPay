package com.payMyBuddy.AppPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payMyBuddy.AppPay.model.ApplicationUser;
import com.payMyBuddy.AppPay.repository.ApplicationUserRepository;

@Service
public class UserService {
    private final ApplicationUserRepository userRepository;

    @Autowired
    public UserService(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApplicationUser registerUser(String email, String password) {
        validateEmail(email);
        validatePassword(password);

        ApplicationUser newUser = new ApplicationUser();
        newUser.setEmail(email);
        newUser.setPassword(password);

        return userRepository.save(newUser);
    }

    public ApplicationUser loginUser(String email, String password) {
        validateEmail(email);
        validatePassword(password);

        return userRepository.findByEmailAndPassword(email, password);
    }

    private void validateEmail(String email) {
    	 if (email == null || email.isEmpty()) {
    	        throw new IllegalArgumentException("L'e-mail ne peut pas être vide ou nul.");
    	    }

    	    // Exemple de validation simple : vérifier si l'e-mail a un format valide
    	    // Vous pouvez utiliser des expressions régulières ou une bibliothèque de validation d'e-mails
    	    if (!email.matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
    	        throw new IllegalArgumentException("Format d'e-mail non valide.");
    	    }
    }

    private void validatePassword(String password) {
    	 if (password == null || password.isEmpty()) {
    	        throw new IllegalArgumentException("Le mot de passe ne peut pas être vide ou nul.");
    	    }

    	    // Exemple de validation simple : vérifier si le mot de passe a une longueur minimale
    	    if (password.length() < 8) {
    	        throw new IllegalArgumentException("Le mot de passe doit contenir au moins 8 caractères.");
    	    }
    }
}
