package com.faz.springdi.dao;

/**
 * Contrat d'acces aux donnees.
 * Cette interface definit la methode de recuperation d'une valeur.
 */
public interface IAccesDonneesFzb {

    /**
     * Recupere une valeur numerique.
     * @return La valeur recuperee.
     */
    double extraireValeurFzb();
}