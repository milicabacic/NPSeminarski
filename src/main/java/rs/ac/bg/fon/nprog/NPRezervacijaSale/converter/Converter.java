package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;
/**
 * Interfejs koji definise metode za konverzije izmedju domenskih i dto objekata
 * 
 * @author Milica Bacic
 *
 * @param <D> - Genericki parametar koji predstavlja dto klasu koja se prevodi u domensku
 * @param <E> - Genericki parametar koji predstavlja domensku klasu koja se prevodi u dto objekat
 */
public interface Converter<D,E> {
	/**
	 * Metoda koja domenski objekat prevodi u dto objekat
	 * 
	 * @param e Domenski objekat
	 * @return Vraca dto objekat za dati domenski objekat
	 */
	D toDto(E e);
	
	/**
	 * Metoda koja prevodi dto objekat u domenski
	 * 
	 * @param d Dto objekat 
	 * @return Vraca domenski objekat za dati dto objekat
	 */
	E toEntity(D d);

}
