package org.n3r.importer;

public interface RandomCodeStrategy {
    void init();

    int prefix();

    int next();

    void release();
}
