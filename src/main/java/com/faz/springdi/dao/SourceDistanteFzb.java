package com.faz.springdi.dao;

import org.springframework.stereotype.Component;

/**
 * Seconde implementation de IAccesDonneesFzb.
 * Retourne une valeur simulant une source distante (ex: API REST).
 *
 * L'annotation @Component avec l'identifiant "sourceDistanteFzb"
 * permet de differencier cette implementation de la premiere.
 */
@Component("sourceDistanteFzb")
public class SourceDistanteFzb implements IAccesDonneesFzb {

    @Override
    public double extraireValeurFzb() {
        // Simulation : retourne une valeur fixe de 150.0
        System.out.println("[SourceDistanteFzb] Extraction distante : 150.0");
        return 150.0;
    }
}