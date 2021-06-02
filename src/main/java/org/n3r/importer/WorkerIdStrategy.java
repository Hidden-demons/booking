package org.n3r.importer;

public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
