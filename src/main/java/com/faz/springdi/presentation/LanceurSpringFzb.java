package com.faz.springdi.presentation;

import com.faz.springdi.metier.IMoteurMetierFzb;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Classe principale de lancement de l'application Spring.
 *
 * @Configuration : indique que cette classe contient des configurations Spring.
 * @ComponentScan : indique a Spring de scanner les packages specifies
 * pour y trouver les beans annotes (@Component, @Service, @Repository, etc.).
 *
 * Dans notre cas, on scanne :
 * - com.faz.springdi.dao (pour SourceLocaleFzb et SourceDistanteFzb)
 * - com.faz.springdi.metier (pour MoteurMetierFzb)
 */
@Configuration
@ComponentScan(basePackages = {
        "com.faz.springdi.dao",
        "com.faz.springdi.metier"
})
public class LanceurSpringFzb {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LANCEUR SPRING - PROJET SPRING-DI-FAZ          ");
        System.out.println("==================================================");

        // 1. Creation du contexte Spring (conteneur IoC) base sur les annotations
        ApplicationContext contexteFzb = new AnnotationConfigApplicationContext(LanceurSpringFzb.class);
        System.out.println("[Spring] Contexte IoC initialise.");

        // 2. Recuperation du bean IMoteurMetierFzb depuis le conteneur
        IMoteurMetierFzb moteurFzb = contexteFzb.getBean(IMoteurMetierFzb.class);
        System.out.println("[Spring] Bean IMoteurMetierFzb recupere : " + moteurFzb.getClass().getSimpleName());

        // 3. Execution de la methode metier
        double resultatFzb = moteurFzb.executerCalculFzb();
        System.out.println("\n[Resultat] Resultat = " + resultatFzb);

        System.out.println("\n==================================================");
        System.out.println("   FIN DU LANCEMENT SPRING                        ");
        System.out.println("==================================================");
    }
}