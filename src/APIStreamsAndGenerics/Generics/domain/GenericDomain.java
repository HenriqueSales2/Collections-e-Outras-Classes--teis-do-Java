package APIStreamsAndGenerics.Generics.domain;

import java.util.Objects;

public interface GenericDomain<T> {



     T getId();
     void setId(final T id);


}
