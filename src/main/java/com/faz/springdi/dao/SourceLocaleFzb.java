package com.faz.springdi.dao;

import org.springframework.stereotype.Component;

/**
 * Premiere implementation de IAccesDonneesFzb.
 * Retourne une valeur simulant une source locale (ex: base de donnees).
 *
 * L'annotation @Component indique a Spring de gerer cette classe
 * comme un bean dans le conteneur IoC. L'identifiant "sourceLocaleFzb"
 * permet de la referencer si necessaire.
 */
@Component("sourceLocaleFzb")
public class SourceLocaleFzb implements IAccesDonneesFzb {

    @Override
    public double extraireValeurFzb() {
        // Simulation : retourne une valeur fixe de 100.0
        System.out.println("[SourceLocaleFzb] Extraction locale : 100.0");
        return 100.0;
    }
}