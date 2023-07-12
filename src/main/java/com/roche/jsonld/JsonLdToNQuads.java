package com.roche.jsonld;

import com.apicatalog.jsonld.JsonLd;
import com.apicatalog.jsonld.document.JsonDocument;
import com.apicatalog.rdf.RdfDataset;
import com.apicatalog.rdf.io.nquad.NQuadsWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.time.Instant;

public class JsonLdToNQuads {

    public static void main(String[] args) throws Exception {

        Instant start = Instant.now();

        RdfDataset rdfDataset = JsonLd.toRdf(JsonDocument.of(new FileReader("C:\\Users\\MAJEWSK6\\Downloads\\data.json"))).get();

        new NQuadsWriter(new FileWriter("C:\\Users\\MAJEWSK6\\Downloads\\data.nq"))
                .write(rdfDataset);

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.printf("JSON-LD to NQ parsing took %s milliseconds%n", timeElapsed);

    }

}
