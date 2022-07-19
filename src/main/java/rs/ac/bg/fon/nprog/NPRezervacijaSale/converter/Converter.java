package rs.ac.bg.fon.nprog.NPRezervacijaSale.converter;

public interface Converter<D,E> {
	
	D toDto(E e);
	
	E toEntity(D d);

}
