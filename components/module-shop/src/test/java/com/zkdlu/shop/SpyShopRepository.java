package com.zkdlu.shop;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

class SpyShopRepository implements ShopRepository {
    public List<Shop> findAll_returnValue;
    public long findById_argumentShopId;
    public Optional<Shop> findById_returnValue = Optional.empty();

    @Override
    public List<Shop> findAll() {
        return findAll_returnValue;
    }

    @Override
    public List<Shop> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Shop> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Shop> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Shop entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Shop> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Shop> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Shop> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Shop> findById(Long aLong) {
        findById_argumentShopId = aLong;
        return findById_returnValue;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Shop> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Shop> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Shop> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Shop getOne(Long aLong) {
        return null;
    }

    @Override
    public Shop getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Shop> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Shop> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Shop> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Shop> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Shop> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Shop> boolean exists(Example<S> example) {
        return false;
    }
}
