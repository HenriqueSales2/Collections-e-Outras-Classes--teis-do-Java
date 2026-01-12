package APIStreamsAndGenerics.Generics.dao;

import APIStreamsAndGenerics.Generics.domain.GenericDomain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class GenericDAO<ID, T extends GenericDomain<ID>> {

    private List<T> db = new ArrayList<>();

    private T save(T domain) {
        db.add(domain);
        return domain;
    }

    public boolean save(int batch, T... domains) { // essa variavel vai ser tratada com um array, usando var args que no possibilita passar vários argumentos para nosso método
        System.out.printf("Salvando em lote (%s)\n", batch);
        return  db.addAll(Arrays.stream(domains).toList()); // esse método nos possibilita adicionar quantos usuários quisermos

    }

    public T update(ID id, T domain) {
        var stored = find(d -> d.getId().equals(id)).orElseThrow(); // vai lançar uma excecão se passar algo que não esteja cadastrado
        db.remove(stored);
        return save(domain);
    }

    public boolean delete(T domain) {
        return db.remove(domain);
    }

    public Optional<T> find(Predicate<T> filterCallback) {
        return db.stream()
                .filter(filterCallback)
                .findFirst();
    }

    public Optional<T> findById(ID id) {
        return find((d -> d.getId().equals(id)));
    }

    public List<T> findAll() {
        return db;
    }

    public int count() {
        return db.size();
    }
}
