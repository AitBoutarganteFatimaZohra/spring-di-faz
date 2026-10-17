package metier;

import com.faz.springdi.dao.IAccesDonneesFzb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementation de IMoteurMetierFzb.
 *
 * L'annotation @Component("moteurMetierFzb") declare cette classe
 * comme un bean Spring gere par le conteneur IoC.
 *
 * L'annotation @Autowired sur le champ sourceFzb demande a Spring
 * d'injecter automatiquement une implementation de IAccesDonneesFzb.
 *
 * L'annotation @Qualifier("sourceLocaleFzb") precise QUELLE implementation
 * injecter (car il y en a deux : sourceLocaleFzb et sourceDistanteFzb).
 */
@Component("moteurMetierFzb")
public class MoteurMetierFzb implements IMoteurMetierFzb {

    /**
     * Dependance injectee par Spring.
     * @Qualifier("sourceLocaleFzb") force l'injection de SourceLocaleFzb.
     *
     * Pour utiliser SourceDistanteFzb, remplacez par :
     * @Qualifier("sourceDistanteFzb")
     */
    @Autowired
    @Qualifier("sourceLocaleFzb")
    private IAccesDonneesFzb sourceFzb;

    @Override
    public double executerCalculFzb() {
        if (sourceFzb == null) {
            throw new IllegalStateException("La source n'a pas ete injectee !");
        }
        // Logique metier : multiplication par 3 (au lieu de 2)
        double valeurFzb = sourceFzb.extraireValeurFzb();
        double resultatFzb = valeurFzb * 3;
        System.out.println("[MoteurMetierFzb] Calcul : " + valeurFzb + " x 3 = " + resultatFzb);
        return resultatFzb;
    }

    /**
     * Setter pour l'injection par setter (alternative a l'injection par champ).
     * Spring peut aussi utiliser cette methode si configure ainsi.
     */
    public void setSourceFzb(IAccesDonneesFzb sourceFzb) {
        this.sourceFzb = sourceFzb;
    }

    /**
     * Getter pour verifier la source injectee (utile pour les tests).
     */
    public IAccesDonneesFzb getSourceFzb() {
        return sourceFzb;
    }
}