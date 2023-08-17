package com.danielbrai.gymtonic.enablers;

public interface BaseMapper <I, O> {

    O traduzir(I input);
}
