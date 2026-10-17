package metier;

/**
 * Contrat metier du microservice.
 * Definit la methode de calcul metier.
 */
public interface IMoteurMetierFzb {

    /**
     * Effectue le calcul metier.
     * @return Le resultat du calcul.
     */
    double executerCalculFzb();
}